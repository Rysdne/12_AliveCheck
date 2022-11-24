#===============================================

1. 프로젝트 목적
1) 호스트들의 Alive 상태 체크 및 모니터링 API 서버 개발
 - 호스트를 조회, 등록, 수정, 삭제할 수 있는 REST API 제공
 - 등록된 호스트의 Alive 상태를 모니터링할 수 있는 API 제공

------------------------------------------------ 
 
2. 프로젝트 정보
 @ 사용 환경
 - IDE : Spring Tool Suite 4 4.15.3.RELEASE
 - DB : MariaDB 10.9
 - Project : Spring Starter Project
 - Packaging : Jar
 - Project type : Gradle
 - Java version : 8
 - 테스트 프로그램 : Chrome, Talend API Tester
   - Talend API Tester : 서버에 GET, POST, PUT, DELETE 명령을 내릴 수 있는 Chrome 확장 프로그램
 
------------------------------------------------
 
3. 프로젝트 사용 방법
 - 테스트
   - 프로젝트 실행 후 Chrome 웹 브라우저 실행
   - 확장 프로그램 Talend API Tester 설치 후 실행
   - Tester 페이지 상단 METHOD 항목을 변경하고 BODY 부분에 입력할 내용을 변경해가면서 테스트


   1) POST
    @ 신규 등록의 경우
    - Method : POST
    - URL : http://localhost:8080/hosts
    - HEADERS : Content-Type : application/json 
    - BODY : {"ip":"<호스트ip>","name":"<호스트name>"}
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ 입력 IP와 이름으로 등록된 내역이 있는 경우
    - 결과 : {"result": "FAIL","reason": "Already exist"}

    @ 이미 등록된 호스트 수가 100개일 경우
    - 결과 : {"result": "FAIL","reason": "Table is full"}


   2) GET
    @ 전체 출력
    - Method : GET
    - URL : http://localhost:8080/hosts
    - HEADERS : 미입력
    - BODY : 미입력
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ IP로 찾기
    - Method : GET
    - URL : http://localhost:8080/hosts/ip/<호스트ip>
    - HEADERS : 미입력
    - BODY : 미입력
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ 이름으로 찾기
    - Method : GET
    - URL : http://localhost:8080/hosts/name/<호스트name>
    - HEADERS : 미입력
    - BODY : 미입력
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인
    
    @ 찾는 호스트가 없을 경우
    - 결과 : null

   3) PUT
    @ 이름으로 찾고 IP를 변경
    - Method : PUT
    - URL : http://localhost:8080/hosts
    - HEADERS : Content-Type : application/json
    - BODY : {"target":"ip","ip":"<호스트ip>","name":"<호스트name>"}
      - "target" 값이 "ip"인 경우, "<호스트name>"으로 호스트를 찾고 ip 컬럼을 "<호스트ip>" 값으로 변경
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ IP로 찾고 이름을 변경
    - Method : PUT
    - URL : http://localhost:8080/hosts
    - HEADERS : Content-Type : application/json
    - BODY : {"target":"name","ip":"<호스트ip>","name":"<호스트name>"}
      - "target" 값이 "name"인 경우, "<호스트ip>"로 호스트를 찾고 name 컬럼을 "<호스트name>" 값으로 변경
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ "target"과 매칭된 값이 "ip"나 "name"이 아닌 경우
    - 결과 : {"result": "FAIL","reason": "Invalid target"}

    @ "ip"나 "name"에 공백이 기입된 경우
    - 결과 : {"result": "FAIL","reason": "Input is Null"}

    @ 해당 호스트가 존재하지 않는 경우
    - 결과 : {"result": "FAIL","reason": "Not Exist"}


   4) DELETE
    @ IP로 삭제
    - Method : DELETE
    - URL : http://localhost:8080/hosts/ip/<호스트ip>
    - HEADERS : 미입력
    - BODY : 미입력
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ 이름으로 삭제
    - Method : DELETE
    - URL : http://localhost:8080/hosts/name/<호스트name>
    - HEADERS : 미입력
    - BODY : 미입력
    - 실행 : 내용 입력 후 Send 버튼
    - 결과 : 아래의 Response 부분에 실행 결과 확인

    @ 해당 호스트가 존재하지 않는 경우
    - 결과 : {"result": "FAIL","reason": "Not Exist"}


   5) Alive 모니터링
    - 스케줄러를 통해 등록된 호스트에 한해 isReachable() 메서드를 1000ms 간격으로 호출
    - 등록된 호스트의 상태가 변경될 경우 해당 변화를 서버 콘솔 창에 출력
      - <호스트name>(<호스트ip>) turned [On|Off] 형태로 출력
      - 예시) RysdnePC(10.10.10.251) turned On
    - 모든 스케줄러는 비동기식으로 동작
    - 호출된 결과에 따라 DB 정보를 수정
    
    @ isReachable()값이 true인 경우
    - 기존 "isAlive" 컬럼 값이 false인 경우에만 해당 컬럼 값을 true로 수정
    - "LastAlive" 컬럼 값을 현재 시간으로 수정

    @ isReachable()값이 false인 경우
    - 기존 "isAlive" 컬럼 값이 true인 경우에만 해당 컬럼 값을 false로 수정 

------------------------------------------------ 

4. 제약 사항 및 이슈
1) Repository에서 @Getter @Setter 어노테이션이 동작하지 않음
 - HostRepository 클래스에서 해당 어노테이션이 동작하지 않음
 - 별도의 Getter Setter를 정의하여 임시 처리

2) 등록된 호스트 숫자에 따라 스케줄러 실행 간격이 늘어남
 - 호스트 10개 단위로 전체 스케줄러가 약 1초씩 지연되는 테스트 결과 확인
   - 10개까지는 1초 간격으로 DB가 갱신됨
   - 100개를 등록한 경우 약 11~12초 간격으로 DB가 갱신됨
 - 스케줄러가 비동기식으로 동작하고 있기 때문에 비기능적인 이슈라고 판단 중
   - 테스트 환경을 변화시킬 수 없어 처리 보류 중

#===============================================
# SpringBoot-Maven

### Maven 을 이용한 백엔드 기초 공부
2022-08-30
1. GetController 작성
    - @RequestParam : URL 창 파라매터
2. PostController 작성
    - @RequestBody : 객체를 요청받을 때 사용
3. Swagger 라이브러리 이용 문서 작성
   - http://localhost:8080/swagger-ui/index.html
4. Product 관련 클래스 작성 
   - Entity,Dto,Service,Repository,Dao,DataHandler


2022-09-01
1. Logger xml 작성 후 로그 확인
   - logback-spring.xml
2. Validation 유효성 검사
   - 들어오는 데이터에 대해 의도한 형식의 값이 제대로 들어오는지 체크하는 과정
   - 입력받는 클래스에 제약조건 어노테이션을 추가한 다음 컨트롤러에서 @Valid 어노테이션 추가
# Spring-review
병원정보 데이터를 게시판형식으로 만들어서 리뷰, 회원가입 기능 추가하는 실습코드입니다.

환경변수를 추가해줘야 합니다.

-> SPRING_DATASOURCE_PASSWORD=12345678;SPRING_DATASOURCE_URL=jdbc:mysql://@@@:3306/db-exercise

호출주소

아이디 생성하는 기능 username , password, email

POST -> http://localhost:8080/api/v1/users/join
Body ex)-> {
  "userName":"dmaqkvp" ,
  "password":"123qwe" ,
  "email":"dmaqkvp@vkfl.zja"
}

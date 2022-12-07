# Spring-review
병원정보 데이터를 게시판형식으로 만들어서 리뷰, 회원가입 기능 추가하는 실습코드입니다.

환경변수를 추가해줘야 합니다.

-> SPRING_DATASOURCE_PASSWORD=12345678;SPRING_DATASOURCE_URL=jdbc:mysql://@@@:3306/db-exercise

호출주소

아이디 생성하는 기능 username , password, email

POST -> http://localhost:8080/api/v1/users/join

Body 예시 ->
{
  "userName":"dmaqkvp" ,
  "password":"123qwe" ,
  "email":"dmaqkvp@vkfl.zja"
}

---

ERD

![스크린샷 2022-12-07 오후 1 17 26](https://user-images.githubusercontent.com/105894868/206087578-4840c935-9d8f-4271-bf43-55e05a8c4a2b.png)

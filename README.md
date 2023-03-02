# Board-Project
* Servlet & JSP 를 사용하는 게시판 웹 사이트입니다.

## 소개

### 사용 툴 & 기술
* IDE : IntelliJ ultimate
* server : tomcat 내장 서버
* 주요 기술 : Servlet, JSP, H2 Database, JDBC, gradle

### 프로젝트 구조
<img width="790" alt="image" src="https://user-images.githubusercontent.com/97227920/222411507-77723e9d-680d-42db-a07b-0039576a2173.png">


* DispatcherServlet : 모든 요청을 받는 서블릿이다. 받은 요청을 HandlerMapping에서 찾아 실행한다.
* HandlerMapping : DispatcherServlet으로부터 요청을 받아, 해당 요청을 처리할 수 있는 컨트롤러를 리턴한다.
* viewResolver : viewName을 받아, 경로로 변환해준다.
* controller : dispatcherServlet으로 받은 요청을 처리한다.
* JSP : 뷰를 담당하며, 컨트롤러로부터 데이터를 받아 뷰를 구현한다.
* DAO : 데이터 접근 객체로 조건에 맞는 데이터를 VO 객체로 리턴한다.
* DBController : DB 컨트롤러로 기본적인 select, update, insert, delete 함수가 구현되어 있다.
* DBUtil : 데이터베이스 접근에 필요한 기능 제공 클래스이다.

### 데이터 IE표기
<img width="498" alt="Pasted Graphic" src="https://user-images.githubusercontent.com/97227920/221395702-27ba0624-a345-487a-b7c8-05c14f1086a1.png">

# Board-Project
* Servlet & JSP을 기반으로 만든 게시판 웹 사이트입니다.

## 기술 및 구현 소개

### 사용 툴 & 기술
* IDE : IntelliJ ultimate
* server : tomcat 내장 서버
* 주요 기술 : Servlet, JSP, H2 Database, JDBC, gradle

### 프로젝트 구조
<img width="790" alt="image" src="https://user-images.githubusercontent.com/97227920/222411507-77723e9d-680d-42db-a07b-0039576a2173.png">
<이미지1 : 프로젝트 구조>

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
<이미지2 : 데이터 IE>

### 데이터베이스 연결 로직
<img width="315" alt="image" src="https://user-images.githubusercontent.com/97227920/222437971-473288e5-87e5-48da-88a1-70e65351503d.png">
<이미지3 : 데이터베이스 연결 로직>

* 기존의 JDBC는 중복되는 코드가 많아, 코드 중복을 제거하고, 체계적으로 db를 접근하고자 하였습니다.
* JDBCUtil은 H2 데이터베이스와의 연결과 종료 로직을 담당하는 클래스입니다.
* DBController는 JDBCUtil을 사용하여 select, update, insert, delete 메서드를 구현합니다.
* update, insert, delete는 데이터 리턴이 없어 void로 작성하였지만, select는 주어진 쿼리문에 따라, DAO에 따라 리턴값이 달라지는 특징이 있습니다. (코드 1 참고)
* 따라서, 리턴값을 추출하는 DBExtractor 인터페이스를 만든 뒤 구현체를 리턴하는 메서드를 DAO에 만들었습니다.(코드 2 참고)


```
public static List select(String query, DBExtractor function , String... args){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<?> list = null;

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);

            for(int i = 1 ; i <= args.length; i++){
                stmt.setString(i, args[i - 1]);
            }

            rs = stmt.executeQuery();
            list = function.getList(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }

        return list;
    }
```
<코드 1 : DBController의 select 메서드>


```
@Override
    public DBExtractor<UserVO> getAllExtractor(){
        return new DBExtractor<UserVO>() {
            @Override
            public List<UserVO> getList(ResultSet rs) throws SQLException {
                List<UserVO> userVOList = new ArrayList<>();

                while (rs.next()) {
                    UserVO userVO = new UserVO();
                    userVO.setId(rs.getLong("id"));
                    userVO.setEmail(rs.getString("email"));
                    userVO.setPassword(rs.getString("password"));
                    userVO.setName(rs.getString("name"));
                    userVO.setRole(rs.getString("role"));
                    userVO.setJoinDate(rs.getDate("joindate"));
                    userVOList.add(userVO);
                }

                return userVOList;
            }
        };
    }
```
<코드2 : UserDAO에서 DBExtractor 구현체를 리턴하는 getAllExtractor 메서드>


## 뷰 페이지 소개
![스크린샷 2023-03-02 오후 10 23 49](https://user-images.githubusercontent.com/97227920/222440755-e0d01536-5a2a-4a0e-8e17-157e3ccbc7a3.png)
<이미지 4 : 홈페이지>

![스크린샷 2023-03-02 오후 10 25 27](https://user-images.githubusercontent.com/97227920/222441116-2138b371-81f1-42ac-9d07-69da6e1abaa3.png)
<이미지 5 : 홈페이지>

![스크린샷 2023-03-02 오후 10 26 11](https://user-images.githubusercontent.com/97227920/222441314-2913c97c-2c67-41ee-b814-562a4aef5319.png)
<이미지 6 : 글 목록>

![스크린샷 2023-03-02 오후 10 26 47](https://user-images.githubusercontent.com/97227920/222441429-44839955-ee5c-4139-82b2-4c3c6753eee4.png)
<이미지 7 : 글 상세 페이지>

![스크린샷 2023-03-02 오후 10 27 14](https://user-images.githubusercontent.com/97227920/222441537-1fffdb08-a51f-4b4d-8028-1e1c41e411ad.png)
<이미지 8 : 마이 페이지>

![스크린샷 2023-03-02 오후 10 27 35](https://user-images.githubusercontent.com/97227920/222441649-043bd9e2-c1b6-4cb8-82a2-ec233fa199d4.png)
<이미지 9 : 글 작성 페이지>

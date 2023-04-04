# Resolve Circular Referecnes
* Servlet & JSP을 기반으로 만든 게시판 웹 사이트입니다.
</br>

## 프로젝트 소개

### 사용 툴 & 기술
* IDE : IntelliJ ultimate
* server : tomcat 내장 서버
* 주요 기술 : Servlet, JSP, H2 Database, JDBC, gradle
</br>

### 핵심 과제
* MVC 패턴의 적용
* 데이터베이스 코드 중복 감소
* 확장하기 쉬운 서비스 객체
</br>

## MVC 패턴의 적용

### 목표
* MVC 패턴을 통해 서버의 뷰와 비즈니스 로직을 분리하여 관심사를 분리한다.
</br>

### 구현
1. DispatcherServlet, HandlerMapping, viewResolver, Controller, Service 객체를 만들었습니다.
2. DispatcherServlet은 요청을 받아 HandlerMapping에게 적절한 Controller를 획득합니다.
3. Controller는 요청에 맞춰 Service 로직을 실행하게 됩니다.
4. Service는 싱글톤이며, 적절한 비즈니스 로직을 담당하게 됩니다.
</br>

### 프로젝트 구조
![image](https://user-images.githubusercontent.com/97227920/223716532-6f8118a2-391b-40f1-bcdf-f58c9ef9ec50.png)
</br>

## 데이터베이스 코드 중복 감소
### 목표
* JDBC로 데이터베이스를 연결할 때 코드 중복을 최소화한다.
</br>

### 구현
1. DBUtil, DBController, DBExtractor를 만들어 쿼리문과 변수만으로 DB 조작이 가능하도록 구성하였습니다.
2. DBUtil은 JDBC 연결과 연결 close()에 대한 static 메서드가 있는 클래스입니다.
3. DBController는 DBUtil을 사용하여, select, update, delete, insert 메서드를 구현하였습니다.
4. 가장 큰 고민은 select의 결과값이 쿼리마다 다르다는 점이었습니다. 저는 자바의 비교자 Comparator 인터페이스와 유사하게, DBExtractor라는 추출자 인터페이스를 만들고, 이에 대한 구현을 DAO가 하도록 설계했습니다.
</br>

### 코드
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
</br>

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
</br>

## 확장하기 쉬운 서비스 객체

### 목표
* 상호 의존 가능성은 낮추고, 동시에 서비스 객체의 코드 재사용성을 높혀 기능의 확장이 쉽도록 한다.
</br>

### 서비스 간 상호 의존 발생의 원인
* 서로 다른 서비스 A, B가 상호 의존한다는 의미는 A가 B의 서비스를 필요하고, B도 A의 서비스가 필요하다는 것이다. 이는 다음과 같은 경우가 존재한다.
```
1. A의  메서드a와 B의 메서드b가 서로 의존하는 경우
2. A의 메서드a1이 B의  메서드b1을 의존하고, B의 메서드 b2가 A의 메서드 b2를 의존하는 경우
```
* 1번의 경우는 정상적인 비즈니스 로직 상황에서 발생할 수 없다. 닭이 먼저인지 계란이 먼저인지와 같은 상황으로 기획에서 발생한 오류로 본다.
* 2번의 경우는 메서드 a1과 a2, b1과b2가 의존성 수준이 다르기 때문이다. 간단한 게시판 프로젝트의 UserService와 BoardService을 예로 들 수 있다.

```
a1, a2 : UserService에 속한 메서드 / b1, b2 : BoardService에 속한 메서드

a1 : UserService의 delete(Long id) 메서드는 유저를 삭제하는 기능을 담당하는데, 유저를 삭제하기 위해서는 유저가 작성한 글을 우선 삭제해야 한다.
a2 : UserService의 get(Long id) 메서드는 유저를 조회하는 기능을 담당한다.
b1 : BoardService의 delete(Long id, User user) 메서드는 글을 삭제하는 기능을 담당하는데, 글을 삭제하기 위해서는 글 작성자가 메서드 요청자가 맞는지 확인해야 한다.
b2 : BoardService의 write(Long id) 메서드는 글을 작성하는 기능을 담당하는데, 글을 작성하기 전에 유저를 검증해야 한다.

a1은 b1을 의존해야 하는 상황이며, b1은 a2를 의존해야 하며, b2는 a2를 의존해야 하는 상황이다. a1을 의존하는 메서드는 없는 반면, a2를 의존하는 메서드는 2개인 상황이다. 
문제는 의존성 수준이 다른 a1, a2가 같은 서비스 객체 안에 존재한다는 점이다.
```
</br>

### 해결 방안
* 의존 수준이 다른 메서드를 서로 다른 서비스로 분리할 수 있다. 다만, 의존 수준은 서비스가 늘어남에 따라 달라질 수 있다.
* 이러한 단점을 해결하고자 수학의 증명 과정을 적용했다.
* 이를 위해 모든 서비스는 하나의 가장 작은 기능을 구현한 메서드만을 갖게 된다.
* 모든 서비스는 가장 기본적인 서비스를 기반으로 만들어 진다.
* 가장 기본적인 서비스란 다른 서비스를 의존하지 않는 서비스를 의미한다.
</br>

### 서비스 구조
![image](https://user-images.githubusercontent.com/97227920/223718753-e4c62b66-e411-4f0a-9181-6ab44d09ee75.png)
<GetBoardService을 중심으로 나타낸 서비스 의존성>
</br>

![image](https://user-images.githubusercontent.com/97227920/223718858-c5c6d67e-4efa-4502-9cc7-24ab0b0dc5fe.png)
<DeleteUserService을 중심으로 나타낸 서비스 의존성>
</br>

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

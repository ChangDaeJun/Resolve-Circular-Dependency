# Resolve Circular Dependency
* This web site created based on Servlet & JSP.
</br>

## Intro.

### used tech and tool
* server : tomcat 10
* language : Java
* database : H2 database
* etc : Servlet, JSP, JDBC, gradle

</br>

### project goals
* used MVC pattern
* reduce code duplication in database
* resolve circular dependency
</br>

## used MVC pattern

### goal
* implement and adapt MVC pattern

</br>

### implement
1. Created DispatcherServlet, HandlerMapping, viewResolver, Controller, Service object.
2. DispatcherServlet accepts all requests.
3. Handler Mapping provides the appropriate controller at the request of the Dispatcher Servlet.
4. Controller will run Service logic.
5. service created in single tone and it is responsible for business logic.

</br>

### adapt
![image](https://user-images.githubusercontent.com/97227920/223716532-6f8118a2-391b-40f1-bcdf-f58c9ef9ec50.png)
</br>

## reduce code duplication in database


### goal
* reduce code duplication in database at JDBC.
</br>

### implement
1. Create DBUtil, DBController, DBExtractor objects that manipulate databases with query and variables.
2. DBUti has implemented a static method for JDBC connections and termination of connections.
3. DBC controller implemented the select, update, delete, insert methods using DBUtil.
4. The DBExtractor is an interface. Specifies the type that the DBCcontroller's select method returns. DAO implements DBExtractor.(This is similar to Java's Comparator interface.)

</br>

### adapt
<img width="734" alt="image" src="https://user-images.githubusercontent.com/97227920/229778778-e5c622e8-9dd1-4eed-9d93-c046309d6dc3.png">

</br>

### Codes
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
<코드 1 : DBController - select method>
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
<코드2 : UserDAO - getAllExtractor method implement DBExtrator>
</br>

## resolve circular dependency

### goal
* resolve circular dependency between services

</br>

### causes of circular dependency
* Different services A and B are cyclically dependent, meaning that A needs B's service, and B also needs A's service.
<img width="591" alt="image" src="https://user-images.githubusercontent.com/97227920/229782819-17a397e6-9345-4119-8c1d-39e380b36b60.png">

* Case 1 cannot occur in normal business logic situations. It is the same situation as whether the chicken comes first or the egg comes first.
* Case 2, method 1 and method 2 of service A have different dependence levels.
* If you consider the case where multiple service-dependent chains are circular dependency, check the following figure. It is entirely consistent with the above case.
<img width="590" alt="image" src="https://user-images.githubusercontent.com/97227920/229787848-c0ab46cb-6860-420c-9655-fbeb23e4aed5.png">
<img width="590" alt="image" src="https://user-images.githubusercontent.com/97227920/229787875-7da91b74-f016-460a-a03c-82f692216f2a.png">


</br>

### solutaion
* Methods with different levels of dependence must be separated into different services. But, It is difficult becuase the level of dependence is expected to change as the service expands.
* To solve this problem, All service had only one method with minimal functionality.

</br>

### service Example structure
<img width="824" alt="image" src="https://user-images.githubusercontent.com/97227920/229797347-7efee40e-f880-4e9d-be8e-2cb7ecfec694.png">

</br>
<img width="830" alt="image" src="https://user-images.githubusercontent.com/97227920/229797410-2f369ccc-e34f-4a39-bdb0-d5926fbe62e5.png">

</br>

## web page views

![스크린샷 2023-03-02 오후 10 23 49](https://user-images.githubusercontent.com/97227920/222440755-e0d01536-5a2a-4a0e-8e17-157e3ccbc7a3.png)
* image : home page

![스크린샷 2023-03-02 오후 10 25 27](https://user-images.githubusercontent.com/97227920/222441116-2138b371-81f1-42ac-9d07-69da6e1abaa3.png)
* image : login page

![스크린샷 2023-03-02 오후 10 26 11](https://user-images.githubusercontent.com/97227920/222441314-2913c97c-2c67-41ee-b814-562a4aef5319.png)
* image : board List

![스크린샷 2023-03-02 오후 10 26 47](https://user-images.githubusercontent.com/97227920/222441429-44839955-ee5c-4139-82b2-4c3c6753eee4.png)
* image : baord detail page

![스크린샷 2023-03-02 오후 10 27 14](https://user-images.githubusercontent.com/97227920/222441537-1fffdb08-a51f-4b4d-8028-1e1c41e411ad.png)
* image : my page

![스크린샷 2023-03-02 오후 10 27 35](https://user-images.githubusercontent.com/97227920/222441649-043bd9e2-c1b6-4cb8-82a2-ec233fa199d4.png)
* image : board write page

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>


<center>
  <h1>로그인</h1>
  <form action="loginUser.do" method="post">

    <table border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="orange">이메일</td>
        <td><input type="text" name="email" /></td>
      </tr>
      <tr>
        <td bgcolor="orange">비밀번호</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="로그인"/>
        </td>
      </tr>
    </table>
  </form>
  <br>
  <a href="insertUserView.do">회원 가입</a>
  <hr>
</center>

<%@ include file="../layout/footer.jsp"%>
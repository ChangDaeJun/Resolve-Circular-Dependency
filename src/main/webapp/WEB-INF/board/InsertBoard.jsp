<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>

<center>
  <form action="insertBoard.do" method="post">
    <table border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="orange" width="70">제목</td>
        <td align="left"><input type="text" name="title"/></td>
      </tr>
      <tr>
        <td bgcolor="orange">내용</td>
        <td align="left"><textarea name="text" clos ="40" rows="10"></textarea></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="새글등록"/>
        </td>
      </tr>
    </table>
  </form>
</center>

<%@ include file="../layout/footer.jsp"%>
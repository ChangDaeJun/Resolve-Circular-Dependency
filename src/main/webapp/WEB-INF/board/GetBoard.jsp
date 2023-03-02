<%@ page import="com.jsp.biz.board.BoardVO" %>
<%@ page import="com.jsp.biz.like.LikeVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
  BoardVO board = (BoardVO) request.getAttribute("board");
  UserVO userVO = (UserVO) request.getSession().getAttribute("user");
  LikeVO likeVO = (LikeVO) request.getAttribute("like");
%>

<%@ include file="../layout/header.jsp" %>

<center>
  <form action='updateBoard.do' method='post'>
    <input name='id' type='hidden' value="<%=board.getId()%>"/>
    <table border='1' cellpadding='0' cellspacing='0'>
      <tr>
        <td bgcolor='orange' width='70'>제목</td>
        <td align='left'><input name='title' type='text' value="<%=board.getTitle()%>"/></td>
      </tr>
      <tr>
        <td bgcolor='orange'>작성자</td>
        <td align='left'><%=board.getUserName()%></td>
      </tr>
      <tr>
        <td bgcolor='orange'>내용</td>
        <td align='left'><textarea name='text' cols='40' rows='10'><%=board.getText()%></textarea></td>
      </tr>
      <tr>
        <td bgcolor='orange'>등록일</td>
        <td align='left'><%=board.getCreatedDate()%></td>
      </tr>
      <tr>
        <td bgcolor='orange' width='100'>조회수</td>
        <td align='left'><%=board.getViewCnt()%></td>
      </tr>

      <tr>
        <td colspan='2' align='center'>
          <input type='submit' value='글 수정'>
          <% if(likeVO == null) {%>
          <button type="button" onClick="location.href='plusLike.do?id=<%=board.getId()%>'">좋아요</button>
          <% } else {%>
            <button type="button" onClick="location.href='minusLike.do?id=<%=board.getId()%>'">좋아요 취소</button>
          <% }%>
        </td>
      </tr>
    </table>
  </form>
  <hr>


<% if(userVO.getRole().equals("ADMIN")) {%>
  <a href='deleteBoard.do?id=<%=board.getId()%>'>글 삭제</a>
  <% } %>

</center>

<%@ include file="../layout/footer.jsp"%>
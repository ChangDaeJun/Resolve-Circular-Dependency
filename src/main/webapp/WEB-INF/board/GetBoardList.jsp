<%@ page import="java.util.List" %>
<%@ page import="com.jsp.biz.board.BoardVO" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp"%>

<%
    List<BoardVO> boardVOList = (List<BoardVO>) request.getAttribute("boardList");
%>

<center>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>번호</th>
            <th bgcolor='orange' width='200'>제목</th>
            <th bgcolor='orange' width='100'>작성자</th>
            <th bgcolor='orange' width='150'>등록일</th>
            <th bgcolor='orange' width='100'>조회수</th>
        </tr>

        <% for(BoardVO board: boardVOList){ %>
        <tr>
            <td> <%= board.getId() %> </td>
            <td align ='left'><a href="getBoard.do?id=<%=board.getId()%>"><%= board.getTitle() %></a></td>
            <td><%= board.getUserName()%></td>
            <td><%= board.getCreatedDate()%></td>
            <td><%= board.getViewCnt()%></td>
        </tr>
        <%}%>
    </table>

</center>

<%@ include file="../layout/footer.jsp"%>

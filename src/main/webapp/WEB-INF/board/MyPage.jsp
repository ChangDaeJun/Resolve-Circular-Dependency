<%@ page import="java.util.List" %>
<%@ page import="com.jsp.biz.board.BoardVO" %>
<%@ page import="com.jsp.biz.comment.CommentVO" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp"%>

<%
    List<BoardVO> createBoards = (List<BoardVO>) request.getAttribute("createBoards");
    List<CommentVO> createComments = (List<CommentVO>) request.getAttribute("createComments");
    List<BoardVO> likeBoards = (List<BoardVO>) request.getAttribute("likeBoards");
%>

<center>
    <h1>내가 작성한 글 목록</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>번호</th>
            <th bgcolor='orange' width='200'>제목</th>
            <th bgcolor='orange' width='100'>작성자</th>
            <th bgcolor='orange' width='150'>등록일</th>
            <th bgcolor='orange' width='100'>조회수</th>
        </tr>

        <% for(BoardVO board: createBoards){ %>
        <tr>
            <td> <%= board.getId() %> </td>
            <td align ='left'><a href="getBoard.do?id=<%=board.getId()%>"><%= board.getTitle() %></a></td>
            <td><%= board.getUserName()%></td>
            <td><%= board.getCreatedDate()%></td>
            <td><%= board.getViewCnt()%></td>
        </tr>
        <%}%>
    </table>

    <h1>내가 좋아요 누른 글 목록</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>번호</th>
            <th bgcolor='orange' width='200'>제목</th>
            <th bgcolor='orange' width='100'>작성자</th>
            <th bgcolor='orange' width='150'>등록일</th>
            <th bgcolor='orange' width='100'>조회수</th>
        </tr>

        <% for(BoardVO board: likeBoards){ %>
        <tr>
            <td> <%= board.getId() %> </td>
            <td align ='left'><a href="getBoard.do?id=<%=board.getId()%>"><%= board.getTitle() %></a></td>
            <td><%= board.getUserName()%></td>
            <td><%= board.getCreatedDate()%></td>
            <td><%= board.getViewCnt()%></td>
        </tr>
        <%}%>
    </table>

    <h1>내가 작성한 댓글</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>글 번호</th>
            <th bgcolor='orange' width='200'>댓글 내용</th>
            <th bgcolor='orange' width='100'>작성일</th>
        </tr>

        <% for(CommentVO comment : createComments){ %>
        <tr>
            <td><a href="getBoard.do?id=<%=comment.getBoardId()%>"> <%= comment.getBoardId() %> </td>
            <td><%= comment.getText()%></td>
            <td><%= comment.getCreatedDate()%></td>
        </tr>
        <%}%>
    </table>
</center>

<%@ include file="../layout/footer.jsp"%>

<%@ page import="com.jsp.domain.user.UserVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board Project</title>
</head>
<body>
<hr>
<a href="index.jsp">Home</a> &nbsp;&nbsp;&nbsp;
<% UserVO user = (UserVO) session.getAttribute("user");%>
<% if(user == null) {%>
    <a href="insertUserView.do">회원 가입</a> &nbsp;&nbsp;&nbsp;
    <a href="loginUserView.do">로그인</a> &nbsp;&nbsp;&nbsp;
<%} else {%>
    <a href="insertBoardView.do">글 작성</a> &nbsp;&nbsp;&nbsp;
    <a href="getBoardList.do">글 목록</a> &nbsp;&nbsp;&nbsp;
    <a href="myPage.do">마이 페이지</a> &nbsp;&nbsp;&nbsp;
    <a href="logout.do">로그아웃</a> &nbsp;&nbsp;&nbsp;
<%}%>

<hr>
<br>
<%@ page import="com.jsp.biz.user.UserVO" %>
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
    <a href="loginView.do">로그인</a> &nbsp;&nbsp;&nbsp;
<%} else {%>
    <a href="insertBoardView.do">글 등록</a> &nbsp;&nbsp;&nbsp;
    <a href="logout.do">로그아웃</a> &nbsp;&nbsp;&nbsp;
<%}%>

<hr>
<br>
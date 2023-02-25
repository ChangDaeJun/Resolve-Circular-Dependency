<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>

<center>
    <h1>회원 가입</h1>

    <form action="insertUser.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="90">이메일</td>
                <td><input type="text" name="email" size="30"></td>
            </tr>
            <tr>
                <td bgcolor="orange">비밀번호</td>
                <td><input type="password" name="password" size="30"></td>
            </tr>
            <tr>
                <td bgcolor="orange">이름</td>
                <td><input type="text" name="name" size="30"></td>
            </tr>
            <tr>
                <td bgcolor="orange">권한</td>
                <td>
                    <input type="radio" name="role" value="USER" checked/>USER
                    <input type="radio" name="role" value="ADMIN"/> ADMIN
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원가입"/>
                    <input type="button" value="가입취소" onclick="location.href='index.jsp'"/>
                </td>
            </tr>
        </table>
    </form>
</center>

<%@ include file="../layout/footer.jsp"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8"
         import="java.util.*,sec01.ex01.*"
         pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m" property="*"/>

<%
    //    String id = request.getParameter("id");
//    String pwd = request.getParameter("pwd");
//    String name = request.getParameter("name");
//    String email = request.getParameter("email");
//    MemberBean m = new MemberBean(id, pwd, name, email);
    MemberDAO memberDAO = new MemberDAO();
    memberDAO.addMember(m);
    List membersList = memberDAO.listMembers();
%>
<html>
<head>
    <title>회원 목록창</title>
</head>
<body>
<table align="center"  width="100%">
    <tr align="center" bgcolor="#99ccff">
        <td width="7%" >아이디</td>
        <td width="7%">비밀번호</td>
        <td width="5%" >이름</td>
        <td width="11%" >이메일</td>
    </tr>
    <tr align="center">
        <td>
            <jsp:getProperty name="m" property="id"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="pwd"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="name"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="email"/>
        </td>
    </tr>
    <tr height="1" bgcolor="#99ccff">
        <td colspan="5"></td>
    </tr>
</table>
</body>
</html>

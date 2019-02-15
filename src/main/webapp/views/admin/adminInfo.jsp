<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        pageContext.setAttribute("sup", request.getContextPath());
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人信息</title>
    <link href="${sup}/static/fore/css/libs/sweetalert.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${sup}/static/fore/css/libs/bootstrap.min.css">
    <script type="text/javascript" src="${sup}/static/fore/js/libs/sweetalert.min.js"></script>
    <script type="text/javascript"
            src="${sup}/static/fore/js/views/adminJs/libs/jquery.min.js"></script>
    <script src="${sup}/static/fore/js/libs/bootstrap.min.js"></script>
</head>
<body>
<table>
    <tr>
        <td>用户名:</td>
        <td><input id="adId" type="hidden"><input id="adUsername" type="text"></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input id="adPassword" type="text"></td>
    </tr>
    <tr>
        <td colspan="2">
            <button id="changeAdminUser">修改</button>
        </td>
    </tr>
</table>
</body>
<script type="text/javascript" src="${sup}/static/fore/js/views/adminJs/adminInfo.js"></script>
</html>



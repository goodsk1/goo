<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        pageContext.setAttribute("sup", request.getContextPath());
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${sup}/static/fore/css/adminCss/login.min.css">
    <link rel="stylesheet" href="${sup}/static/fore/css/libs/bootstrap.min.css">
    <script type="text/javascript" src="${sup}/static/fore/js/libs/jquery.min.js"></script>
    <title>管理员登录</title>
</head>
<body class="login">
<div class="menu-toggler sidebar-toggler"></div>
<div class="content">
    <h3 class="form-title font-green">用户登录</h3>
    <form action="${sup}/admin/checkLogin" method="post">
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off"
                   placeholder="用户名" name="adminName" id="adminName"/></div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密&nbsp;码</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off"
                   placeholder="密码" name="adminPwd" id="adminPwd"/></div>
        <span style="margin-left: 20px;">${msg}</span>
        <div class="form-actions">
            <button type="submit" class="btn green uppercase" id="login">登 录</button>
        </div>
    </form>
</div>
<div class="copyright"></div>
</body>
</html>
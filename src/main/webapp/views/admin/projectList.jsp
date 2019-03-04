<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 组件：注意此处提供一个id设置为lv.min.js，用于框架自动识别环境 -->
    <%@ include file="/common/baseHead.jsp"%>
</head>
<body>
<script type="text/javascript">

</script>
<!-- 页面 -->
<div id="lv-view">
    <lv-view :config="config"></lv-view>
</div>
<!-- 页面配置项业务代码引入 -->
<script type="text/javascript" src="http://localhost:8080/graduation/static/fore/js/views/adminJs/projectList.js"></script>

</body>
</html>


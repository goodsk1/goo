<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%
        pageContext.setAttribute("bus", request.getContextPath());
    %>
    <!-- 下面是easyui的环境 -->
    <link rel="stylesheet" href="${bus}/static/after/jquery-easyui-1.6.7/themes/icon.css" type="text/css"></link>
    <link rel="stylesheet" href="${bus}/static/after/jquery-easyui-1.6.7/themes/default/easyui.css"
          type="text/css"></link>
    <script type="text/javascript" src="${bus}/static/after/jquery-easyui-1.6.7/jquery.min.js"></script>
    <script type="text/javascript" src="${bus}/static/after/jquery-easyui-1.6.7/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${bus}/static/after/jquery-easyui-1.6.7/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${bus}/static/fore/js/views/adminJs/adminMain.js"></script>
    <script src="${bus}/static/fore/js/libs/angular.min.js"></script>
    <title>商家后台管理</title>
    <style type="text/css">
        body {
            font-family: microsoft yahei;
        }
    </style>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px; background-color: #E0ECFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <h2>商家后台系统</h2>
            </td>
            <div style="font-size: 15px;position:absolute; right:0; bottom:0;">
                <span>欢迎:${sessionScope.manufactorName}</span>|
                <a href="/business/logout">[退出]</a>
            </div>
        </tr>
    </table>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('订单管理','admin/order/toOrderPage','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">订单管理</a>
        </div>
        <div title="管理员信息管理" data-options="iconCls:'icon-bkgl'" style="padding:10px;">
            <a href="javascript:openTab('信息修改','admin/toAdmininfo','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">信息修改</a>
        </div>
        <div title="会员管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
            <a href="javascript:openTab('会员管理','auser/toUserList','icon-bklb')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">会员管理</a>
        </div>
        <div title="商品管理" data-options="iconCls:'icon-plgl'" style="padding:10px">
            <a href="javascript:openTab('商品管理','admin/snackinfo/toSnackManage','icon-review')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-review'" style="width: 150px">商品管理</a>
        </div>
        <div title="二维码生成" data-options="iconCls:'icon-grxx'" style="padding:10px">
            <a href="http://localhost:8080/graduation/index.html">二维码生成</a>
        </div>
        <div title="合作厂家管理" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('厂家查询','manufactor/toManufactorList','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">厂家查询</a>
        </div>
        <div title="项目管理" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('新建项目','project/toProjectList','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">新建项目</a>
        </div>
    </div>
</div>

</div>
<div data-options="region:'center'" style="background:#eee;">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
        </div>
    </div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">
    div region="south" style="height: 25px;padding: 5px" align="center">
    Copyright © 2018 lsw后台系统 版权所有
</div>
</div>
</body>
</html>


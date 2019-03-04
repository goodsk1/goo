<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="http://localhost:8080/graduation/static/fore/css/libs/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/graduation/static/fore/css/libs/jquery.dataTables.css">
    <link href="http://localhost:8080/graduation/static/fore/css/libs/sweetalert.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/graduation/static/fore/css/libs/dataTimeCss.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="http://localhost:8080/graduation/static/fore/js/libs/jquery.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="http://localhost:8080/graduation/static/fore/js/libs/jquery.dataTables.js"></script>
    <script src="http://localhost:8080/graduation/static/fore/js/libs/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://localhost:8080/graduation/static/fore/js/libs/bootbox.min.js"></script>
    <script type="text/javascript" src="http://localhost:8080/graduation/static/fore/js/libs/sweetalert.min.js"></script>
    <script src="http://localhost:8080/graduation/static/fore/js/libs/angular.min.js"></script>
    <script src="http://localhost:8080/graduation/static/fore/js/libs/laydate.js"></script>
<body ng-App="adminUserinfoApp">
<div ng-controller="adminUserinfoCtrl">
    用户名:<input class="text-center" id="uUsername">
    电 话:<input class="text-center" id="uPhone">
    <button id="serchUserinfo">搜索</button>
    <table id="table_id_example" class="display">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>


    <div class="modal fade" id="personSubCouponModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" style="width: 500px; height: 300px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">用户修改</h4>
                </div>
                <div class="clearfix" style="margin:0px 15px 0px">
                    <div class="margin-top-15">
                        <table>
                            <tr>
                                <td>用户名:<input type="hidden" id="uId"></td>
                                <td><input class="text-center" id="uUsernameTwo"></td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td><input class="text-center" id="uPassword"></td>
                            </tr>
                            <tr>
                                <td>电话:</td>
                                <td><input class="text-center" id="uPhoneTwo"></td>
                            </tr>
                            <tr>
                                <td>邮箱:</td>
                                <td><input class="text-center" id="uEmail"></td>
                            </tr>
                            <tr>
                                <td>地址:</td>
                                <td><input class="text-center" id="uAddress"></td>
                            </tr>
                        </table>
                    </div>
                    <button type="submit" id="updateByUserinfo">修改</button>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="http://localhost:8080/graduation/static/fore/js/views/adminJs/userInfo.js"></script>
</html>



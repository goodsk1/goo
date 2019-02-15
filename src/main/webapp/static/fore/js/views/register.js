var uUserFlag = false;
var passflag = false;
var rpassflag = false;
var emailflag = false;
var uRealflag = false;
var uPhoneflag = false;
var uAddressflag = false;
$(function () {
    $("#loginName").blur(function () {
        if ($("#loginName").val() == null || $("#loginName").val() == "") {
            $("#msg").text("用户名不能为空");
        } else {
            $.ajax({
                url: "checkUserExist",
                data: {
                    "loginName": $("#loginName").val()
                },
                type: 'post',
                dataType: "json",
                success: function (msg) {
                    if (msg.tag == null) {
                        $("#msg").text("");
                        uUserFlag = true;
                    } else {
                        $("#msg").text("用户名已存在！");
                        uUserFlag = false;
                    }
                }
            });
        }
    });
    $("#registerbtn").click(function () {
        $.ajax({
            url: "addUserRegister",
            data: {
                "loginName": $("#loginName").val(),
                "loginPwd": $("#rpassword").val(),
                "trueName": $("#trueName").val(),
                "email": $("#email").val(),
                "phone": $("#phone").val(),
                "address": $("#address").val()
            },
            type: 'post',
            dataType: "json",
            success: function (result) {
                if (result.msg == "1") {
                    alert("注册成功！");
                    location.href = "/luckin/user/login/userLogin";
                } else {
                    alert(result.msg);
                    alert("注册失败！");
                }
            }
        });
    });
});




















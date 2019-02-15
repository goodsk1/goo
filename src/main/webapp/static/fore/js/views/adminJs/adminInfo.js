$(document).ready(function () {
    $.ajax({
        url: '/admin/showAdmininfo',
        type: 'post',
        dataType: "json",
        success: function (result) {
            if (result.msg == "成功") {
                $("#adId").val(result.tag.id);
                $("#adUsername").val(result.tag.adminName);
                $("#adPassword").val(result.tag.adminPwd);
            }
        }
    });

    $("#changeAdminUser").on('click', function () {
        $.ajax({
            url: '/user/updateAdmininfo',
            data: {
                "id": $("#adId").val(),
                "loginName": $("#adUsername").val(),
                "loginPwd": $("#adPassword").val(),
            },
            type: 'post',
            dataType: "json",
            success: function (result) {
                if (result.msg == "成功") {
                    swal('修改成功', 'success');
                    $("#adUsername").val($("#adUsername").val());
                    $("#adPassword").val($("#adPassword").val());
                }
            }
        });
    })
})
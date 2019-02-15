var integralModule = angular.module("myOrderApp", []);
integralModule.controller("myOrderCtrl", function ($scope, $http) {
    createTable();
    initBind($http, $scope);
});

function initBind($http, $scope) {
    $('#table_id_example').on('click', '.select', function () {
        var params = $(this).attr('data-id');
        createsnackTable(params);
        showModal($('#orderSnackModal'));
    });

    //删除
    $('#table_id_example').on('click', '.delete', function () {
        var params = $(this).attr('data-id');
        swal({
            title: "确定删除？",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: false,
        }, function () {
            $.ajax({
                url: '/user/deleteMyOrder',
                data: {
                    "oId": params
                },
                type: 'post',
                dataType: "json",
                success: function (result) {
                    if (result.msg = "成功") {
                        swal("删除成功!", "success");
                        createTable();
                    } else {
                        swal("删除失败!", "error");
                        createTable();
                    }
                }
            });
        })
    });


    $('#table_id_example').on('click', '.update', function () {
        var params = "id=" + $(this).attr('data-id') + "&typeNum=" + 1;
        swal({
            title: "确认收货？",
            type: "info",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            showLoaderOnConfirm: true
        }, function () {
            $http({
                method: 'POST',
                url: '/user/userOrderConfirm',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: params
            }).success(function (result) {
                if (result.msg == "成功") {
                    swal("收货成功!", "success");
                    createTable();
                } else {
                    swal("收货失败!", "error");
                    createTable();
                }
            })
        })
    });


    //加载支付
    $('#table_id_example').on('click', '.payMoney', function () {
        var oId = $(this).attr('data-id');
        $.ajax({
            url: '/user/userOrderPayMoney',
            data: {
                "oId": oId
            },
            type: 'post',
            dataType: "json",
            success: function (result) {
                if (result.msg == "成功") {
                    $("#payNumber").val(result.extend.payMoney);
                    $("#uMoney").val(result.extend.userMoney);
                    $("#payoId").val(result.extend.oId);
                }
            }
        });
        showModal($('#payMoneyModal'));
    });


    //支付
    $('#comfirPay').on('click', function () {
        if ($("#uMoney").val() - $("#payNumber").val() >= 0) {
            if ($("#uPasword").val() != '') {
                $.ajax({
                    url: '/order/userOrderPayMoneyConfirm',
                    data: {
                        "payNumber": $("#payNumber").val(),
                        "uMoney": $("#uMoney").val(),
                        "uPasword": $("#uPasword").val(),
                        "oId": $("#payoId").val()
                    },
                    type: 'post',
                    dataType: "json",
                    success: function (result) {
                        if (result.msg == "成功") {
                            swal("支付成功!", "success");
                            $('#payMoneyModal').modal('hide');
                            createTable();
                        } else if (result.msg == "失败") {
                            swal("请输入正确的密码!");
                        }
                    }
                });
            } else {
                swal("请输入支付密码!", "warning");
            }
        } else {
            swal("您的钱包余额不足!", "warning");
        }
    });

}

var snackDatatable = null;

function createsnackTable(oId) {
    if (snackDatatable != null) {
        snackDatatable.destroy();
    }
    snackDatatable = $('#table_snack_example').DataTable({
        bLengthChange: false,
        searching: false,
        ordering: false,
        language: {
            url: '/static/fore/js/china.json'
        },
        "aLengthMenu": [10],
        serverSide: true,
        ajax: {
            url: "/shop/selectOrderSnack",
            dataSrc: "data",
            data: {
                "oId": oId
            },
            type: "post"
        },
        columns: [
            {
                data: 'picUrl', render: function (data, type, row) {
                    return "<img height='60' width='60' src='/static/fore/image/" + data + "'/>";
                }
            },
            {data: 'sName'},
            {data: 'oMoney'},
            {data: 'oNum'}
        ]
    });
}


var datatable = null;

function createTable() {
    if (datatable != null) {
        datatable.destroy();
    }
    datatable = $('#table_id_example').DataTable({
        bLengthChange: false,
        searching: false,
        ordering: false,
        language: {
            url: '/static/fore/js/china.json'
        },
        "aLengthMenu": [10],
        serverSide: true,
        ajax: {
            url: "/user/userOrderLimit",
            dataSrc: "data",
            type: "post"
        },
        columns: [
            {data: 'oId'},
            {data: 'oName'},
            {data: 'oPhone'},
            {data: 'oAddress'},
            {data: 'oTime'},
            {
                data: 'oType', render: function (data, type, row) {
                    if (data == -1) {
                        return "未付款,未发货";
                    } else if (data == 0) {
                        return "已发货";
                    } else {
                        return "已付款,未发货";
                    }
                }
            },
            {
                data: 'oId', render: function (data, type, row) {
                    if (row.oType == 0) {
                        return "<span class='select' data-id='" + row.oId + "'>查看&nbsp;&nbsp;</span>"
                            + "<span class='update' data-id='" + row.id + "'>确认收货</span>";
                    } else if (row.oType == -1) {
                        return "<span class='select' data-id='" + row.oId + "'>查看&nbsp;&nbsp;</span>"
                            + "<span class='payMoney' data-id='" + row.oId + "'>去付款&nbsp;&nbsp;</span>"
                            + "<span class='delete' data-id='" + row.oId + "'>删除</span>";
                    } else {
                        return "<span class='select' data-id='" + row.oId + "'>查看&nbsp;&nbsp;</span>"
                    }

                }
            }
        ]
    });
}

function showModal(modal, backdrop) {
    modal.modal({
        backdrop: backdrop || true,
        show: true
    })
};
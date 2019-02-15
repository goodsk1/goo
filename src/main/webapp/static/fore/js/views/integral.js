var integralModule = angular.module("integralApp", []);
integralModule.controller("integralCtrl", function ($scope) {
    createTable();
});


/**
 * 构造用户积分表
 */
var datatable = null;
function createTable() {
    var d = new Date();
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
            url: "/user/getIntegral",
            dataSrc: function(result){
                for (var i=0;i<result.data.length;i++)
                {
                    var timestamp4 = timestampToTime(result.data[i].iTime);
                    result.data[i].iTime = timestamp4;

                }
                return result.data;
            },
            type: "post"
        },
        columns: [
            {data: 'iNumber'},
            {data: 'iTime'},
            {data: 'iDesc'}
        ]
    });
}

/**
 * 将时间戳转换为时间格式
 * @param timestamp
 * @returns {*}
 */
function timestampToTime(timestamp) {
    var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = change(date.getDate()) + ' ';
    h = change(date.getHours()) + ':';
    m = change(date.getMinutes()) + ':';
    s = change(date.getSeconds());
    return Y + M + D + h + m + s;
}
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}















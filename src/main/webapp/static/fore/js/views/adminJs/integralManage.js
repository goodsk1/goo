var integralModule = angular.module("adminIntegralApp", []);
integralModule.controller("adminIntegralCtrl", function ($http, $scope) {
    createTable();
    //initBind($http, $scope);
});

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
        "aLengthMenu": [5],
        serverSide: true,
        ajax: {
            url: "/admin/integral/listIntegrals",
            dataSrc: "data",
            data: {
                "uId": $("#uUserId").val(),
            },
            type: "post"
        },
        columns: [
            {data: 'uId'},
            {data: 'iNumber'},
            {data: 'iTime'},
            {data: 'iDesc'}
        ]
    });
}
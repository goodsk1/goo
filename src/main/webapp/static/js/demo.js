/** demo.js **/
(function () {

    // 定义页面配置对象
    var config = {};

    // 这里写页面配置项
    // 面包屑导航
    config.bread = {

// 属性配置集合
        attr: {
            className: '',
            style: {}
        },
// 元素集合
        items: [
            {
                tag: 'a',
                text: '系统',
                attr: {
                    // 选填。id
                    id: '',
                    // 选填。name
                    name: '',
                    // 选填。自定义样式名称
                    className: '',
                    // 选填。自定义行内样式
                    style: {},
                    // 选填。点击后跳转地址
                    href: 'pagelist.html',
                    // 选填。打开方式
                    target: ''
                },
                // 选填。点击后事件处理函数，如果配置此函数，默认点击跳转将会自动屏蔽
                onClick: function (e) {
                    console.log(e);
                }
            },
            {
                tag: 'a',
                text: '商品信息管理',
                href: '',
                onClick: function (e) {
                    console.log(e);
                }
            },
            {
                tag: 'span',
                text: '新建商品信息'
            }
        ]
    };

// 搜索表单
    config.search = {
        // 属性配置集合
        attr: {
            // 超过行数折叠
            foldRows: 3,
            // 折叠状态
            foldStatus: true,
            className: '',
            style: {}
        },
        form: {
            // 必填。属性集合
            attr: {
                // 选填。自定义样式名称
                className: '',
                // 选填。自定义行内样式
                style: {},
                // 选填。表单元素布局列数，支持 1 2 3 4 5 6，默认4列。此处自带响应式缩放列
                columns: 4,
                // 选填。序号
                id: 'searchForm',
                // 必填。表单名称（分页表格组件设置pagetable.attr.formName与此值一致）
                name: 'searchForm',
                // 必填。表单提交路径
                action: '#',
                // 选填。表单提交方式，支持 POST / GET，默认GET
                method: 'post',
                // 选填。页面加载完成后提交表单，一般用于页面展示后显示第一页数据，默认false
                load: false,
                // 选填。是否在提交数据中不增加params参数，true为不增加，false或不设置为增加
                withoutParams: false
            },
            // 选填。表单提交完成后回调函数，一般用于数据处理，设置分页等。注意该函数处理完数据后需将处理数据返回
            onSuccess: function (result) {
                if (result.re[0] != null) {
                    config.pagetable.pager.attr.total = result.re[0].total;
                } else {
                    config.pagetable.pager.attr.total = 0;
                }
                return result.re;
            },
            // 表单元素
            items: [
                {
                    tag: 'input',
                    label: '商品名称',
                    attr: {
                        id: '',
                        name: 'productName'
                    },
                },
                {
                    tag: 'input',
                    label: '商品编号',
                    attr: {
                        id: '',
                        name: 'productNo'
                    }
                },
                {
                    tag: 'select',
                    label: '类别',
                    attr: {
                        className: '',
                        style: {},
                        name: 'categoryId',
                        // 选填。适用于ajax读取数据与默认配置不一致。默认 text
                        fieldText: 'name',
                        // 选填。适用于ajax读取数据与默认配置不一致。默认 value
                        fieldValue: 'id'
                    },
                    options: [],
                    // 选填。异步获取下拉框选项数据
                    ajax: {
                        // 必填。数据获取地址url
                        url: '#',
                        // 选填。请求方法，默认GET
                        method: 'GET',
                        // 选填。请求携带参数
                        data: {
                            id: '',
                        },
                        // 选填。成功回调函数，一般用户数据预处理，请返回选项最终渲染数组类型数据
                        success: function (result) {
                            result.unshift({
                                name: "全部",
                                id: '',
                                cityLevel: 1
                            });
                            return result;
                        },
                        // 选填。失败回调函数
                        error: function (err) {

                        }
                    },
                    // change事件自定义处理函数，请返回true标识当前选中操作合法，返回false或者不返回则不选中当前选择
                    // rowData用于ajax异步返回数据，为当前选中对象完整数据
                    onChange: function (target, rowData) {
                        // target是当前操作的对象
                        // 通过target.value可以直接拿到所选值
                        console.log(target.value);
                        // 如果配置了onChange事件处理函数，必须返回true才能设置值
                        return true;
                    }
                },
                {
                    tag: 'select',
                    label: '商品状态',
                    attr: {
                        className: '',
                        style: {},
                        name: 'status',
                        // 选填。适用于ajax读取数据与默认配置不一致。默认 text
                        fieldText: 'text',
                        // 选填。适用于ajax读取数据与默认配置不一致。默认 value
                        fieldValue: 'value'
                    },
                    options: [
                        {
                            text: '全部',
                            value: '',
                        },
                        {
                            text: '已配置',
                            value: 1,
                        }, {
                            text: '未配置',
                            value: 0
                        }
                    ],
                },
            ],
            // 表单按钮组
            btngroup: {
                attr: {
                    // 自定义样式，框架提供对齐方式样式名 center / left / right，默认：left
                    className: 'center',
                    style: {}
                },
                items: [
                    {
                        tag: 'button',
                        text: '查询',
                        attr: {
                            // 配置为submit是标识当前按钮可以提交表单
                            type: 'submit'
                        },
                        onClick: function (e) {
                            lv.formSubmit('searchForm', {
                                page: 1
                            });
                        }
                    }
                ]
            }
        }
    };


    // 业务操作按钮
    config.btngroup = {
        attr: {
            className: 'center',
            style: {}
        },
        items: [
            {
                tag: 'button',
                text: '新建',
                attr: {
                    className: '',
                    style: {},
                    // 选填：权限码
                    permission: ''
                },
                onClick: function () {
                    var iWidth = screen.availWidth + 40; //弹出窗口的宽度;
                    var iHeight = screen.availHeight; //弹出窗口的高度;
                    var iTop = window.screen.availHeight; //获得窗口的垂直位置;
                    var iLeft = window.screen.availWidth + 20 //获得窗口的水平位置;
                    window.open('#', '新增商品', "height=" + iHeight + ", width=" + iWidth + ", top=" + iTop + ", left=" + iLeft);
                }
            },
            {
                tag: 'button',
                text: '修改',
                attr: {
                    className: '',
                    style: {},
                    id: 'btnEdit',
                    // 选填：权限码
                    permission: '',
                    disabled: true
                },
                onClick: function () {

                }
            },
            {
                tag: 'button',
                text: '删除',
                attr: {
                    className: '',
                    style: {},
                    id: 'btnDelete',
                    // 选填：权限码
                    permission: '',
                    disabled: true
                },
                onClick: function () {
                    lv.confirm('确定要删除吗？', function () {
                        // 确定
                        lv.ajax({
                            url: '#',
                            method: 'get',
                            cache: false,
                            success: function (result) {
                                if (result.status == 0) {
                                    lv.alert({
                                        title: '操作提示', // 标题，可选
                                        content: '删除成功', // 提示内容，必需
                                        icon: 'success', // 提示类型，可选
                                        confirmText: '关闭'
                                    }, function () { // 关闭回调方法，可选
                                        lv.formSubmit('searchForm', {
                                            page: 1
                                        });
                                        $("#btnEdit").attr("disabled", true);
                                        $("#btnDel").attr("disabled", true);

                                    });
                                } else {
                                    lv.alert({
                                        title: '操作提示', // 标题，可选
                                        content: result.statusInfo, // 提示内容，必需
                                        icon: 'danger', // 提示类型，可选
                                        confirmText: '关闭'
                                    });
                                }
                            },
                        });
                    }, function () {
                        // 取消
                    });
                }
            },
            {
                tag: 'button',
                text: '配置',
                attr: {
                    className: '',
                    style: {},
                    id: 'btnConfig',
                    // 选填：权限码
                    permission: '',
                    disabled: true
                },
                onClick: function () {

                }
            }
        ]
    };

// 分页表格
    config.pagetable = {
        attr: {
            // 表格标题
            title: '商品列表',
            // 当前分页表格使用哪个表单数据，与form.attr.name一致
            formName: 'searchForm'
        },
        table: {
            attr: {
                // 样式名称
                className: '',
                // 自定义行内样式
                style: {},
                // 宽度
                width: '',
                // 第一列选中类型：radio / checkbox
                checkType: 'radio',
                // 数据列表中哪个属性值作为选中依据，设置唯一属性名
                checkField: 'id',
                // 选择记录集合：选中完整行记录对象全部存放于此。配置单选时，为一个对象，配置多选时，为一个数组
                checkResult: []
            },
            // 表格记录选择框选中回调函数，当前选择行完整记录
            onCheck: function (rowData) {
                $("#btnEdit").removeAttr("disabled");
                $("#btnEdit").unbind("click").click(function () {
                    var iWidth = screen.availWidth + 40; //弹出窗口的宽度;
                    var iHeight = screen.availHeight; //弹出窗口的高度;
                    var iTop = window.screen.availHeight; //获得窗口的垂直位置;
                    var iLeft = window.screen.availWidth + 20 //获得窗口的水平位置;
                    var editWindow = window.open();
                    editWindow.focus();
                });
                $("#btnConfig").removeAttr("disabled");
                $("#btnConfig").unbind("click").click(function () {
                    var iWidth = screen.availWidth + 40; //弹出窗口的宽度;
                    var iHeight = screen.availHeight; //弹出窗口的高度;
                    var iTop = window.screen.availHeight; //获得窗口的垂直位置;
                    var iLeft = window.screen.availWidth + 20 //获得窗口的水平位置;
                    var editWindow = window.open();
                    editWindow.focus();
                });
                $("#btnDelete").removeAttr("disabled");
                $("#btnDelete").unbind("click").click(function () {
                    //doDelete(rowData.id);
                });
            },
            // 异步数据获取配置，与常用ajax请求配置一样，比如jquery
            ajax: {
                // 数据获取地址
                url: '#',
                // 请求方法，GET / POST
                method: 'post',
                // 请求发送参数
                data: {
                    page: 1,
                    rows: 15,
                },
                // 是否支持缓存
                cache: false,
                // 成功回调函数，这里可以做一下数据处理工作。如有设置，请必须返回处理后的值
                success: function (data) {
                    if (data.re[0] != null) {
                        config.pagetable.pager.attr.total = data.re[0].total;
                    }
                    return data.re;
                },
                // 失败回调函数，这里可以做一下失败提示
                error: function (err) {
                    // dosomething
                }
            },
            // 定义表格数据列表
            items: [
                {
                    name: 'name',
                    text: '商品名称<span style="color:#e40">*</span>',
                    sort: true
                },
                {
                    name: 'info',
                    text: '简介'
                },
                {
                    name: 'price',
                    text: '价格'
                },
                {
                    name: 'configurationStatus',
                    text: '配置情况'
                },
                {
                    name: 'catalogName',
                    text: '类目'
                },
                {
                    name: 'imgUrl',
                    text: '小图片'
                },
                {
                    name: 'maxUrl',
                    text: '大图片'
                },
                {
                    name: 'id',
                    text: '操作'
                }
            ],
            // 表格里面列数据需要格式化，可以配置属性名函数
            format: {
                // 格式化函数支持返回组件。第一个参数是当前值，第二个参数是完整对象值
                configurationStatus: function (value) {
                    if (value == 1) {
                        return "已配置";
                    } else {
                        return "未配置";
                    }
                },
                imgUrl: function (value) {
                    var content = "<img  src='" + value + "' width= '80px' height=51px'>"
                    return {
                        tag: 'html',
                        content: content
                    };
                },
                maxUrl: function (value) {
                    var content = "<img  src='" + value + "' width= '90px' height=90px'>"
                    return {
                        tag: 'html',
                        content: content
                    };
                },
                id: function (value) {
                    var view_btn = '<a href="#" onclick="detail('+ value +')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a> ';
                    return {
                        tag: "html",
                        content: view_btn
                    };

                    // var edit_btn = '<a href="#" onclick="openDialog(\'编辑' + dataName + '\',\'' + _formDataUrl + '\',\'800px\', \'500px\')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 编辑</a> ';
                    // var delete_btn = '<a href="' + _deleteDataUrl + '" onclick="return confirmx(\'确认要删除该' + dataName + '吗？\', this.href);" class="btn  btn-danger btn-xs" ><i class="fa fa-trash"></i> 删除</a> ';
                    // return {
                    //     tag: "html",
                    //     content: view_btn + edit_btn + delete_btn
                    // };
                }
            },
            // 表格数据：数据对象数组
            data: []
        },
        pager: {
            attr: {
                // 分页对齐方式，默认左对齐(left)。支持 left / center / right
                align: 'left',
                // 分页页码显示位置，默认底部(bottom)。可选 top / bottom / both
                position: 'bottom',
                // 每页显示条数，默认15
                rows: 15,
                // 当前页码，默认1
                page: 1,
                // 记录总数。-1 不显示页码只显示上下页，0 或 不设置则不显示分页
                total: 1,
                // 自定义行内样式
                style: {},
                // 自定义样式名称
                className: {}
            },
            // 分页切换回调函数
            onChange: function (pageNo) {
                config.pagetable.table.data.page = pageNo;
            }
        }
    };

    // 启动lv渲染
    lv.start({
        // 选填。配置项填充div的id值，默认 lv-view
        viewId: 'lv-view',
        // 必填。配置项对象
        config: config
    });
	(function () {
  var pageData = function() {
    var data = [];
    for (var i = 0; i < 15; i++) {
      data.push({
        orderId: Date.now() * 2 + '' + i ,
        orderNo: Date.now() * (i + 2),
        orderCount: Date.now(),
        createTime: Date.now(),
        sendTime: Date.now(),
        finishTime: Date.now()
      });
    }
    return data;
  }
  // 设置1.5秒延时模拟请求
  setTimeout(function () {
    // 设置分页第一页面假数据
    config.pagetable.table.data = pageData();
  }, 1500);
})();

})();
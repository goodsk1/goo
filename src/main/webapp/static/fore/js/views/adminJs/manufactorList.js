// 全局配置对象
var config = {};
// 面包屑
config.bread = {
    // 属性配置集合
    attr: {
        className: '',
        style: {}
    },
    // 元素集合
    items: [
        {
            tag: 'span',
            text: '合同付款管理',
            attr: {
                id: "",
                href: "#"
            }
        },
        {
            tag: 'span',
            text: '待续签房租合同',
            attr: {
                id: "",
                href: "#"
            }
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
            action: luckyPath + 'manufactor/getList',
            // 选填。表单提交方式，支持 POST / GET，默认GET
            method: 'post',
            withoutParams: true,
            // 选填。页面加载完成后提交表单，一般用于页面展示后显示第一页数据，默认false
            load: true
        },
        data:{page:1,rows:30},
        // 选填。表单提交前处理函数，一般用于增加自定义数据校验。返回true才会进行表单提交，不返回或返回false不提交表单
        onSubmit: function (formData) {
            console.log(formData);
            return true;
        },
        // 选填。表单提交完成后回调函数，一般用于数据处理，设置分页等。注意该函数处理完数据后需将处理数据返回
        onSuccess: function (result) {
            initBtn();
            config.pagetable.pager.attr.total = result.data.total;
            return result.data.rows;
        },

        // 选填。自定义处理框架校验错误消息，如果没配置，则使用框架默认alert弹出错误消息
        onValidate: function (errMsg) {
            alert(errMsg);
        },

        // 表单元素
        items: [
            {
                tag: 'input',
                label: '厂家昵称',
                attr: {
                    id: 'nickName',
                    name: 'nickName'
                }
            }
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
                        console.log(e);
                    }
                }
            ]
        }
    }
};
// 分页表格
config.pagetable = {
    attr: {
        // 表格标题
        title: '合作厂家列表',
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
        // 定义表格数据列表
        items: [
            {
                name: 'nickName',
                text: '厂家昵称',
            },
            {
                name: 'address',
                text: '地址'
            },
            {
                name: 'phone',
                text: '手机号码'
            },
            {
                name: 'loginName',
                text: '登陆名'
            },
            {
                name: 'city',
                text: '所属城市'
            }
        ],
        // 表格数据：数据对象数组
        data: []
    },
    pager: {
        attr: {
            className: "spager",
            name: "spager",
            id: "spager",
            align: "left",
            position: "bottom",
            rows:30,
            page:1,
            total:0
        },
        // 分页切换回调函数
        onChange: function (pageNo) {
        }
    }
};


// 启动框架
window.lv.start({
    // 选填。配置项填充div的id值，默认 lv-view
    viewId: 'lv-view',
    // 必填。配置项对象
    config: config
});

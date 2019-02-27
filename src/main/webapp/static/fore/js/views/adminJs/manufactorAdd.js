var config = {};
config.form = {};
config.form.attr = {
    className: '',
    style: {},
    // 列数，不设置则显示为默认4列
    columns: 4,
    // 序号
    id: 'saveForm',
    // 名称
    name: 'saveForm',
    // 表单提交路径
    action: luckyPath + 'manufactor/add',
    // 方法
    method: 'POST'
};
config.form.onSuccess = function (result) {
    if (result.status == 0) {
        lv.alert("保存成功", function () {
            window.opener.location.href = window.opener.location.href;
            window.close();
        })
    } else {
        alert(result.statusInfo);
    }
};
config.form.onValidate = function (errMsg) {
    alert(errMsg);
};
config.form.blocks = [];
config.form.blocks[0] = {
    // 选填|必填。组件名称，数组方式必填，对象方式选填
    tag: 'block',
    // 选填。元素前置提示文字
    label: '',
    // 选填。label 文字超长，设置为 true 实现自动换行，默认：false 不换行
    labelBreak: false,
    columns: 3,
    // 选填。属性集合
    attr: {
        // 选填。用于控制显示与隐藏，hidden 隐藏，默认显示
        type: 'show',
        // 选填。自定义样式名称
        className: '',
        // 选填。自定义行内样式
        style: {}
    },
    items: [
        {
            tag: "input",
            label: '厂家昵称',
            attr: {
                name: 'nickName'
            },
            validate: {
                required: true
            },
            // 选填。元素页面布局占列数，默认：1，可设置：2、3、4
            colspan: 2

        },
        {
            tag: "input",
            label: "厂家地址:",
            attr: {
                name: 'address'
            },
            // 选填。元素页面布局占列数，默认：1，可设置：2、3、4
            colspan: 2
        },
        {
            tag: "input",
            label: "电话:",
            attr: {
                name: 'phone'
            },
            // 选填。元素页面布局占列数，默认：1，可设置：2、3、4
            colspan: 2
        },
        {
            tag: "input",
            label: "行业:",
            attr: {
                name: 'industry'
            },
            // 选填。元素页面布局占列数，默认：1，可设置：2、3、4
            colspan: 2
        },
        {
            tag: "input",
            label: "所在城市",
            attr: {
                name: 'city'
            },
            // 选填。元素页面布局占列数，默认：1，可设置：2、3、4
            colspan: 2
        }
    ]
};

config.form.btngroup = {
    // 属性
    attr: {
        className: 'center',
        style: {}
    },
    // 按钮
    items: [
        {
            tag: 'button',
            text: '保存',
            attr: {
                className: '',
                style: {},
                type: "submit"
            },
            onClick: function () {
            }
        },
        {
            tag: 'button',
            text: '取消',
            attr: {
                className: 'btn-default',
                style: {}
            },
            onClick: function () {
                window.close();
            }
        }
    ]
};


// 启动框架
window.lv.start({
    // 选填。配置项填充div的id值，默认 lv-view
    viewId: 'lv-view',
    // 必填。配置项对象
    config: config
});

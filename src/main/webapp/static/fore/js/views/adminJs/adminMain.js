//打开选项卡
function openTab(text, url, icon) {
    //判断当前选项卡是否存在
    if ($('#tabs').tabs('exists', text)) {
        $("#tabs").tabs("select", text);
    } else {
        $("#tabs").tabs('add', {
            title: text,
            closable: true,
            iconCls: icon,
            content: "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/" + url + "'></iframe>"
            //url 远程加载所打开的url
        })
    }
}

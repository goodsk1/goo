/**
 * 封装luckyView的ajax请求
 * @constructor
 * 调用示例
 * Req.get('xxx.do', {abc:'123'}, function (data) {
 *   dealXXX(data);
 * });
 */
var Req = {

    SUCCESS : 0,

    /**
     * get请求
     * @param url
     * @param data
     * @param callback 请求成功后执行的函数
     */
    get: function (url, data,callback) {
        Req.normal(url, 'get', data,false, callback);
    },

    /**
     * get请求
     * @param url
     * @param data
     * @param callback 请求成功后执行的函数
     */
    getLoad: function (url, data,callback) {
        Req.normal(url, 'get', data,true, callback);
    },

    /**
     * post请求
     * @param url
     * @param data
     * @param callback 请求成功后执行的函数
     */
   post: function (url, data, callback) {
        Req.normal(url, 'post', data,false, callback);
    },

    /**
     * post请求
     * @param url
     * @param data
     * @param callback 请求成功后执行的函数
     */
    postLoad: function (url, data, callback) {
        Req.normal(url, 'post', data,true, callback);
    },

    normal: function (url, methodType, data,load, callback) {
        if(!data){
            data = {};
        }
        window.lv.ajax({
            // 必填。请求路径
            url:luckyPath + url,
            // 选填。请求方法：GET / POST，默认GET
            method: methodType,
            // 选填。是否缓存请求：true / false ，默认false
            cache: true,
            // 选填。提交数据
            data: data,
            // 选填。是否异步：true / false，默认 true
            async: false,
            // 选填。数据交互格式：xml / html / script / script / jsonp / text，默认json
            dataType: 'json',
            load:load,
            // 选填。成功回调函数
            success: function(result, textStatus, jqXHR) {
                if(result.status == Req.SUCCESS){
                    if(typeof callback == 'function'){
                        callback(result.data);
                    }
                }else {
                    lv.alert(result.statusInfo);
                }
            },
            // 选填。失败回调函数
            error: function(xhr, textStatus, errorThrown) {
                console.log(xhr);
            },
            // 选填。完成回调函数，参考jquery
            complete: function(xhr, textStatus) {
            }
        });
    }
}

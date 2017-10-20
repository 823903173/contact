/**
 * Created by Administrator on 2017/1/7.
 */
var channel = "channel_app";
$(function () {
    channel = request["channel"] === undefined ? 'channel_app' : request["channel"];
});

window.onload = function () {
    //立即订购弹窗
  /*  var eles = document.querySelectorAll(".handle-btn");
    for (var i = 0; i < eles.length; i++) {
        eles[i].onclick = function () {
            var popupEle = document.querySelector(".popup-order-box");
            popupEle.style.display = "block";
            event.preventDefault();
        }
    }*/
    //关闭弹窗
    var pEles = document.querySelectorAll(".popup-close-btn,.close");
    for (var t = 0; t < pEles.length; t++) {
        pEles[t].onclick = function () {
            var fatherEle = this.parentNode;
            while (fatherEle.className.indexOf("popup-box") < 0) {
                fatherEle = fatherEle.parentNode;
            }
            fatherEle.style.display = "none";
            event.preventDefault();
        }
    }

    /*   var oEles = document.querySelectorAll(".recharge-btn");
     for(var m=0;m<oEles.length;m++){
     oEles[m].onclick= function(){
     var fatherEle= this.parentNode;
     while (fatherEle.className.indexOf("popup-box")<0){
     fatherEle= fatherEle.parentNode;
     }
     fatherEle.style.display="none";
     var rEles=document.querySelectorAll(".popup-again-box");
     rEles[0].style.display="block";
     event.preventDefault();
     }
     }*/

    //
    $('.handle-btn').click(function () {

        if (!getcookie('hncmjsSSOCookie') || !DWmoblie) {

            $('#yzmk').show();

        } else {
            //获取套餐和phoen
            $.ajax({
                type: "POST",
                url: "/hnmccClientWap/flowking/getphone.do",
                dataType: "json",
                data: {},
                async: true,
                beforeSend: function () {

                },
                success: function (data) {
                    layer.closeAll();
                    var code = data.code;
                    var msg = data.msg;
                    layer.closeAll();
                    if(code=0){
                        $('#yzmk').show();
                    }else {
                        $('#userphone').html(DWmoblie);
                        $('#tcname').html(msg)
                        $('#comfirm').show();
                    }



                },
                error: function (data) {
                    layer.closeAll();
                    $('#showinfo').html("参与的人太多了，亲亲稍后再来吧！");
                    $('#jiegou').show();
                }
            });

        }
    });


};


function page_init() {

}


function order() {

    $('#comfirm').hide();

    layer.open({
        type: 2
        , content: '正在处理中',
        shadeClose: false
    });

    //


    $.ajax({
        type: "POST",
        url: "/hnmccClientWap/flowking/order.do",
        dataType: "json",
        data: {"channel": channel,"proid":'pro_98'},
        async: true,
        beforeSend: function () {

        },
        success: function (data) {
            layer.closeAll();
            var code = data.code;
            var msg = data.msg;
            layer.closeAll();
            switch (code) {
                case 0:
                    $('#msg').html('登录超时，请到设置页面重新登录！');
                    $('#errmsg').html('');
                    $('#show').show();
                    break;
                case 1:
                case 2:
                    $('#msg').html('订购套餐失败');
                    $('#errmsg').html(msg);
                    $('#show').show();
                    break;
                case 3:
                    $('#msg').html('恭喜您，订购成功');
                    $('#errmsg').html('');
                    $('#show').show();
                    break;

            }

        },
        error: function (data) {
            layer.closeAll();
            $('#showinfo').html("参与的人太多了，亲亲稍后再来吧！");
            $('#jiegou').show();
        }
    });
}


function validPhone() {
    $("#tips").remove();
    var pattern = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
    if (!$('#phoneNum').val()) {
        $('#yzCode').closest('li').after('<span style="color: red" id="tips">手机号位数不够11位！</span>');
        return false;
    }
    else if (!pattern.test($('#phoneNum').val())) {
        $('#yzCode').closest('li').after('<li style="color: red" id="tips">该手机号不是有效的河南移动手机号码！</li>');
        return false;
    } else {
        return true;
    }
}

/** 公用 start */
var request = GetRequest();
var hncmjs = request["hncmjsSSOCookie"];  // 兼容新老版本 两种方式获取cookie
if (typeof(hncmjs) == "undefined" || hncmjs == null || hncmjs == "")
    hncmjs = getcookie("hncmjsSSOCookie");

/***   获取cookie  start                  */
function GetRequest() {
    var url = location.search; // 获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

function getcookie(objname) {//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for (var i = 0; i < arrstr.length; i++) {
        var temp = arrstr[i].split("=");
        if (temp[0] == objname) return unescape(temp[1]);
    }
}

/***     获取cookie  end              */


//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}

/**
 * 判断机型
 */
function judgePlatform() {
    if (navigator.userAgent.match(/Android/i)) {
        return platform = "android";
    } else if ((navigator.userAgent.indexOf('iPhone') != -1)) {
        return platform = "iphone";
    } else {
        return platform = "other";
    }
}

/**
 * 判断一个值是否为空或者undefiend
 * @param obj
 * @return 如果为空值或者未定义则返回true，否则返回false
 */
function isNullOrUndefined(obj) {
    if (obj == null || obj === "" || $.trim(obj).length == 0 || obj == 'null' || obj == 'undefined') {
        return true;
    }
    return false;
}
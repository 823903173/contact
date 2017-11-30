/**
 * Created by Administrator on 2017/10/18.
 */
$(function(){
    getVersion();
    $('#phone').bind("input", function () {
        $(".getcode-btn").css("background-color", "").removeClass("disable");
        $("#tips").remove();
    });
    $('#yzm').bind("input", function () {
        $("#tips").remove();
    });
    $('.confirm-btn').click(function () {
        console.log("11111");
        if (!validPhone()) {
            return;
        }
        var phone = $('#phone').val();
        var msm = $('#yzm').val();
        if (!$('#yzm').val()) {
            $('#yzm').closest('p').after('<span style="color: red" id="tips">请输入验证码！</span>');
            return;
        }
        $.ajax({
            url: "/hmcc/app/loginByMsg.do",
            type:"post",
            dataType: "json",
            data:{"phoneNumber":phone,"verifyCode":msm},
            success: function (data) {
                var flag=data.flag;
                if (flag == true){
                    SaveSessionStorage("phone",JSON.stringify(phone));
                    // mui.openWindow({
                    //     url: 'index.html',
                    // });
                    window.location.href = "index.html";
                }else{
                    $('#yzm').closest('p').after('<span style="color: red;margin-top: 1rem" id="tips">登录失败</span>');
                }
            }
        });
    });

    $('.getcode-btn').click(function () {
        console.log("111111");
        if ($(".getcode-btn").hasClass("disable")) {
            return;
        }
        if (!validPhone()) {
            return;
        }

        $(".getcode-btn").css("background-color", "gray").addClass("disable");
        var phone = $('#phone').val();
        $.ajax({
            url: "/hmcc/app/loginByPhone.do",
            type:"post",
            dataType: "json",
            data:{"phone_num":phone},
            success: function (data) {
                var flag=data.flag;
                if (flag == true){
                    for (var i = 1; i <= 60; i++) {
                        window.setTimeout("update_p(" + i + "," + 60 + ")", i * 1000);
                    }
                }else{
                    $('#yzm').closest('p').after('<span style="color: red" id="tips">无法获取验证码</span>');
                }
            }
        });
    });
});

function getVersion() {
    var version;
    document.addEventListener( "plusready", onPlusReady, false );
    // 扩展API加载完毕，现在可以正常调用扩展API
    function onPlusReady() {
        // 获取apk/ipa版本号
        version = plus.runtime.version;
        // alert(version+"aaaaaaaaa");
        if(version!=null){
            $.ajax({
                url: "/hmcc/addresslistAppLogin/checkBetaNumber.do",
                type:"post",
                dataType: "json",
                async: false,
                data:{"betaNumber":version},
                success: function (data) {
                    var flag = data.flag;
                    if (flag == true){
                        //询问框
                        layer.open({
                            content: '检测到新版本，是否升级？'
                            , btn: ['升级版本', '暂不升级']
                            , yes: function (index) {
                                window.location.href = '/hmcc/file/down.do';
                                layer.close(index);
                            }
                        });
                    }
                }
            });
        }

        var webview = plus.webview.currentWebview();
        plus.key.addEventListener('backbutton', function() {
            //alert("backbutton！！！！！");
            webview.canBack(function(e) {
                if(e.canBack) {
                    webview.back();
                } else {
                    webview.close(); //hide,quit
                    //plus.runtime.quit();
                }
            })
        });
    }
}

function validPhone() {
    $("#tips").remove();
    //var pattern = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
    var pattern = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!$('#phone').val()) {
        $('#phone').closest('p').after('<span style="color: red" id="tips">请输入11位手机号！</span>');
        return false;
    }
    else if (!pattern.test($('#phone').val())) {
        $('#phone').closest('p').after('<span style="color: red" id="tips">请输入正确的手机号码！</span>');
        return false;
    } else {
        return true;
    }
}

function update_p(num, t) {
    if (num == t) {
        $('.getcode-btn').html('重新发送 ');//#0085ce;
        $(".getcode-btn").css("background-color", "").removeClass("disable");
    }
    else {
        var printnr = t - num;
        $('.getcode-btn').html(printnr + " 秒后重发");//#0085ce;
    }
}
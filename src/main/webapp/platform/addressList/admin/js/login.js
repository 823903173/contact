/**
 * Created by Administrator on 2017/10/17.
 */
$(function(){
    $('#phone').bind("input", function () {
        $(".get-code").css("background-color", "").removeClass("disable");
        $("#tips").remove();
    });
    $('#yzm').bind("input", function () {
        $("#tips").remove();
    });
    $('.login-btn').click(function () {
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
            url: "/hmcc/send/queryPhoneNumAndVerifyCode.do",
            type:"get",
            dataType: "json",
            data:{"phoneNumber":phone,"verifyCode":msm},
            success: function (data) {
                var flag=data.flag;
                if (flag == true){
                    // alert("登录成功！")
                    location.href = "http://localhost:8082/hmcc/ContactUserlogin/toImportExcel.do?phoneNum="+phone
                }else{
                    $('#yzm').closest('p').after('<span style="color: red" id="tips">登录失败</span>');
                }
            }
        });
    });

    $('.get-code').click(function () {
        if ($(".get-code").hasClass("disable")) {
            return;
        }
        if (!validPhone()) {
            return;
        }

        $(".get-code").css("background-color", "gray").addClass("disable");
        var phone = $('#phone').val();
        $.ajax({
            url: "/hmcc/departmentAdministrator/CheckDepartmentPhoneNumber.do?",
            type:"get",
            dataType: "json",
            data:{"phoneNumber":phone},
            success: function (data) {
                var flag=data.flag;
                if (flag == true){
                    for (var i = 1; i <= 60; i++) {
                        window.setTimeout("update_p(" + i + "," + 60 + ")", i * 1000);
                    }
                }else{
                    $('.get-code').closest('p').after('<span style="color: red" id="tips">非管理员无法获取验证码</span>');
                }
            }
        });
    });
});

function validPhone() {
    $("#tips").remove();
    var pattern = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
    if (!$('#phone').val()) {
        $('.get-code').closest('p').after('<span style="color: red" id="tips">请输入11位手机号！</span>');
        return false;
    }
    else if (!pattern.test($('#phone').val())) {
        $('.get-code').closest('p').after('<span style="color: red" id="tips">该手机号不是有效的河南移动手机号码！</span>');
        return false;
    } else {
        return true;
    }
}

function update_p(num, t) {
    if (num == t) {
        $('.get-code').html('重新发送 ');//#0085ce;
        $(".get-code").css("background-color", "").removeClass("disable");
    }
    else {
        var printnr = t - num;
        $('.get-code').html(printnr + " 秒后重发");//#0085ce;
    }
}
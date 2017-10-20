$('#phone').bind("input", function () {
    $(".get-code").css("color", "").removeClass("disable");
    if ($(this).val().length <= 0) {
        $(this).siblings('.clear-btn').css("display", "none");
    } else {
        $(this).siblings('.clear-btn').css("display", "inline-block");
    }
    $("#tips").remove();
});
$('#yzm').bind("input", function () {
    $("#tips").remove();
});
$('.clear-btn').click(function () {
    $(this).hide().siblings('input').val("");
});

function dxorder() {
    if (!getcookie('hncmjsSSOCookie') || !DWmoblie) {
        if (!validPhone()) {
            layer.closeAll();
            return;
        }

        var url1 = getRootPath() + "/yanzhengma/sendmsgOne.do";
        var mobile = $('#phone').val();
        var msm = $('#yzm').val();
        $.post(url1, {mobile: mobile, msm: msm}, function (data) {
            if (0 == data.status ) {
                $('#yzmk').hide();
                DWmoblie = mobile;
                order();
            } else {
                layer.closeAll();
                $('.get-code').closest('p').after('<span style="color: red" id="tips">验证码不正确</span>');
            }
        });


    } else {
        order();
    }
}

function getYZM() {
    if ($(".get-code").hasClass("disable")) {
        return;
    }
    $(".get-code").css("color", "gray").addClass("disable");
    var url = getRootPath() + "/yanzhengma/sendmsg.do";
    var mobile = $('#phone').val();
    if (!validPhone()) {
        return;
    }
    $.post(url, {mobile: mobile}, function () {
        for (var i = 1; i <= 60; i++) {
            window.setTimeout("update_p(" + i + "," + 60 + ")", i * 1000);
        }
    })
}

function validPhone() {
    $("#tips").remove();
    var pattern = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
    if (!$('#phone').val()) {
        $('.get-code').closest('p').after('<span style="color: red" id="tips">手机号位数不够11位！</span>');
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
        $(".get-code").css("color", "").removeClass("disable");
    }
    else {
        var printnr = t - num;
        $('.get-code').html(printnr + " 秒后重发");//#0085ce;
    }
}
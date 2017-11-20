/**
 * Created by Administrator on 2017/11/17.
 */
$(function(){
    $('#QuesContent').bind("input", function () {
        $("#tips").remove();
    });
    $('#phone').bind("input", function () {
        $("#tips").remove();
    });
    $(".re-btn").click(function (){
        window.location.href = "index.html";
    });
    $('.confirm-btn').click(function () {
        if (!$('#QuesContent').val()) {
            $('#QuesContent').closest('dd').after('<span style="color: red" id="tips">请填写问题或建议描述！</span>');
            return;
        }
        if (!validPhone()) {
            return;
        }
        var content = $("#QuesContent").val();
        var phone = $("#phone").val();
        $.ajax({
                url: "/hmcc/demo/add.do",
                type: "post",
                dataType: "json",
                data: {"phoneNumber": phone, "remark": content},
                success: function (data) {
                    var flag = data.flag;
                    if (flag == true) {
                        layer.open({
                            type: 4,
                            time:3,
                            shade:true,
                            area : ['250px' , 'auto'],
                            content: '提交成功！'
                        });
                    } else {
                        $('.confirm-btn').closest('dd').after('<span style="color: red;margin-top: 1rem" id="tips">提交失败</span>');
                    }
                }
            });
    });
});

function validPhone() {
    $("#tips").remove();
    var pattern = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
    if (!$('#phone').val()) {
        $('#phone').closest('dd').after('<span style="color: red" id="tips">请输入11位手机号！</span>');
        return false;
    }
    else if (!pattern.test($('#phone').val())) {
        $('#phone').closest('dd').after('<span style="color: red" id="tips">请输入正确的手机号码！</span>');
        return false;
    } else {
        return true;
    }
}
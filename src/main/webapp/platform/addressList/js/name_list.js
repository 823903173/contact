/**
 * Created by Administrator on 2017/10/12.
 */

$(function(){
    var keywords = GetdecodeQueryString("keywords");
    $.ajax({
        url: "/hmcc/app/search.do?str_input="+keywords,
        type:"get",
        dataType: "json",
        data:{"str_input":keywords},
        success: function (data) {
            var user_list =data.value;
            $.each(user_list,function(n,user){
                var item_li = '<li>' +'<a href="javascript:getUserinfo(user.userName,user.phoneNum,user.extendedField1);">'
                    +'<span class="headimg">Z</span>' +'<span class="name-span">+</span>'+user.userName
                    +'<span class="group-span">'+user.extendedField1+'</span></a>'
                    + '<a href="javascript:getUserinfo(user.userName,user.phoneNum,user.extendedField1);" class="dial-btn">' +
                    '<span><img src="images/dial.jpg"/></span>' +
                    '</a></li>'
                $(".namelist-ul").append(item_li);
            });
        }
    });

    //关闭弹窗
    var pEles = document.querySelectorAll(".popup-close-btn");
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


});

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}

function getUserinfo(name,phone,group){
    $('.name').html(name);
    $('.group').html(group);
    $('.phone').html(phone);
    $('#personalinfo').show();
}
/**
 * Created by Administrator on 2017/10/12.
 */

$(function(){
    var keywords = GetdecodeQueryString("keywords");
    $.ajax({
        url: "/search.do",
        type:"post",
        dataType: "json",
        data:{"keywords":keywords},
        success: function (data) {
            var user_list =data.user_list;
            $.each(user_list,function(n,user){
                var item_li = '<li>' +'<a href="javascript:getUserinfo(user.id);">'
                    +'<span class="headimg">Z</span>' +'<span class="name-span">+</span>'+user.name+'</a>'
                    + '<a href="javascript:getUserinfo(user.id);" class="dial-btn">'+'<span><img src="images/dial.jpg"/></span>' +
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

function getUserinfo(id){
    $.ajax({
        url: "/getOneAll.do?id=" + id,
        type:"get",
        dataType: "json",
        data:{"id":id},
        success: function (data) {
            var user =data.user;
            $('.name').html(user.name);
            $('.group').html(user.group);
            $('.position').html(user.position);
            $('.phone').html(user.phone);
            $('#personalinfo').show();
        }
    });
}
/**
 * Created by Administrator on 2017/10/10.
 */

window.onload = function () {
    var depart_id = GetdecodeQueryString("depart_id");
    group(depart_id);
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
};

function group(depart_id){
    $.ajax({
        url: "hmcc/organization/getIdByGroupId.do?id=" + depart_id,
        type:"get",
        dataType: "json",
        data:{"id":depart_id},
        success: function (data) {
            var msg = data.msg;
            var current = data.name;
            var OrganizationValue = data.OrganizationValue;
            var UserValue = data.UserValue;
            if(msg==0){
                window.location.href = "login.html";
                return;
            }
            if(msg==1){
                if($(".checked-span").length > 0){
                    $(this).removeClass("checked-span");
                }
                var menuitem = '<a><span class="unchecked-span checked-span">'+current+'</span></a>';
                $(".menu-box").append(menuitem);
                if(isEnd==true){
                    $(".department-ul").style.display = "none";
                    $(".namelist-ul").empty();
                    for (var i=0;i<UserValue.length;i++){
                        var itemli = '<li><a href="javascript:getUserinfo(UserValue[i].userName,UserValue[i].phoneNum,UserValue[i].extendedField1);">'+
                            '<span class="headimg">*</span>'+
                            '<span class="name-span">+UserValue[i].userName+</span></a>'+
                            '<a href="javascript:getUserinfo(UserValue[i].userName,UserValue[i].phoneNum,UserValue[i].extendedField1);" class="dial-btn">'+
                            '<span><img src="images/dial.jpg"/></span></a></li>';
                        $(".namelist-ul").append(itemli);
                    }
                    $(".namelist-ul").show();
                    return;
                }
                if(isEnd==false){
                    $(".namelist-ul").style.display = "none";
                    $(".department-ul").empty();
                    for (var i=0;i<OrganizationValue.length;i++){
                        var itemli = '<li><a href="javascript:group(OrganizationValue[i].id);">'+OrganizationValue[i].name+'</a></li>';
                        $(".department-ul").append(itemli);
                    }
                    $(".department-ul").show();
                    return;
                }
            }

        }
    });
}
function getUserinfo(name,phone,group){
    $('.name').html(name);
    $('.group').html(group);
    $('.phone').html(phone);
    $('#personalinfo').show();
}

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}
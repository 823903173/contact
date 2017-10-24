/**
 * Created by Administrator on 2017/10/10.
 */

window.onload = function () {
    //$(".unchecked-span .checked-span").removeClass("checked-span");
    // if($(".unchecked-span .checked-span").length > 0){
    //     console.log('AAAAAAAAAAAAAAAAAAAAAA');
    //     $(this).removeClass("checked-span");
    // }

    var depart_id = GetdecodeQueryString("depart_id");
    var depart_name = GetdecodeQueryString("depart_name");
    group(depart_id,depart_name);
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
    $(".popup-close-btn").click(function (){
        $("#personalinfo").addClass("none");
    });
};

//加载部门组织
function group(depart_id,depart_name){
    $.ajax({
        url: "/hmcc/organization/getIdByGroupId.do",
        type:"post",
        dataType: "json",
        data:{"id":depart_id},
        success: function (data) {
            var msg = data.msg;
            var isEnd = data.isEnd;
            var OrganizationValue = data.OrganizationValue;
            var UserValue = data.UserValue;
            if(msg==0){
                window.location.href = "login.html";
                return;
            }
            if(msg==1){
                if($(".checked-span").length > 0){
                    $(".checked-span").removeClass("checked-span");
                }
                var menuitem = '<a><span class="unchecked-span checked-span">'+depart_name+'</span></a>';
                $(".tit-li").append(menuitem);
                var width=$(".tit-li").width();
                //console.log("屏幕总长："+width);
                var le=$(".unchecked-span").length;
                //console.log("标签总数："+le);
                var span = 0;
                for(var i=0;i<le;i++){
                    span = $(".unchecked-span").eq(i).outerWidth()+span;
                }
                //console.log("实际总长："+span);
                var checkedWidth=$(".checked-span").outerWidth();
                //console.log("最后选中标签长："+checkedWidth);
                if(span>width)
                {
                    $(".unchecked-span").last().removeClass("unchecked-span");
                    $(".unchecked-span").css("max-width", (width-checkedWidth)/(le-1)-12);
                    $(".checked-span").last().addClass("unchecked-span");
                }
                if(isEnd==true){
                    $(".department-ul").addClass("none");
                    $(".namelist-ul").empty();
                    for (var i=0;i<UserValue.length;i++){
                        var userName = UserValue[i].userName;
                        var phoneNum = UserValue[i].phoneNum;
                        var itemli = '<li><a class="name-btn">'+
                            '<span class="headimg"><textarea id="content"></textarea></span>'+
                            '<span class="name-span">'+UserValue[i].userName+'</span></a>'+
                            '<a class="name-btn dial-btn">'+
                            '<span><img src="images/dial.jpg"/></span></a></li>';
                        $(".namelist-ul").append(itemli);
                        $("#content").val(UserValue[i].userName);
                        $("#content").val($("#content").toPinyin().substr(0,1));
                        $('.name-btn').click(function(){
                            getUserinfo(userName,phoneNum,depart_name);
                        });
                    }
                    $(".namelist-ul").removeClass("none");
                    $(".namelist-ul").show();
                    return;
                }
                if(isEnd==false){
                    $(".namelist-ul").addClass("none");
                    $(".department-ul").empty();
                    for (var i=0;i<OrganizationValue.length;i++){
                        var id = OrganizationValue[i].id;
                        depart_name = OrganizationValue[i].name;
                        var itemli = '<li><a class="nameli">'+OrganizationValue[i].name+'</a></li>';
                        $(".department-ul").append(itemli);
                        $('.nameli').click(function(){
                            group(id,depart_name);
                        });
                    }
                    $(".department-ul").show();
                    return;
                }
            }

        }
    });
}

//加载个人信息页面
function getUserinfo(name,phone,group){
    $("#personalinfo").removeClass("none");
    $('.name').html(name);
    $('.group').html(group);
    $('.phone').html(phone);
    $('#tel').attr('href','tel:'+phone+'');
    $('#sms').attr('href','sms:'+phone+'');
    $('#personalinfo').show();
}

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}
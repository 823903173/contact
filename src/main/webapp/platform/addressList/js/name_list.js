/**
 * Created by Administrator on 2017/10/12.
 */
$(function(){
    var keywords = GetdecodeQueryString("keywords");
    $.ajax({
        url: "/hmcc/app/search.do",
        type:"post",
        dataType: "json",
        data:{"str_input":keywords},
        success: function (data) {
            var user_list =data.value;
            var groupNameList =data.groupNameList;
            var msg = data.msg;
            if(msg == 0)
            {
                window.location.href = "login.html";
                return;
            }
            if(msg == 1){
                // var groupName;
                // for(var i=0;i<groupNameList.length;i++) {
                //     groupName = groupNameList[i].name;
                // }
                for (var i=0;i<user_list.length;i++){
                    var phoneNum = user_list[i].phoneNum;
                    var userName = user_list[i].userName;
                    var groupName = groupNameList[i].name;
                    console.log(groupNameList[i].name);
                    var item_li = '<li class="name-li">' +'<a class="name-btn">'
                        +'<span class="headimg"><textarea class="content"></textarea></span>' +'<span class="name-span">'+user_list[i].userName+'</span>'
                        +'<span class="group-span">'+groupName+'</span></a></li>'
                    $(".namelist-ul").append(item_li);
                    $('.name-li').eq($('.name-li').length-1).find('a').attr("id",userName);
                    $('.name-li').eq($('.name-li').length-1).find('a').attr("data",phoneNum);
                    $('.name-li').eq($('.name-li').length-1).find('a').attr("data-id",groupName);

                    $(".content").eq($('.content').length-1).val(userName);
                    $(".content").eq($('.content').length-1).val($(".content").eq($('.content').length-1).toPinyin().substr(0,1));
                    $('.name-btn').eq($('.name-btn').length-1).click(function(){
                        getUserinfo($(this).attr('id'),$(this).attr('data'),$(this).attr('data-id'));
                    });

                }
            }

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
    $(".popup-close-btn").click(function (){
        $("#personalinfo").addClass("none");
        });
    $(".re-btn").click(function (){
        window.location.href = "index.html";
    });
});

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}

function getUserinfo(name,phone,group){
    $("#personalinfo").removeClass("none");
    $('.name').html(name);
    $('.group').html(group);
    $('.phone').html(phone);
    $('#tel').attr('href','tel:'+phone+'');
    $('#sms').attr('href','sms:'+phone+'');
    $('#personalinfo').show();
}
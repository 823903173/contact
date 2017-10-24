/**
 * Created by Administrator on 2017/10/10.
 */
$(function(){
    // var phone = GetdecodeQueryString("phoneNumber");
    var name;

    if(!GetSessionStorage("phone")){
        window.location.href = "login.html";

    }else {
        var phone=JSON.parse(GetSessionStorage("phone"));
        $.ajax({
            url: "/hmcc/organization/showIndexPage.do",
            type:"post",
            dataType: "json",
            data:{"phoneNumber":phone},
            success: function (data) {
                var msg = data.msg;
                var list = data.list;
                var fartherList = data.fartherList;
                var grandFatherList = data.grandFatherList;
                var userInfo = data.userInfo;
                if(msg == 0)
                {
                    window.location.href = "login.html";
                    return;
                }
                if(msg == 1)
                {
                    name = userInfo[0].userName;
                    $("#name").html(name);
                    if(grandFatherList!=null){
                        var item = '<div class="content-box1 content-box">'+
                            '<ul>'+
                            '<li class="content-bigger"><span id="company">'+grandFatherList[0].name+'</span></li>'+
                            '</ul>'+
                            '<img src="images/1.png"></div>'
                        $(".content").append(item);
                        $('.content-box1').click(function(){
                            window.location.href = "group.html?depart_id=" + encodeURIComponent(grandFatherList[0].id)+"&depart_name=" + encodeURIComponent(grandFatherList[0].name);
                        });
                    }
                    if(fartherList!=null){
                        var item = '<div class="content-box2 content-box">'+
                            '<ul>'+
                            '<li class="content-bigger"><span id="company">'+fartherList[0].name+'</span></li>'+
                            '</ul>'+
                            '<img src="images/2.png"></div>'
                        $(".content").append(item);
                        $('.content-box2').click(function(){
                            window.location.href = "group.html?depart_id=" + encodeURIComponent(fartherList[0].id)+"&depart_name=" + encodeURIComponent(fartherList[0].name);
                        });
                    }
                    var item = '<div class="content-box3 content-box">'+
                        '<ul>'+
                        '<li class="content-bigger"><span id="company">'+list[0].name+'</span></li>'+
                        '</ul>'+
                        '<img src="images/3.png"></div>'

                    $(".content").append(item);
                    $('.content-box3').click(function(){
                        window.location.href = "group.html?depart_id=" + encodeURIComponent(list[0].id) +"&depart_name=" + encodeURIComponent(list[0].name);
                    });
                }
            }
        });
    }


    $('#search-btn').click(function(){
        search();
    });
    $('.header-leave').click(function(){
        loginOut();
    });


});

//搜索框代码
function search(){
    var search=	$('#search').val();
    search = $.trim(search);
    console.log(search);
    if(search == ""){
        //alertify.alert("请输入搜索姓名或电话号码");
        layer.open({
            type: 4,
            time:3,
            shade:true,
            area : ['250px' , 'auto'],
            content: '请输入搜索姓名或电话号码！'
        });
        return;
    }
    window.location.href = "name_list.html?keywords=" + encodeURIComponent(search);
}

//退出登录
function loginOut(){
    $.ajax({
        url: "/hmcc/app/logOut.do",
        type:"post",
        dataType: "json",
        data:{},
        success: function (data) {
            var msg = data.msg;
            if(msg == 1){
                if(GetSessionStorage("phone")){
                    DelSessionStorage("phone");
                }
                window.location.href="login.html";
            }else{
                layer.open({
                    type: 4,
                    time:3,
                    shade:true,
                    area : ['250px' , 'auto'],
                    content: '退出失败，请重试！'
                });
                return;
            }
        }
    });
}

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}


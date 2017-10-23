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
            type:"get",
            dataType: "json",
            data:{"phoneNumber":phone},
            success: function (data) {
                var msg = data.msg;
                var list = data.list;
                var fartherList = data.fartherList;
                var grandFatherList = data.grandFatherList;
                if(msg == 0)
                {
                    window.location.href = "login.html";
                    return;
                }
                if(msg == 1)
                {
                    name = list[0].userName;
                    $("#name").html(name);
                    if(grandFatherList!=""){
                        var item = '<div class="content-box1 content-box">'+
                            '<ul>'+
                            '<li class="content-bigger"><span id="company">'+grandFatherList[0].extendedField1+'</span></li>'+
                            '</ul>'+
                            '<img src="images/1.png"></div>'
                        $('.content-box1').click(function(){
                            window.location.href = "group.html?depart_id=" + encodeURIComponent(grandFatherList[0].groupId);
                        });
                        $(".content").append(item);
                    }
                    if(fartherList!=""){
                        var item = '<div class="content-box2 content-box">'+
                            '<ul>'+
                            '<li class="content-bigger"><span id="company">'+fartherList[0].extendedField1+'</span></li>'+
                            '</ul>'+
                            '<img src="images/2.png"></div>'
                        $('.content-box2').click(function(){
                            window.location.href = "group.html?depart_id=" + encodeURIComponent(fartherList[0].groupId);
                        });
                        $(".content").append(item);
                    }
                    var item = '<div class="content-box3 content-box">'+
                        '<ul>'+
                        '<li class="content-bigger"><span id="company">'+list[0].extendedField1+'</span></li>'+
                        '</ul>'+
                        '<img src="images/3.png"></div>'

                    $(".content").append(item);
                    $('.content-box3').click(function(){
                        window.location.href = "group.html?depart_id=" + encodeURIComponent(list[0].groupId) +"&depart_name=" + encodeURIComponent(list[0].extendedField1);
                    });
                }
            }

        });
    }


    $('#search-btn').click(function(){
        search();
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

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}


/**
 * Created by Administrator on 2017/10/10.
 */
$(function(){
    var phone = GetdecodeQueryString("phoneNumber");;
    var name;
    var company;
    var organization;
    var department;
    $.ajax({
        url: "getOneAll.do?phone=" + phone,
        type:"get",
        dataType: "json",
        data:{"phone":phone},
        success: function (data) {
            var value = data.value;
            var msg = data.msg;
            name = value.name;
            company = value.company;
            organization = value.organization;
            department = value.department;
            if(msg == 0)
            {
                window.location.href = "login.html";
                return;
            }
            if(msg == 1)
            {
                $("#name").html(name);
                if(company!=null){
                    var item = '<div class="content-box1 content-box">'+
                        '<ul>'+
                        '<li class="content-bigger"><span id="company">'+company+'</span></li>'+
                        '</ul>'+
                        '<img src="images/1.png"></div>'
                    $('.content-box1').click(function(){
                        window.location.href = "group.html?depart_id=" + encodeURIComponent(company);
                    });
                    $(".content").append(item);
                }
                if(organization!=null){
                    var item = '<div class="content-box2 content-box">'+
                        '<ul>'+
                        '<li class="content-bigger"><span id="company">'+organization+'</span></li>'+
                        '</ul>'+
                        '<img src="images/2.png"></div>'
                    $('.content-box2').click(function(){
                        window.location.href = "group.html?depart_id=" + encodeURIComponent(organization);
                    });
                    $(".content").append(item);
                }
                var item = '<div class="content-box3 content-box">'+
                    '<ul>'+
                    '<li class="content-bigger"><span id="company">'+department+'</span></li>'+
                    '</ul>'+
                    '<img src="images/3.png"></div>'
                $('.content-box3').click(function(){
                    window.location.href = "group.html?depart_id=" + encodeURIComponent(department);
                });
                $(".content").append(item);
            }
        }

    });

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


/**
 * Created by Administrator on 2017/10/10.
 */
$(function(){
    var id = GetdecodeQueryString("id");;
    var name;
    var company;
    var organization;
    var department;
    $.ajax({
        url: "getOneAll.do?id=" + id,
        type:"get",
        dataType: "json",
        data:{"id":id},
        success: function (data) {
            var user=data.user;
            name = user.name;
            company = user.company;
            organization = user.organization;
            department = user.department;
            $("#name").html(name);
            $("#company").html(company);
            $("#organization").html(organization);
            $("#department").html(department);
        }
    });

    $('.content-box1').click(function(){
        window.location = "group.html?depart_id=" + encodeURIComponent(company);
    });
    $('.content-box2').click(function(){
        window.location = "group.html?depart_id=" + encodeURIComponent(organization);
    });
    $('.content-box3').click(function(){
        window.location = "group.html?depart_id=" + encodeURIComponent(department);
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
        alertify.alert("请输入搜索姓名或电话号码");
        return;
    }
    window.location = "name_list.html?keywords=" + encodeURIComponent(search);
}

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}


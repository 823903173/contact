/**
 * Created by Administrator on 2017/10/10.
 */

window.onload = function () {
    var depart_id = GetdecodeQueryString("depart_id");
    $.ajax({
        url: "/getOnesOfDepart.do?depart_id=" + depart_id,
        type:"get",
        dataType: "json",
        data:{"depart_id":depart_id},
        success: function (data) {
            var depart=data.depart;
            var depart_name = depart.depart_name;
            var depart_child = depart.depart_child;
            company = user.company;
            organization = user.organization;
            department = user.department;
            $("#name").html(name);
            $("#company").html(company);
            $("#organization").html(organization);
            $("#department").html(department);
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
};

function person(){
    $('#personalinfo').show();
}

function GetdecodeQueryString(name)
{
    var url_param = decodeURI(window.location.search);
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = url_param.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}
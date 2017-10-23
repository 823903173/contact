/**
 * Created by Administrator on 2017/10/22.
 */
//设置cookie
//@name 设置cookie的名字
//@value 设置cookie的值
var setCookie=function setCookie(name,value){
    var Days = 0.05;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
//读取cookie
var getCookie=function (name){
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return unescape(arr[2]);
    }else{
        return null;
    }
}
//删除cookie
var delCookie=function (name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null){
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    }
}
//把值保存到本地的sessionStorage中
//@key 保存的名字
//@val 保存的值  如果传入的是个对象必须先把对象转化成字符串如JSON.stringify(planObjVal)
var SaveSessionStorage=function(key,val){
    if(window.sessionStorage){
        sessionStorage.removeItem(key);
        sessionStorage.setItem(key, val);
    }else{
        setCookie(key,val);
//        alert("您的浏览器不支持sessionStorage");
    }
}
//获取本地的sessionStorage中
var GetSessionStorage=function(key){
    if(window.sessionStorage){
        return sessionStorage.getItem(key);
    }else{
        return getCookie(key);
    }

}
//删除制定的sessionStorage
var DelSessionStorage=function(key){
    if(window.sessionStorage){
        sessionStorage.removeItem(key);
    }else{
        delCookie(key);
    }
}
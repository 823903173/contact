/**
 * Created by a8239 on 2017/11/1.
 */
$(function() {
    mui.back = function(){
        var btn = ["确定","取消"];
        mui.confirm('确认关闭当前窗口？','Hello MUI',btn,function(e){
            if(e.index==0){
                mui.currentWebview.close();
            }
        });
    }
});
package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.AddresslistUser;

import com.hmcc.contact.service.IAddresslistUserService;
import com.hmcc.contact.service.ISendService;
import com.hmcc.contact.util.DoAjax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * APP登录日志表 前端控制器
 * </p>
 *
 *
 * *----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━by:coder-chenhao
 *
 *
 * @author chenhao
 * @since 2017-10-17
 */
@RestController
@RequestMapping("/app")
public class AddresslistUserController {


    @Autowired
    private IAddresslistUserService iAddresslistUserService;
    @Autowired
    private ISendService iSendService;


    /*
    * 响应人员个人信息展示页面
    * 根据人员id返回所有信息
    * url= getOneAll.do?id = xxx
    *
    * */
    @GetMapping("getOneAll")
    public void getOneAll(HttpServletResponse response, HttpServletRequest request,String id)
    {
        JSONObject json = new JSONObject();
            if(request.getSession(false)==null){
                json.put("msg",0);//
                DoAjax.doAjax(response, json, null);
                System.out.println("qingdenglu");
            }else {
            AddresslistUser res =  iAddresslistUserService.getOneInfo(Integer.parseInt(id));
            json.put("value",res);
            json.put("msg",1);//
            DoAjax.doAjax(response, json, null);
            System.out.println("chaxunchengg");
        }


//        return user;

    }

    /*
   响应机构人员列表
   根据机构id返回其所有人员列表
   url:getOnesOfDepart.do?depart_id = xxx
   */
    @GetMapping("getOnesOfDepart")
    public void getOnesOfDepart(HttpServletResponse response, HttpServletRequest request,String depart_id)
    {
        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            List<AddresslistUser> res =  iAddresslistUserService.getOnesByDepart(depart_id.trim());
            json.put("value",res);
            json.put("msg",1);//
            DoAjax.doAjax(response, json, null);
        }

//        return  users;
    }

    /*
     响应搜索功能，判断输入为姓名或手机号进行查询，返回人员列表

     */
    @GetMapping("search")
    public List<AddresslistUser> searchByNameOrNum (HttpServletResponse response, HttpServletRequest request,String str_input)
    {

        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            //判断输入是否全为数字
            Pattern pattern = Pattern.compile("[0-9]*");
            if (pattern.matcher(str_input).matches())
            {
                List<AddresslistUser> res = iAddresslistUserService.searchByPhoneNum(Long.parseLong(str_input));
                json.put("value",res);
                json.put("msg",1);//
                DoAjax.doAjax(response, json, null);
//            return iAddresslistUserService.searchByPhoneNum(Long.parseLong(str_input));
            }


            String str = "111111";
            //将url参数转为utf8码
            try
            {
                str = URLDecoder.decode(str_input,"utf-8");

            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }

            //判断输入是否为汉字
            String reg = "[\\u4e00-\\u9fa5]+";
            if(str.matches(reg))
            {

                List<AddresslistUser> res = iAddresslistUserService.searchByName(str.trim());
                json.put("value",res);
                json.put("msg",1);//
                DoAjax.doAjax(response, json, null);
//            return iAddresslistUserService.searchByName(str.trim());
            }




        }

        return null;





    }
    /*
    响应登录，先检查手机号是否在库中
    true则表示存在
    false则表示不存在

    */
    @GetMapping("loginByPhone")
    public void loginByPhone (HttpServletResponse response, HttpServletRequest request,String phone_num)
    {
        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            boolean res = iAddresslistUserService.loginByPhone(Long.parseLong(phone_num.trim()));
            json.put("flag",res);
            json.put("msg",1);//
            DoAjax.doAjax(response, json, null);
        }

//         return res;
    }

    /*
   响应登录，再短信验证
   */
    @GetMapping("loginByMsg")
    public void loginByMsg (HttpServletResponse response, HttpServletRequest request, String phoneNumber,String verifyCode)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("data", phoneNumber);
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是："+sessionId);
            JSONObject json = new JSONObject();
            long phoneNumberLong = Long.parseLong(phoneNumber);
            boolean res = iSendService.queryPhoneNumAndVerifyCode(phoneNumberLong,verifyCode);
            json.put("flag",res);
            DoAjax.doAjax(response, json, null);
        }else {
            System.out.println("服务器已经存在该session了，session的id是："+sessionId);
            boolean res = true;
            JSONObject json = new JSONObject();
            json.put("flag",res);
            DoAjax.doAjax(response, json, null);
        }

        /*JSONObject json = new JSONObject();
        long phoneNumberLong = Long.parseLong(phoneNumber);
        boolean res = iSendService.queryPhoneNumAndVerifyCode(phoneNumberLong,verifyCode);

        json.put("flag",res);
        DoAjax.doAjax(response, json, null);*/
//        return  true;
    }

    /*
    根据手机号验证操作时是否登录或session超时
    */
    private Boolean VerifyOperation(HttpServletResponse response, HttpServletRequest request,String phoneNum)
    {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        //使用request对象的getSession()获取session，如果session不存在则创建一个
////        HttpSession session = request.getSession();
//        request.getSession();
        return true;

    }
}

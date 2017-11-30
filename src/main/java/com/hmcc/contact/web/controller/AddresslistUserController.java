package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.*;

import com.hmcc.contact.service.*;
import com.hmcc.contact.service.IOrganizationService;
import com.hmcc.contact.util.DoAjax;
import com.hmcc.contact.util.getNowTime;
import com.hmcc.contact.util.randomMessageNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.ArrayList;
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
    @Autowired
    private IAddresslistAppLoginService iAddresslistAppLoginService;
    @Autowired
    private IOrganizationService iOrganizationService;
    @Autowired
    private IAddresslistMessageSendService iAssresslistMessageSendService;

    /*
    * 响应人员个人信息展示页面
    * 根据人员id返回所有信息
    * url= getOneAll.do?id = xxx
    *
    * */
    @RequestMapping("getOneAll")
    public void getOneAll(HttpServletResponse response, HttpServletRequest request,String id)
    {
        JSONObject json = new JSONObject();
            if(request.getSession(false)==null){
                json.put("msg",0);//
                DoAjax.doAjax(response, json, null);
                System.out.println("qingdenglu");
            }else {
            AddresslistUser res =  iAddresslistUserService.getOneInfo(Integer.parseInt(id));
            if (res.getIsHidden()==(long)1){
                res.setPhoneNum((long) 110);
            }
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
    @RequestMapping("getOnesOfDepart")
    public void getOnesOfDepart(HttpServletResponse response, HttpServletRequest request,String depart_id)
    {
        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            List<AddresslistUser> res =  iAddresslistUserService.getOnesByDepart(depart_id.trim());
            /*强制转换隐藏手机号为110*/
            for (int i=0;i<res.size();i++){
                if (res.get(i).getIsHidden() ==(long)1){
                    res.get(i).setPhoneNum((long) 0000);
                }
            }
            json.put("value",res);
            json.put("msg",1);//
            DoAjax.doAjax(response, json, null);
        }

//        return  users;
    }

    /*
     响应搜索功能，判断输入为姓名或手机号进行查询，返回人员列表

     */
    @RequestMapping("search")
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
                List<Organization> groupNameList = iOrganizationService.getNameByGroupId(res.get(0).getGroupId());
                /*强制转换隐藏手机号为110*/
                for (int i=0;i<res.size();i++){
                    if (res.get(i).getIsHidden() ==(long)1){
                        res.get(i).setPhoneNum((long) 0000);
                    }
                }
                json.put("value",res);
                json.put("groupNameList",groupNameList);
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
//                List groupNameList = new ArrayList<Organization>();
                List<Organization> groupNameList = new ArrayList<Organization>();
                List<Organization> groupNameList3 = new ArrayList<Organization>();
                List<Organization> groupNameList6 = new ArrayList<Organization>();
//                for (int i = 0; i<res.size();i++){
//                }
//                List<Organization> groupNameList = iOrganizationService.getNameByGroupId(res.get(0).getGroupId());
//                Organization a = new Organization();

                /*强制转换隐藏手机号为110*/
//                System.out.println(res.size()+"aaaaaaaaaaaaaaares.size");
//                System.out.println(res.get(0).getGroupId()+"   res.get(0).getGroupId()");
//                System.out.println(iOrganizationService.getNameByGroupId(res.get(0).getGroupId()).get(0)+"     aaaa");
//                groupNameList.add(iOrganizationService.getNameByGroupId(res.get(0).getGroupId()).get(0));
//                System.out.println((res.get(0).getGroupId())+"   res.get(0).getGroupId()");


                for (int i=0;i<res.size();i++){
//                    System.out.println(res.size()+"aaaaaaaaaaaaaaares.size");
//                    System.out.println(res.get(i).getGroupId()+"   res.get(0).getGroupId()");
//                    System.out.println(iOrganizationService.getNameByGroupId(res.get(i).getGroupId()).get(0)+"     aaaa");
                    /*通过组织ID查询组织名称  并且add
                    *
                    * 适用于重名
                    * */
//                    iOrganizationService.getNameByGroupId(res.get(i).getGroupId());
//                    groupNameList.add(iOrganizationService.getNameByGroupId(res.get(i).getGroupId()));

//                    if (res.get(i).getGroupId().length()==9){
//
//                    }else{
//
//                    }
                    groupNameList.add(iOrganizationService.getNameByGroupId(res.get(i).getGroupId()).get(0));
                    groupNameList3.add(iOrganizationService.getNameByGroupId(res.get(i).getGroupId().substring(0,res.get(i).getGroupId().length()-3)).get(0));
                    groupNameList6.add(iOrganizationService.getNameByGroupId(res.get(i).getGroupId().substring(0,res.get(i).getGroupId().length()-6)).get(0));
                    /*强制转换 隐藏手机号为0000*/
                    if ( res.get(i).getIsHidden() == (long) 1){
                        res.get(i).setPhoneNum((long) 0000);
                    }
                }
                json.put("groupNameList",groupNameList);
                json.put("groupNameList3",groupNameList3);
                json.put("groupNameList6",groupNameList6);
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
    @RequestMapping("loginByPhone")
    public void loginByPhone (HttpServletResponse response, HttpServletRequest request,String phone_num)
    {
        JSONObject json = new JSONObject();
//        if(request.getSession(false)==null){
//            json.put("msg",0);//
//            DoAjax.doAjax(response, json, null);
//            System.out.println("qingdenglu");
//        }else {
            boolean res = iAddresslistUserService.loginByPhone(Long.parseLong(phone_num.trim()));
            /*有相应的手机号*/
            if(res){
            /*
            * 如果可以在
            * department_administrator
            * 查询到数据 则证明此人是管理员
            * 可以产生随机码
            * 返回ture
            * */
            String suijima = randomMessageNumber.getIntRandomNumber()+"";//
            String suijimaTime = getNowTime.getNowTimeByJava();//
            /*产生两张表
            * 一张是已存在的用户信息表，具备其他信息
            * 一张是暴漏的业支的表，只有用户说几号和随机码，10分钟删除一次
            *
            * 同时把这些信息写进两张表中
            *
            * 在MessageSendController中写判断是否可以登录
            *
            * 判断其中的信息，手机号 和  验证码
            * */
            /*写进短信下发表中*/
            AddresslistMessageSend addresslistMessageSend = new AddresslistMessageSend();
            addresslistMessageSend.setPhoneNum(Long.parseLong(phone_num.trim()));
            addresslistMessageSend.setSendTime(suijimaTime);
            addresslistMessageSend.setSendText(suijima);
            addresslistMessageSend.setSendStatus(1);
            iAssresslistMessageSendService.insert(addresslistMessageSend);

            /*写进 给业支的send 表中*/
            Send send = new Send();
            send.setPhoneNumber(Long.parseLong(phone_num.trim()));
            String hehe = "【打死也不要告诉任何人你的验证码！】尊敬的用户您好，您本次登录验证码为："+suijima+"。此验证码有效期为十分钟。";
            send.setText(hehe);
            send.setVerifyCode(suijima);
            System.out.println(send+"send!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            iSendService.insert(send);

            json.put("flag",res);
//            json.put("msg",1);//
            DoAjax.doAjax(response, json, null);

            }else {
                /*没有相应的手机号*/
                json.put("flag",res);
//            json.put("msg",1);//
                DoAjax.doAjax(response, json, null);

            }

//        }

//         return res;
    }

    /*
   响应登录，再短信验证
   */
    @RequestMapping("loginByMsg")
    public void loginByMsg (HttpServletResponse response, HttpServletRequest request, String phoneNumber,String verifyCode)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
//        System.out.println("111"+"  session  "+ session.getId());
//        //将数据存储到session中
//        session.setAttribute("data", phoneNumber);

        //判断session是不是新创建的


        String sessionhao = "";
        if (session.getAttribute("data")!=null){
             sessionhao = session.getAttribute("data").toString();
        }else {
             sessionhao="q";
        }

        System.out.println(sessionhao+"      sessionhao");
        String dianhua = phoneNumber;
        System.out.println(dianhua+"      dianhua");

//        !sessionhao.equals(dianhua)
//        dianhua!=sessionhao
        if (dianhua!=sessionhao) {
            System.out.println("weishabuxingdeng");

            long phoneNumberLong = Long.parseLong(phoneNumber);
//            System.out.println("zheli!0000000000000000");
            boolean res1 = iSendService.queryPhoneNumAndVerifyCode(phoneNumberLong,verifyCode);
            /*登录成功*/
            if(res1){
                //将数据存储到session中
                session.setAttribute("data", phoneNumber);
                //获取session的Id
                String sessionId = session.getId();
                System.out.println("session创建成功，(zhetamakexueme ?)session的id是："+sessionId);
                JSONObject json = new JSONObject();
//            System.out.println("zheli!111111111111111111");
            /*插入app登录日志表*/
                AddresslistAppLogin addresslistAppLogin = new AddresslistAppLogin();
                addresslistAppLogin.setPhoneNum(phoneNumberLong);
                addresslistAppLogin.setLoginTime(getNowTime.getNowTimeByJava());
//                int a = 3;
//                if(res){
//                    a = 1;
//                }else {
//                    a = 0;
//                }
//            System.out.println("zheli!22222222222222222222");
                addresslistAppLogin.setLoginResult(1);
                addresslistAppLogin.setPhoneType("我怎么知道?");
                addresslistAppLogin.setPhoneImei("buzhidao");
//            System.out.println("!!!!!!!!!!!!!!!!!!!   "+addresslistAppLogin.toString()+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                iAddresslistAppLoginService.insert(addresslistAppLogin);
//            System.out.println("zheli!333333333333333333333");
                boolean res = true;
                json.put("flag",res);
                DoAjax.doAjax(response, json, null);
            }else{
                /*登录失败*/

//                System.out.println("session创建shibai，(zhetamakexueme ?)session的id是："+session.getId());
                JSONObject json = new JSONObject();
            /*插入app登录日志表*/
                AddresslistAppLogin addresslistAppLogin = new AddresslistAppLogin();
                addresslistAppLogin.setPhoneNum(phoneNumberLong);
                addresslistAppLogin.setLoginTime(getNowTime.getNowTimeByJava());
                addresslistAppLogin.setLoginResult(0);
                addresslistAppLogin.setPhoneType("我怎么知道?");
                addresslistAppLogin.setPhoneImei("buzhidao");
//            System.out.println("!!!!!!!!!!!!!!!!!!!   "+addresslistAppLogin.toString()+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                iAddresslistAppLoginService.insert(addresslistAppLogin);
//            System.out.println("zheli!333333333333333333333");
                boolean res = false;
                json.put("flag",res);
                DoAjax.doAjax(response, json, null);
            }

        }else {
            //获取session的Id
            String sessionId = session.getId();
            System.out.println("服务器已经存在该session了，session的id是："+sessionId);
            boolean res = true;
            JSONObject json = new JSONObject();
            json.put("phoneNumber",phoneNumber);
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

    @RequestMapping("logOut")
    public void logOut(HttpServletResponse response, HttpServletRequest request,String depart_id)
    {
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession();
        session.invalidate();
        json.put("msg",1);//
        DoAjax.doAjax(response, json, null);
        System.out.println("logout");
//        return  users;
    }




}

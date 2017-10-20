package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.entity.Send;
import com.hmcc.contact.service.IManagementOperationsLogService;
import com.hmcc.contact.service.ISendService;
import com.hmcc.contact.util.getNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hmcc.contact.util.DoAjax;

import com.hmcc.contact.web.controller.SendController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 * ----------Dragon be here!----------/
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
 */

@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private ISendService iSendService;
    @Autowired
    private IManagementOperationsLogService iManagementOperationsLogService;

    /*验证用户名密码
    * 传入手机号 phoneNumber 和验证码 verifyCode
    * 返回boolean值
    * true登陆成功
    * flase登录失败
    *
    * url:/send/queryPhoneNumAndVerifyCode.do?phoneNumber = xxx & verifyCode = xxx
    * */
    @GetMapping("queryPhoneNumAndVerifyCode")
    public void queryPhoneNumAndVerifyCode( HttpServletResponse response, HttpServletRequest request,String phoneNumber,String verifyCode){

//        HttpSession session = request.getSession(true);
//        session.setAttribute("logined",phoneNumber);
//        System.out.println(session.getId()+"      session");

//        JSONObject json = new JSONObject();
//        Send send = new Send();
//        send.getVerifyCode();
//        long phoneNumberjson = Long.parseLong(request.getParameter("phoneNumber"));
//        String verifyCodejson = request.getParameter("phoneNumber");
//        System.out.println(phoneNumberjson);
//        System.out.println(verifyCodejson+"-----------------verifyCodejson");
//        System.out.println(request+"-----------------request");
//        System.out.println(response+"------------------response");
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
            System.out.println("session创建成功，session的id是：" + sessionId);
            JSONObject json = new JSONObject();
            long phoneNumberLong = Long.parseLong(phoneNumber);
            boolean res = iSendService.queryPhoneNumAndVerifyCode(phoneNumberLong,verifyCode);



            int a = 3;
            if(res){
                a = 1;
            }else {
                a = 0;
            }
            ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
            managementOperationsLog.setAdminId(phoneNumberLong);
            //调用工具类 湖区当前时间
            getNowTime nowTime = new getNowTime();
            String create_time = nowTime.getNowTimeByJava();
            //把参数都放进去
            managementOperationsLog.setCreateTime(create_time);
//            managementOperationsLog.setOperationsLog(operations_log);
            managementOperationsLog.setOperationsResult(a);
//            managementOperationsLog.setOperationsIp(operations_ip);
            iManagementOperationsLogService.insert(managementOperationsLog);





            json.put("flag",res);
            DoAjax.doAjax(response, json, null);
        }else {
            System.out.println("服务器已经存在该session了，session的id是："+sessionId);
            boolean res = true;
            JSONObject json = new JSONObject();
            json.put("flag",res);
            DoAjax.doAjax(response, json, null);
        }


//        long phoneNumberLong = Long.parseLong(phoneNumber);



//        json.put("session",session);


        //return iSendService.queryPhoneNumAndVerifyCode(phoneNumberjson,verifyCodejson);
    }


	
}

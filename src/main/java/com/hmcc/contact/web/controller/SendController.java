package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.Send;
import com.hmcc.contact.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /*验证用户名密码
    * 传入手机号 phoneNumber 和验证码 verifyCode
    * 返回boolean值
    * true登陆成功
    * flase登录失败
    *
    * url:/send/queryPhoneNumAndVerifyCode.do?phoneNumber = xxx & verifyCode = xxx
    * */
    @GetMapping("queryPhoneNumAndVerifyCode")
    public boolean queryPhoneNumAndVerifyCode( long phoneNumber, String verifyCode){
//        HttpServletResponse response, HttpServletRequest request,
//        JSONObject json = new JSONObject();
//        Send send = new Send();
//        send.getVerifyCode();
//        Object a = request.getSession().getAttribute("s");
//        System.out.println(a);
//        DoAjax.doAjax(response, json, null);
        return iSendService.queryPhoneNumAndVerifyCode(phoneNumber,verifyCode);
    }


	
}

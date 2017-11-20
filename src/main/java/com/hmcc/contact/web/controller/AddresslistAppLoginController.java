package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.AddresslistAppLogin;
import com.hmcc.contact.util.DoAjax;
import com.hmcc.contact.util.getNowTime;
import com.hmcc.contact.service.IAddresslistAppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/addresslistAppLogin")
public class AddresslistAppLoginController {

    @Autowired
    private IAddresslistAppLoginService iAddresslistAppLoginService;
//    @Autowired
//    private

    /*查询用户是否可以免登陆
    * 使用手机号和IMEI查询曾经的登录日志
    * 如果存在 返回ture，
    * 如果不存在 返回 flase
    *
    * url:/addresslistAppLogin/CheckUserPhoneNumber.do?phoneNumber = xxx & phoneImei = xxx
    *
    * */
    @RequestMapping("CheckUserPhoneNumber")
    public boolean CheckUserPhoneNumber(long phoneNumber,String phoneImei) {
        boolean loginWithoutVerify;
        loginWithoutVerify = iAddresslistAppLoginService.CheckUserPhoneNumber(phoneNumber,phoneImei);
        //免登成功
        if (loginWithoutVerify){//ture
            //插入App登陆日志表
            AddresslistAppLogin addresslistAppLogin = new AddresslistAppLogin();
            addresslistAppLogin.setPhoneNum(phoneNumber);
            addresslistAppLogin.setLoginTime(getNowTime.getNowTimeByJava());
            addresslistAppLogin.setLoginResult(1);
            addresslistAppLogin.setPhoneType("我怎么知道?");
            addresslistAppLogin.setPhoneImei(phoneImei);
            iAddresslistAppLoginService.insert(addresslistAppLogin);
            return loginWithoutVerify;
        }else {//false
            //免登失败，返回false
            return loginWithoutVerify;
        }
    }

    /*App版本号对比 系统自带版本号
    *
    * 大了ture 不升级
    * 小了flase 升级
    *
    * url:/hmcc/addresslistAppLogin/checkBetaNumber.do?betaNumber = xxx
    *
    * 虽说。。。没有在数据库里写利于操作
    * 不过，总的来说，你升级版本肯定要改代码。
    * 不用其他三层的操作。。。
    * 所以。。。挺好用的
    * */
    @RequestMapping("checkBetaNumber")
    public void checkBetaNumber(HttpServletResponse response, HttpServletRequest request, String betaNumber){
        System.out.println(betaNumber+"   1111111111111111111111betaNumber");
         int abb = Integer.parseInt(betaNumber);
        //系统当前版本号
        //系统当前版本号
        int systemBetaNumber = 2;
        System.out.println(betaNumber+"   1111111111111111111111betaNumber");
        JSONObject json = new JSONObject();
        boolean res  =  (systemBetaNumber>abb);
        json.put("flag",res);
        DoAjax.doAjax(response, json, null);
    }

}

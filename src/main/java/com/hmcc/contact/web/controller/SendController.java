package com.hmcc.contact.web.controller;


import com.hmcc.contact.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private ISendService iSendService;

    /*验证用户名密码*/
    @GetMapping("queryPhoneNumAndVerifyCode")
    public boolean queryPhoneNumAndVerifyCode(long phoneNumber,String verifyCode){

        return iSendService.queryPhoneNumAndVerifyCode(phoneNumber,verifyCode);

    }


	
}

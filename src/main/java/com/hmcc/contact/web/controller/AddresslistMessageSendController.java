package com.hmcc.contact.web.controller;



import com.hmcc.contact.service.IAddresslistMessageSendService;
import com.hmcc.contact.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 *----------Dragon be here!----------/
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
 * ━━━━━━神兽出没━━━━━━by:coder-pig
 */
/**
 * <p>
 * 短信下发表 前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-13
 */
@RestController
@RequestMapping("/addresslistMessageSend")
public class AddresslistMessageSendController {

    @Autowired
    private IAddresslistMessageSendService iAssresslistMessageSendService;

    @Autowired
    private ISendService iSendService;

    /*验证用户名密码*/
    @GetMapping("queryPhoneNumAndVerifyCode")
    public boolean queryPhoneNumAndVerifyCode(long phoneNumber,String verifyCode){
        return iSendService.queryPhoneNumAndVerifyCode(phoneNumber,verifyCode);
    }

//    @GetMapping
//    public int insert(long phoneNumber){
//        return 0;
//    }

    /*
     响应登录，先检查手机号是否在库中
     */
    //        此方法不是一个通用方法
    //        由于查询的数据库不同。仅提供给管理员使用
//    @GetMapping("loginByCheckPhoneNumber")
//    public int loginByCheckPhoneNumber(long phoneNumber){
////        iAssresslistMessageSendService.
//        return 0;
//    }



    /*
    响应登录，再短信验证
    */
//    @GetMapping("loginBySendMessage")
//    public int loginBySendMessage(long phoneNumber){
//
//        return 0;
//    }

	
}

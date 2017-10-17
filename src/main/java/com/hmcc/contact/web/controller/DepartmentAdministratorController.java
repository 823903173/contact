package com.hmcc.contact.web.controller;


import com.hmcc.contact.entity.AddresslistMessageSend;
import com.hmcc.contact.entity.DepartmentAdministrator;
import com.hmcc.contact.entity.Send;
import com.hmcc.contact.service.IAddresslistMessageSendService;
import com.hmcc.contact.service.IDepartmentAdministratorService;
import com.hmcc.contact.service.ISendService;
import com.hmcc.contact.util.getNowTime;
import com.hmcc.contact.util.randomMessageNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
 * ━━━━━━神兽出没━━━━━━by:coder-chenhao
 */
/**
 * <p>
 * 部门管理员表 前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
@RestController
@RequestMapping("/departmentAdministrator")
public class DepartmentAdministratorController {

    @Autowired
    private IDepartmentAdministratorService iDepartmentAdministratorService;
    @Autowired
    private IAddresslistMessageSendService iAssresslistMessageSendService;
    @Autowired
    private ISendService iSendService;

    /*
    【前台看这里！！】
     响应登录，先检查手机号是否在库中
     url:/departmentAdministrator/CheckDepartmentPhoneNumber.do?phoneNumber = xxx
     返回值：
     点击获取验证码后，
     若返回true则可以获得验证码，若false则不可获得验证码
     */

    //        for programmer
    //        此方法不是一个通用方法
    //        由于查询的数据库不同。仅提供给管理员使用
    @GetMapping("CheckDepartmentPhoneNumber")
    public boolean CheckDepartmentPhoneNumber(long phoneNumber){
        boolean CheckPhoneNum;
        CheckPhoneNum = iDepartmentAdministratorService.CheckDepartmentPhoneNumber(phoneNumber);

        if(CheckPhoneNum){
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
            addresslistMessageSend.setPhoneNum(phoneNumber);
            addresslistMessageSend.setSendTime(suijimaTime);
            addresslistMessageSend.setSendText(suijima);
            addresslistMessageSend.setSendStatus(1);
            iAssresslistMessageSendService.insert(addresslistMessageSend);

            /*写进 给业支的send 表中*/
            Send send = new Send();
            send.setPhoneNumber(phoneNumber);
            String hehe = "【打死也不要告诉任何人你的验证码！】尊敬的用户您好，您本次登录验证码为："+suijima+"。此验证码有效期为十分钟。";
            send.setVerifyCode(hehe);
            iSendService.insert(send);

//            System.out.println(addresslistMessageSend+"~~~~~~~~~~~~addresslistMessageSend");
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//            System.out.println(send+"~~~~~~~~~~~~~~~~~send");

            return CheckPhoneNum;
        }else {//若不能，则不能产生随机码
            System.out.println("查不到");
            return CheckPhoneNum;
        }


//        return CheckPhoneNum;


    }


	
}

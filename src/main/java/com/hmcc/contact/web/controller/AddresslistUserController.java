package com.hmcc.contact.web.controller;


import com.hmcc.contact.entity.AddresslistUser;

import com.hmcc.contact.service.IAddresslistUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * 个人信息表 前端控制器
 * </p>
 *
 * @author CuiYong
 * @since 2017-09-27
 */
@RestController
@RequestMapping("/app")
public class AddresslistUserController {

    @Autowired
    private IAddresslistUserService iAddresslistUserService;



    /*
       响应人员个人信息展示页面
       根据人员id返回所有信息
       url= getOneAll.do?id = xxx
    */
    @GetMapping("getOneAll")
    public AddresslistUser getOneAll(String id)
    {
        AddresslistUser user =  iAddresslistUserService.getOneInfo(Integer.parseInt(id));
        return user;

    }

    /*
   响应机构人员列表
   根据机构id返回其所有人员列表
   url:getOnesOfDepart.do?depart_id = xxx
   */
    @GetMapping("getOnesOfDepart")
    public List<AddresslistUser> getOnesOfDepart(String depart_id)
    {
        List<AddresslistUser> users =  iAddresslistUserService.getOnesByDepart(Integer.parseInt(depart_id.trim()));
        return  users;

    }

    /*
     响应搜索功能，判断输入为姓名或手机号进行查询，返回人员列表

     */
    @GetMapping("search")
    public List<AddresslistUser> searchByNameOrNum (String str_input)
    {

        //判断输入是否全为数字
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(str_input).matches())
        {
            return iAddresslistUserService.searchByPhoneNum(Long.parseLong(str_input));
        }


        String str = "15937128877";
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
            return iAddresslistUserService.searchByName(str.trim());
        }

        return null;

    }
    /*
    响应登录，先检查手机号是否在库中
    大于1则表示存在

    */
    @GetMapping("loginByPhone")
    public int loginByPhone (String phone_num)
    {
         int rs = iAddresslistUserService.loginByPhone(Long.parseLong(phone_num.trim()));
         return rs;
    }

    /*
   响应登录，再短信验证
   */
    @GetMapping("loginByMsg")
    public boolean loginByMsg (String phone_num)
    {

        return  true;
    }

    /*
    根据手机号验证操作时是否登录或session超时
    */
    private Boolean VerifyOperation(String phoneNum)
    {

        return true;

    }
}

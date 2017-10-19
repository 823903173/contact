package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.service.IAddresslistAppLoginService;
import com.hmcc.contact.entity.*;
import com.hmcc.contact.service.IAddresslistUserService;
import com.hmcc.contact.service.IOrganizationService;
import com.hmcc.contact.util.DoAjax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
 * @since 2017-10-19
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService iOrganizationService;
    @Autowired
    private IAddresslistUserService iAddresslistUserService;


    /*根据组织ID展示下级组织信息
    * （点击本级组织，获得下级组织所有ID等deng信息）
    *
    * */
    @GetMapping("getIdByGroupId")
    public void getIdByGroupId(HttpServletResponse response, HttpServletRequest request,String id){
        JSONObject json = new JSONObject();
        List<Organization> res = iOrganizationService.getIdByGroupId(id);
        if (res.size()==0 || res.isEmpty()){
            System.out.println("res shi kong");
            List<AddresslistUser> resOfUser = iAddresslistUserService.getOnesByDepart(id);
            json.put("isEnd",true);
            json.put("value",resOfUser);
            DoAjax.doAjax(response, json, null);
        }else {
            System.out.println("RES BUSHI KONG");
            json.put("isEnd",false);
            json.put("value",res);
            DoAjax.doAjax(response, json, null);
        }




//        System.out.println(res);


    }

    /*
    *
    *
    * */



	
}

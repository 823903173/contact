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
import javax.servlet.http.HttpSession;
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
    @RequestMapping("getIdByGroupId")
    public void getIdByGroupId(HttpServletResponse response, HttpServletRequest request,String id){
//        JSONObject json = new JSONObject();
        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            List<Organization> res = iOrganizationService.getIdByGroupId(id);
        /*查询组织下所有组织
        *
        *
        * 如果是空
        * 查询该组织ID下所有人员信息列表*/
            if (res.size()==0 || res.isEmpty()){
                System.out.println("res shi kong");
                List<AddresslistUser> resOfUser = iAddresslistUserService.getOnesByDepart(id);
                /*强制转换隐藏手机号为110*/
                System.out.println(resOfUser.size()+"      size");
                for (int i=0;i<resOfUser.size();i++){
                    System.out.println(resOfUser.get(i).getIsHidden()+"             hiden");
                    if (resOfUser.get(i).getIsHidden() ==(long)1){
                        resOfUser.get(i).setPhoneNum((long) 0000);
                    }
                }




                json.put("msg",1);//
                json.put("isEnd",true);
                json.put("OrganizationValue",null);
                json.put("UserValue",resOfUser);
                DoAjax.doAjax(response, json, null);
            }else {
//          * 如果是不空
//          * 返回下级所有组织结构
                System.out.println("RES BUSHI KONG");
                json.put("msg",1);//
                json.put("isEnd",false);
                json.put("OrganizationValue",res);
                json.put("UserValue",null);
                DoAjax.doAjax(response, json, null);
            }
//        System.out.println(res);
        }

    }
    /*首页展示
     * 传入 手机号码
     * 返回 所在级别的上两层组织结构
      *eg：18803712866
      *组织ID：030-017-005
      * 河南省（31个地区） 许昌市（18地市） 许昌县（五县一区）
      *
      *
      * 手机号码 查 组织ID
      *
      * 获取组织ID后判断长度，查询
      * */
    @RequestMapping("showIndexPage")
    public void showIndexPage(HttpServletResponse response, HttpServletRequest request,long phoneNumber){
//        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        if(request.getSession(false)==null){
            json.put("msg",0);//
            DoAjax.doAjax(response, json, null);
            System.out.println("qingdenglu");
        }else {
            String s = "000";
            List<AddresslistUser> list =iAddresslistUserService.searchByPhoneNum(phoneNumber);
            System.out.println("list        " +list  );
            List<Organization> listName = iOrganizationService.getNameByGroupId(list.get(0).getGroupId());
            System.out.println("listName        " +listName  );
            s = list.get(0).getGroupId();
            if (s.substring(0,s.length()-6).length()==0){
                System.out.println("            a"+s.substring(0,s.length()-3));
//                List<AddresslistUser> fatherList = iAddresslistUserService.getOnesByDepart(s.substring(0,s.length()-3));
//                String fatherListName = fatherList.get(0).getGroupId();
                List<Organization> fatherListName = iOrganizationService.getNameByGroupId(s.substring(0,s.length()-3));

                json.put("msg",1);//
                json.put("userInfo",list);
                json.put("list",listName);
                json.put("fartherList",fatherListName);
                json.put("grandFatherList",null);
                DoAjax.doAjax(response, json, null);
            }else {
                System.out.println("            b"+s.substring(0,s.length()-6));
                System.out.println("SSSSSSS  " +s);
                System.out.println("S.lenth-----3  " +s.substring(0,s.length()-3));
//                List<AddresslistUser> fatherList = iAddresslistUserService.getOnesByDepart(s.substring(0,s.length()-3));
//                System.out.println("fatherList  " +fatherList);
//                System.out.println("fatherList.get(0).getGroupId()  " +fatherList.get(0).getGroupId());

                List<Organization> fatherListName = iOrganizationService.getNameByGroupId(s.substring(0,s.length()-3));
                System.out.println("fatherListName  " +fatherListName);

//                List<AddresslistUser> grandFatherList = iAddresslistUserService.getOnesByDepart(s.substring(0,s.length()-6));
                List<Organization> grandFatherListName = iOrganizationService.getNameByGroupId(s.substring(0,s.length()-6));
                json.put("msg",1);//
                json.put("userInfo",list);
                json.put("list",listName);
                json.put("fartherList",fatherListName);
                json.put("grandFatherList",grandFatherListName);
                DoAjax.doAjax(response, json, null);
            }
        }
    }




	
}

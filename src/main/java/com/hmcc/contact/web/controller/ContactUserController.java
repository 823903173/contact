package com.hmcc.contact.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactUser;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.mapper.ContactAdminDao;
import com.hmcc.contact.service.ContactUserService;
import com.hmcc.contact.service.IManagementOperationsLogService;
import com.hmcc.contact.util.DoAjax;
import com.hmcc.contact.util.getNowTime;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by TR on 2017/10/12.
 */
@RestController
@RequestMapping("/ContactUserlogin")
public class ContactUserController {
    @Autowired
    private ContactUserService contactUserService;
    @Autowired
    private ContactAdminDao contactAdminDao;
    @Autowired
    private IManagementOperationsLogService iManagementOperationsLogService;

//    @GetMapping("chenhaotolizhengtao")
//    public void chenhaotolizhengtao(HttpServletResponse response, HttpServletRequest request){
////        ModelAndView modelAndView = new ModelAndView();
//        JSONObject json = new JSONObject();
//        if(request.getSession(false)==null){
//            json.put("msg",0);//
//            DoAjax.doAjax(response, json, null);
//            System.out.println("qingdenglu");
//        }else {
//            toLoginPage();
//            json.put("msg",1);//
//            DoAjax.doAjax(response, json, null);
//            System.out.println("chaxunchengg");
//        }
//
//    }

    @RequestMapping("/toImportExcel")
    public ModelAndView toLoginPage(String phoneNum){

//        String phoneNum = "13503860966";
        ContactAdmin contactAdmin = contactAdminDao.getAdmin(Long.valueOf(phoneNum));
//        System.out.println(contactAdmin.toString()+"           ");
        ModelAndView mv = new ModelAndView("importSimExcelContact");
        mv.addObject("contactAdmin",contactAdmin);
        return mv;
    }


    @RequestMapping(value="/insertSimExcel", method= RequestMethod.POST)
    public ModelAndView toImportExcel(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum,Long contactNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactUser> contactUsers = contactUserService.importExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactUsers", contactUsers);
            mav.addObject("contactAdminNum",contactAdminNum);
            mav.addObject("contactNumber",contactNumber);
            mav.setViewName("Contactsuccess");
            in.close();

            /*插入管理日志表！！！！！！！！
            *
            *
            *
            * 后端操作
            * */
            //        创建一个对象
            ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
            managementOperationsLog.setAdminId((long)contactNumber);
            //调用工具类 湖区当前时间
            getNowTime nowTime = new getNowTime();
            String create_time = nowTime.getNowTimeByJava();
            //把参数都放进去
            managementOperationsLog.setCreateTime(create_time);
            managementOperationsLog.setOperationsLog("insertUserInfo");
            managementOperationsLog.setOperationsResult(1);
            managementOperationsLog.setOperationsIp("Idonotknow");
            iManagementOperationsLogService.insert(managementOperationsLog);




            return mav;
        }
        mav.addObject("contactAdminNum",contactAdminNum);
        mav.addObject("contactNumber",contactNumber);
        mav.setViewName("error");


        /*插入管理日志表！！！！！！！！
            *
            *
            *
            * 后端操作
            * */
        //        创建一个对象
        ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
        managementOperationsLog.setAdminId((long)contactNumber);
        //调用工具类 湖区当前时间
        getNowTime nowTime = new getNowTime();
        String create_time = nowTime.getNowTimeByJava();
        //把参数都放进去
        managementOperationsLog.setCreateTime(create_time);
        managementOperationsLog.setOperationsLog("insertUserInfo");
        managementOperationsLog.setOperationsResult(0);
        managementOperationsLog.setOperationsIp("Idonotknow");
        iManagementOperationsLogService.insert(managementOperationsLog);




        return mav;
    }
    @RequestMapping(value="/deleteSiminfo", method= RequestMethod.POST)
    public ModelAndView toDeleteInfo(@RequestParam("file") MultipartFile file,Long contactNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactUser> contactUsers = contactUserService.DeleteExcelInfo(in,file);
            mav.addObject("contactUsers", contactUsers);
            mav.addObject("contactNumber",contactNumber);
            mav.setViewName("Contactsuccess");
            in.close();


            /*插入管理日志表！！！！！！！！
            *
            *
            *
            * 后端操作
            * */
            //        创建一个对象
            ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
            managementOperationsLog.setAdminId((long)contactNumber);
            //调用工具类 湖区当前时间
            getNowTime nowTime = new getNowTime();
            String create_time = nowTime.getNowTimeByJava();
            //把参数都放进去
            managementOperationsLog.setCreateTime(create_time);
            managementOperationsLog.setOperationsLog("deleteUserInfo");
            managementOperationsLog.setOperationsResult(1);
            managementOperationsLog.setOperationsIp("Idonotknow");
            iManagementOperationsLogService.insert(managementOperationsLog);
            return mav;
        }
        mav.setViewName("error");
        mav.addObject("contactNumber",contactNumber);
                    /*插入管理日志表！！！！！！！！
            *
            *
            *
            * 后端操作
            * */
        //        创建一个对象
        ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
        managementOperationsLog.setAdminId((long)contactNumber);
        //调用工具类 湖区当前时间
        getNowTime nowTime = new getNowTime();
        String create_time = nowTime.getNowTimeByJava();
        //把参数都放进去
        managementOperationsLog.setCreateTime(create_time);
        managementOperationsLog.setOperationsLog("deleteUserInfo");
        managementOperationsLog.setOperationsResult(0);
        managementOperationsLog.setOperationsIp("Idonotknow");
        iManagementOperationsLogService.insert(managementOperationsLog);




        return mav;
    }
}

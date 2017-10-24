package com.hmcc.contact.web.controller;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactOrg;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.service.ContactAdminService;
import com.hmcc.contact.service.ContactOrgService;
import com.hmcc.contact.service.IManagementOperationsLogService;
import com.hmcc.contact.util.getNowTime;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by TR on 2017/10/17.
 */
@Controller
@RequestMapping("/ContactOrglogin")
public class ContactOrgController {

    @Autowired
    private ContactOrgService contactOrgService;
    @Autowired
    private IManagementOperationsLogService iManagementOperationsLogService;

//    @RequestMapping("/toImportExcel")
//    public ModelAndView toLoginPage(){
//        ModelAndView mv = new ModelAndView("importSimExcelContact");
//        return mv;
//    }

    @RequestMapping(value="/insertOrgExcel", method= RequestMethod.POST)
    public ModelAndView toImportExcel(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum,Long contactNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactOrg> contactOrgs = contactOrgService.importExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactOrgs", contactOrgs);
            mav.addObject("contactNumber",contactNumber);
            mav.setViewName("ContactOrgsuccess");
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
            managementOperationsLog.setOperationsLog("insertOrgExcel");
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
        managementOperationsLog.setOperationsLog("insertOrgExcel");
        managementOperationsLog.setOperationsResult(0);
        managementOperationsLog.setOperationsIp("Idonotknow");
        iManagementOperationsLogService.insert(managementOperationsLog);
        return mav;
    }
    @RequestMapping(value="/deleteOrginfo", method= RequestMethod.POST)
    public ModelAndView toDeleteInfo(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum,Long contactNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactOrg> contactOrgs = contactOrgService.DeleteExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactOrgs", contactOrgs);
            mav.addObject("contactNumber",contactNumber);
            mav.setViewName("ContactOrgsuccess");
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
            managementOperationsLog.setOperationsLog("deleteOrginfo");
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
        managementOperationsLog.setOperationsLog("deleteOrginfo");
        managementOperationsLog.setOperationsResult(0);
        managementOperationsLog.setOperationsIp("Idonotknow");
        iManagementOperationsLogService.insert(managementOperationsLog);
        return mav;
    }
}

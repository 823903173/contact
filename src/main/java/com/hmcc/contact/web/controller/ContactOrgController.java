package com.hmcc.contact.web.controller;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactOrg;
import com.hmcc.contact.service.ContactAdminService;
import com.hmcc.contact.service.ContactOrgService;
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

//    @RequestMapping("/toImportExcel")
//    public ModelAndView toLoginPage(){
//        ModelAndView mv = new ModelAndView("importSimExcelContact");
//        return mv;
//    }

    @RequestMapping(value="/insertOrgExcel", method= RequestMethod.POST)
    public ModelAndView toImportExcel(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactOrg> contactOrgs = contactOrgService.importExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactOrgs", contactOrgs);
            mav.setViewName("ContactOrgsuccess");
            in.close();
            return mav;
        }
        mav.setViewName("error");
        return mav;
    }
    @RequestMapping(value="/deleteOrginfo", method= RequestMethod.POST)
    public ModelAndView toDeleteInfo(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactOrg> contactOrgs = contactOrgService.DeleteExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactOrgs", contactOrgs);
            mav.setViewName("ContactOrgsuccess");
            in.close();
            return mav;
        }
        mav.setViewName("error");
        return mav;
    }
}

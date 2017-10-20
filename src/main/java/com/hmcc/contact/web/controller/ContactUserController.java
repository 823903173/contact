package com.hmcc.contact.web.controller;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactUser;
import com.hmcc.contact.mapper.ContactAdminDao;
import com.hmcc.contact.service.ContactUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/toImportExcel")
    public ModelAndView toLoginPage(){
        String phoneNum = "13503860966";
        ContactAdmin contactAdmin = contactAdminDao.getAdmin(Long.valueOf(phoneNum));
        ModelAndView mv = new ModelAndView("importSimExcelContact");
        mv.addObject("contactAdmin",contactAdmin);
        return mv;
    }

    @RequestMapping(value="/insertSimExcel", method= RequestMethod.POST)
    public ModelAndView toImportExcel(@RequestParam("file") MultipartFile file,String contactAdminOrgId,Integer contactAdminNum) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactUser> contactUsers = contactUserService.importExcelInfo(in,file,contactAdminOrgId,contactAdminNum);
            mav.addObject("contactUsers", contactUsers);
            mav.setViewName("Contactsuccess");
            in.close();
            return mav;
        }
        mav.setViewName("error");
        return mav;
    }
    @RequestMapping(value="/deleteSiminfo", method= RequestMethod.POST)
    public ModelAndView toDeleteInfo(@RequestParam("file") MultipartFile file) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(!file.isEmpty()){
            //这里将上传得到的文件保存至 d:\\temp\\file 目录
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp\\file\\",
                    System.currentTimeMillis()+ file.getOriginalFilename()));
            InputStream in = file.getInputStream();
            //数据导入e
            List<ContactUser> contactUsers = contactUserService.DeleteExcelInfo(in,file);
            mav.addObject("contactUsers", contactUsers);
            mav.setViewName("Contactsuccess");
            in.close();
            return mav;
        }
        mav.setViewName("error");
        return mav;
    }
}

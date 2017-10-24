package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactOrg;
import com.hmcc.contact.mapper.ContactAdminDao;
import com.hmcc.contact.mapper.ContactOrgDao;
import com.hmcc.contact.service.ContactAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.ExcelUtilContact;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TR on 2017/10/17.
 */
@Service
public class ContactAdminServiceImpl implements ContactAdminService{
    @Autowired
    private ContactAdminDao contactAdminDao;

    public List<ContactAdmin> DeleteExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum ,Long contactNumber)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getDeleteInfo(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        List<String> l1 = new ArrayList<String>();
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);
            List<Object> ob = listob.get(i);
            if(ob.get(1)!=null){
                String str1 = contactAdminOrgId + ob.get(1);
                contactAdminDao.deleteAdminByPrimaryKey(str1);
            }
        }
        List<ContactAdmin> contactAdmins = contactAdminDao.selectAllAdmins();
        return contactAdmins;
    }
    public List<ContactAdmin> importExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum ,Long contactNumber)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getBankListByExcel(in,file.getOriginalFilename());
        List<ContactAdmin> contactAdmins = new ArrayList<>();
        ContactAdmin contactAdminnow = contactAdminDao.getAdmin(Long.valueOf(contactAdminNum));
        //for (int i = 1; i < listob.size()-1; i++) {
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);
            List<Object> ob = listob.get(i);
            ContactAdmin contactAdmin = new ContactAdmin();
            if(ob.get(0)!=null){
                String str1=ob.get(0).toString();
                String str2 = str1.substring(0,str1.length()-3);
                contactAdmin.setManagementNumber(Integer.valueOf(str2));
            }
            if(ob.get(1)!=null){
                String str1 = contactAdminOrgId+ ob.get(1).toString();
                contactAdmin.setOrganizationId(str1);
            }
            if(ob.get(2)!=null){
                contactAdmin.setContactNumber(Long.valueOf(ob.get(2).toString()));
            }
            if(1==1){
//                contactAdmin.setState(contactAdminnow.getState()+1);
            }
            if(1==1){
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                contactAdmin.setCreateTime(timestamp);
            }
            if(ob.get(4)!=null){
                contactAdmin.setCreateAdminId(contactAdminNum);
            }
            if(1==1){
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                contactAdmin.setLastModifiyTime(timestamp);
            }
            if(ob.get(5)!=null){
                contactAdmin.setLastModifiyAdminId(contactAdminNum);
            }
            if(ob.get(6)!=null){
                contactAdmin.setExtend1(ob.get(6).toString());
            }
            if(ob.get(7)!=null){
                contactAdmin.setExtend2(ob.get(7).toString());
            }
            if(ob.get(8)!=null){
                contactAdmin.setExtend3(ob.get(8).toString());
            }
            if(ob.get(9)!=null){
                contactAdmin.setExtend4(ob.get(9).toString());
            }
            contactAdminDao.deleteAdminByContactNum(contactAdmin.getContactNumber().toString());
            contactAdminDao.insertAdmins(contactAdmin);
            contactAdmins.add(contactAdmin);
        }

        return contactAdmins;
    }
       public ContactAdmin getAdmin(Long phoneNum)throws Exception{
        ContactAdmin contactAdmin = contactAdminDao.getAdmin(phoneNum);
        return contactAdmin;
    };

}

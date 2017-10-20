package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.ContactOrg;
import com.hmcc.contact.mapper.ContactOrgDao;
import com.hmcc.contact.service.ContactAdminService;
import com.hmcc.contact.service.ContactOrgService;
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
 * Created by TR on 2017/10/18.
 */
@Service
public class ContactOrgServiceImpl implements ContactOrgService{
    @Autowired
    private ContactOrgDao contactOrgDao;
    public List<ContactOrg> DeleteExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getDeleteInfo(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        List<String> l1 = new ArrayList<String>();
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);
            List<Object> ob = listob.get(i);
            if(ob.get(1)!=null){
                String str1 = contactAdminOrgId + ob.get(1);
                contactOrgDao.deleteOrgByPrimaryKey(str1);
            }

        }
        List<ContactOrg> contactOrgs = contactOrgDao.selectAllOrgs();
        return contactOrgs;
    }
    //判断用户是否存在
//    public ContactUser GetExistUser(int userId,String userName) {
//        ContactUser contactUser =  contactUserDao.selectExistUsers(userId,userName);
//        return contactUser;
//    }

    public List<ContactOrg> importExcelInfo(InputStream in, MultipartFile file, String contactAdminOrgId,Integer contactAdminNum)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getBankListByExcel(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        List<ContactOrg> contactOrgs = new ArrayList<>();
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            ContactOrg contactOrg = new ContactOrg();
            if(ob.get(1)!=null){
                String str1 = contactAdminOrgId+ ob.get(1).toString();
                contactOrg.setId(str1);
            }
            if(ob.get(10)!=null){
                contactOrg.setName(String.valueOf(ob.get(10)));
            }
            if(ob.get(11)!=null){
                contactOrg.setLevel(Integer.valueOf(ob.get(11).toString()));
            }
            if(ob.get(12)!=null){
                contactOrg.setStatus(Integer.valueOf(ob.get(12).toString()));
            }
            if(1==1){
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                contactOrg.setCreateTime(timestamp);
            }
            if(ob.get(4)!=null){
                contactOrg.setManagerId(contactAdminNum);
            }
            contactOrgDao.deleteOrgByPrimaryKey(contactOrg.getId());
            contactOrgDao.insertOrgs(contactOrg);
            contactOrgs.add(contactOrg);

        }

        return contactOrgs;
    }
}

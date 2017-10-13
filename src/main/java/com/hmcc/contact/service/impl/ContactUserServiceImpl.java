package com.hmcc.contact.service.impl;

import com.hmcc.contact.mapper.ContactUserDao;
import com.hmcc.contact.entity.ContactUser;
import com.hmcc.contact.service.ContactUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.ExcelUtilContact;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR on 2017/10/12.
 */
@Service
public class ContactUserServiceImpl implements ContactUserService {
    @Autowired
    private ContactUserDao contactUserDao;
    public List<ContactUser> DeleteExcelInfo(InputStream in, MultipartFile file)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getDeleteInfo(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        List<String> l1 = new ArrayList<String>();
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);
            List<Object> ob = listob.get(i);
            ContactUser contactUser = new ContactUser();
            if(ob.get(0)!=null){
               contactUserDao.deleteByPrimaryKey(String.valueOf(ob.get(0)));
            }
        }
        List<ContactUser> contactUsers = contactUserDao.selectAllSSims();
        return contactUsers;
    }
    public List<ContactUser> importExcelInfo(InputStream in, MultipartFile file)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getBankListByExcel(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);
            List<Object> ob = listob.get(i);
            ContactUser contactUser = new ContactUser();
            if(ob.get(0)!=null){
                contactUser.setUserid(String.valueOf(ob.get(0)));
            }
            if(ob.get(1)!=null){
                contactUser.setUsername(String.valueOf(ob.get(1)));
            }
            if(ob.get(2)!=null){
                contactUser.setUsergender(String.valueOf(ob.get(2)));
            }
            if(ob.get(3)!=null){
                contactUser.setOrgid(String.valueOf(ob.get(3)));
            }
            if(ob.get(4)!=null){
                contactUser.setUserduty(String.valueOf(ob.get(4)));
            }
            if(ob.get(5)!=null){
                contactUser.setUserphonenum(String.valueOf(ob.get(5)));
            }
            if(ob.get(6)!=null){
                contactUser.setIshidden(String.valueOf(ob.get(6)));
            }
            if(ob.get(7)!=null){
                contactUser.setUserposition(String.valueOf(ob.get(7)));
            }

//             contactUserDao.deleteByPrimaryKey(contactUser.getUserid());
             contactUserDao.insertSelective(contactUser);
        }
        List<ContactUser> contactUsers = contactUserDao.selectAllSSims();
        return contactUsers;
    }

}

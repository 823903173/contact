package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.mapper.ContactUserDao;
import com.hmcc.contact.entity.ContactUser;
import com.hmcc.contact.service.ContactUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.ExcelUtilContact;

import javax.ws.rs.GET;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(ob.get(0)!=null){
               contactUserDao.deleteByNum(String.valueOf(ob.get(5)));
            }
        }
        List<ContactUser> contactUsers = contactUserDao.selectAllSSims();
//        for (int i = 0; i < contactUsers.size();i++){
//            ContactUser contactUser = contactUsers.get(i);
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            contactUser.setCreateTime(simpleDateFormat.format(contactUser.getCreateTime()));;
//        }
        return contactUsers;
    }
    //判断用户是否存在
//    public ContactUser GetExistUser(int userId,String userName) {
//        ContactUser contactUser =  contactUserDao.selectExistUsers(userId,userName);
//        return contactUser;
//    }

    public List<ContactUser> importExcelInfo(InputStream in, MultipartFile file, String contactAdminOrgId, Integer contactAdminNum)
            throws Exception {
        List<List<Object>> listob = ExcelUtilContact.getBankListByExcel(in,file.getOriginalFilename());
        //for (int i = 1; i < listob.size()-1; i++) {
        List<ContactUser> contactUsers = new ArrayList<>();
        for (int i = 0; i < listob.size(); i++) {
            //List<Object> ob = listob.get(i+1);

            List<Object> ob = listob.get(i);
//            if(ob.get(0)!=null&&ob.get(1)!=null){
//                int userId=Integer.valueOf(ob.get(0).toString());
//                String userName = String.valueOf(ob.get(1));
//                if(GetExistUser(userId,userName) != null){
//
//                }
//


            ContactUser contactUser = new ContactUser();
            if(ob.get(0)!=null){
                String str1=ob.get(0).toString();
                String str2 = str1.substring(0,str1.length()-3);
                contactUser.setUserId(Integer.valueOf(str2));
            }
            if(ob.get(1)!=null){
                contactUser.setUserName(String.valueOf(ob.get(1)));
            }
            if(ob.get(2)!=null){
                contactUser.setUserGender(Integer.valueOf(ob.get(2).toString()));
            }
            if(1==1){
                contactUser.setGroupId(contactAdminOrgId);
            }
            if(ob.get(4)!=null){
                contactUser.setUserJob(String.valueOf(ob.get(4)));
            }
            if(ob.get(5)!=null){
                contactUser.setPhoneNum(Long.valueOf(ob.get(5).toString()));
            }
            if(ob.get(6)!=null){
                contactUser.setIsHidden(Integer.valueOf(ob.get(6).toString()));
            }
            if(ob.get(7)!=null){
                contactUser.setUserPosition(String.valueOf(ob.get(7)));
            }
            if(ob.get(8)!=null){
                contactUser.setUserStatus(Integer.valueOf(ob.get(8).toString()));
            }
            if(1==1){
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                contactUser.setCreateTime(timestamp);
            }
            if(1==1){
                contactUser.setCreateManagerId(contactAdminNum.toString());
            }
            if(1==1){
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                contactUser.setLatestReviseTime(timestamp);
            }
            if(ob.get(10)!=null){
                contactUser.setLatestReviseManagerId(contactAdminNum.toString());
            }
            if(ob.get(11)!=null){
                contactUser.setShowOrder(String.valueOf(ob.get(11)));
            }
            if(ob.get(12)!=null){
                contactUser.setExtendedField1(String.valueOf(ob.get(12)));
            }
            if(ob.get(13)!=null){
                contactUser.setExtendedField2(String.valueOf(ob.get(13)));
            }
            if(ob.get(14)!=null){
                contactUser.setExtendedField3(String.valueOf(ob.get(14)));
            }
            if(ob.get(15)!=null){
                contactUser.setExtendedField4(String.valueOf(ob.get(15)));
            }

             contactUserDao.deleteByNum(contactUser.getPhoneNum().toString());
             contactUserDao.insertSelective(contactUser);
             contactUsers.add(contactUser);
        }

        return contactUsers;
    }

}

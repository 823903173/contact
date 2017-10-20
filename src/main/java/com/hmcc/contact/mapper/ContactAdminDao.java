package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactOrg;

import java.util.List;

/**
 * Created by TR on 2017/10/17.
 */
public interface ContactAdminDao {
    int deleteAdminByPrimaryKey(String userid);

    int deleteAdminByContactNum(String contactNumber);

    int insertAdmins(ContactAdmin record);

    List<ContactAdmin> selectAllAdmins();

    ContactAdmin getAdmin(Long phoneNum);


}

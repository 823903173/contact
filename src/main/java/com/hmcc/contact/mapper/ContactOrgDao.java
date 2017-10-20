package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.ContactOrg;

import java.util.List;

/**
 * Created by TR on 2017/10/18.
 */
public interface ContactOrgDao {
    int deleteOrgByPrimaryKey(String id);

    int deleteOrgByParentId(String contactNumber);

    int insertOrgs(ContactOrg record);

    List<ContactOrg> selectAllOrgs();
}

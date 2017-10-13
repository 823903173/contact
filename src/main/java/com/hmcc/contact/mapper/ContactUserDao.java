package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.ContactUser;

import java.util.List;

/**
 * Created by TR on 2017/10/12.
 */
public interface ContactUserDao {
    int deleteByPrimaryKey(String userid);

    int insertSelective(ContactUser record);

    List<ContactUser> selectAllSSims();
}

package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.AddresslistUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  * 个人信息表 Mapper 接口
 * </p>
 *
 * @author CuiYong
 * @since 2017-09-27
 */
public interface AddresslistUserMapper extends BaseMapper<AddresslistUser> {

    @Select("queryOnesByDepartId")
    List<AddresslistUser> queryOnesByDepartId(String departId);

    @Select("queryOne")
    AddresslistUser queryOne(int id);

    @Select("searchByName")
    List<AddresslistUser> searchByName(String name);

    @Select("searchByPhoneNum")
    List<AddresslistUser> searchByPhoneNum(long phoneNum);

    @Select("loginByPhone")
    boolean loginByPhone(long phoneNum);

}
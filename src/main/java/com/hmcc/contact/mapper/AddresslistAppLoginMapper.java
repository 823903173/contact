package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.AddresslistAppLogin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  * APP登录日志表 Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-17
 */
public interface AddresslistAppLoginMapper extends BaseMapper<AddresslistAppLogin> {
    @Select("CheckUserPhoneNumber")
    boolean CheckUserPhoneNumber(long phoneNumber,String phoneImei);
}
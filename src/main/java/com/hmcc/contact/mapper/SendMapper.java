package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.Send;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
public interface SendMapper extends BaseMapper<Send> {

    @Select("queryPhoneNumAndVerifyCode")
    boolean queryPhoneNumAndVerifyCode(long phoneNumber, String verifyCode  );

}
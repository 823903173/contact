package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.AddresslistMessageSend;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  * 短信下发表 Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-13
 */
public interface AddresslistMessageSendMapper extends BaseMapper<AddresslistMessageSend> {
    @Select("queryPhoneNumAndVerifyCode")
    boolean queryPhoneNumAndVerifyCode(long phoneNumber, String verifyCode);
}
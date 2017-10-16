package com.hmcc.contact.service;

import com.hmcc.contact.entity.Send;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
public interface ISendService extends IService<Send> {

    boolean queryPhoneNumAndVerifyCode(long phoneNumber, String verifyCode);
}

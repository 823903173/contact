package com.hmcc.contact.service;

import com.hmcc.contact.entity.AddresslistAppLogin;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * APP登录日志表 服务类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-17
 */
public interface IAddresslistAppLoginService extends IService<AddresslistAppLogin> {
	boolean CheckUserPhoneNumber(long phoneNumber,String phoneImei);
}

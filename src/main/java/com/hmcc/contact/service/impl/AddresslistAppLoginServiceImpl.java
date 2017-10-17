package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.AddresslistAppLogin;
import com.hmcc.contact.mapper.AddresslistAppLoginMapper;
import com.hmcc.contact.service.IAddresslistAppLoginService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP登录日志表 服务实现类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-17
 */
@Service
public class AddresslistAppLoginServiceImpl extends ServiceImpl<AddresslistAppLoginMapper, AddresslistAppLogin> implements IAddresslistAppLoginService {
    @Override
    public boolean CheckUserPhoneNumber(long phoneNumber, String phoneImei) {
        return baseMapper.CheckUserPhoneNumber(phoneNumber,phoneImei);
    }
}

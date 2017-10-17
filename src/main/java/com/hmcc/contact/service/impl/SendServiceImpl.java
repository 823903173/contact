package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.Send;
import com.hmcc.contact.mapper.SendMapper;
import com.hmcc.contact.service.ISendService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
@Service
public class SendServiceImpl extends ServiceImpl<SendMapper, Send> implements ISendService {

    @Override
    public boolean queryPhoneNumAndVerifyCode(long phoneNumber,String verifyCode) {
        System.out.println(phoneNumber+"      service!!!!    "+verifyCode);

        return baseMapper.queryPhoneNumAndVerifyCode(phoneNumber,verifyCode);
    }
	
}

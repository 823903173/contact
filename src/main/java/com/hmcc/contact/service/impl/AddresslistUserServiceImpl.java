package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.AddresslistUser;
import com.hmcc.contact.mapper.AddresslistUserMapper;
import com.hmcc.contact.service.IAddresslistUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author CuiYong
 * @since 2017-09-27
 */
@Service
public class AddresslistUserServiceImpl extends ServiceImpl<AddresslistUserMapper, AddresslistUser> implements IAddresslistUserService {

        public List<AddresslistUser> getOnesByDepart(String departId)
        {
            return baseMapper.queryOnesByDepartId(departId);
        }

        public AddresslistUser getOneInfo(int id)
        {
            return baseMapper.queryOne(id);
        }
        public List<AddresslistUser> searchByName(String name)
        {
            System.out.println( baseMapper.searchByName(name));
            return baseMapper.searchByName(name);
        }
        public List<AddresslistUser> searchByPhoneNum(long phoneNum)
        {
            return baseMapper.searchByPhoneNum(phoneNum);
        }


        public boolean loginByPhone(long phoneNum)
        {
//            boolean a = baseMapper.loginByPhone(phoneNum);
            return baseMapper.loginByPhone(phoneNum);
        }
}

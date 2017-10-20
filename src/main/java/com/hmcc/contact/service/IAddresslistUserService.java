package com.hmcc.contact.service;

import com.hmcc.contact.entity.AddresslistUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 个人信息表 服务类
 * </p>
 *
 * @author CuiYong
 * @since 2017-09-27
 */
public interface IAddresslistUserService extends IService<AddresslistUser> {

     List<AddresslistUser> getOnesByDepart(int departId);
     AddresslistUser getOneInfo(int id);
     List<AddresslistUser> searchByName(String name);
     List<AddresslistUser> searchByPhoneNum(long phoneNum);
     int loginByPhone(long phoneNum);


}

package com.hmcc.contact.service;

import com.hmcc.contact.entity.Organization;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-19
 */
public interface IOrganizationService extends IService<Organization> {
    List<Organization> getIdByGroupId(String id);
}

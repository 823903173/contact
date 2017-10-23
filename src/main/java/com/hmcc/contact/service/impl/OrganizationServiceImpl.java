package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.Organization;
import com.hmcc.contact.mapper.OrganizationMapper;
import com.hmcc.contact.service.IOrganizationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-19
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {
	public List<Organization> getIdByGroupId(String id){
	    System.out.println("aaaaaaaaaaaaa"+id);
//	    id = id + ;
        return baseMapper.getIdByGroupId(id);
    }

    public List<Organization> getNameByGroupId(String groupId){
//        System.out.println("aaaaaaaaaaaaa"+groupId);
//	    id = id + ;
        return baseMapper.getNameByGroupId(groupId);
    }


}

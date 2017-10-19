package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.AddresslistUser;
import com.hmcc.contact.entity.Organization;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-19
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    @Select("getIdByGroupId")
    List<Organization> getIdByGroupId(String id);
}
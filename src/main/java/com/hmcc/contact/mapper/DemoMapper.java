package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.Demo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hmcc.contact.entity.Organization;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Yanghu
 * @since 2017-09-22
 */
public interface DemoMapper extends BaseMapper<Demo> {
    @Select("getModelNumber")
    List<Demo> getModelNumber();
}
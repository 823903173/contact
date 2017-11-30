package com.hmcc.contact.service;

import com.hmcc.contact.entity.Demo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yanghu
 * @since 2017-09-22
 */
public interface IDemoService extends IService<Demo> {
	List<Demo>  getModelNumber();
}

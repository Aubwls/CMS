package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Link;
import com.briup.bean.LinkExample;
import com.briup.bean.LinkExample.Criteria;
import com.briup.mapper.LinkMapper;
import com.briup.service.ILinkService;
import com.briup.utils.CustomerException;
import com.briup.utils.StatusCodeUtil;

/**
 * 操作链接的service功能类
 * @author 14151
 *
 */
@Service
public class ILinkServiceImpl implements ILinkService{
	
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public void saveOrUpdateLink(Link link) throws CustomerException {
		//判读参数是否为空
		if (link != null) {
			if (link.getId() == null)
				linkMapper.insert(link);
			else
				linkMapper.updateByPrimaryKey(link);
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
	}

	@Override
	public void deleteLinkById(Integer id) throws CustomerException {
		if (id != 0) {
			linkMapper.deleteByPrimaryKey(id);
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误");
		}
	}

	@Override
	public Link getOne(Integer id) throws CustomerException {
		if(id != 0 && id > 0) {
			Link link = linkMapper.selectByPrimaryKey(id);
			return link;
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误");
		}
	}

	@Override
	public List<Link> findAllLinks() throws CustomerException {
		try {
			return linkMapper.selectByExample(new LinkExample());
		} catch (Exception e) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查找错误");
		}
	}
	/**
	 * 如果name为空，那么显示所有数据，否则返回满足条件的数据。
	 */
	@Override
	public List<Link> findLinksByName(String name) throws CustomerException {
		name = name==null ? "" : name.trim();
		LinkExample example = new LinkExample();
		if ("".equals(name)) {
			return linkMapper.selectByExample(example);
		}else {
			Criteria criteria = example.createCriteria();
			criteria.andNameLike("%"+name+"%");
			return linkMapper.selectByExample(example);
		}
	}
}

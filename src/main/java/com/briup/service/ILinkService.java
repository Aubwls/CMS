package com.briup.service;

import java.util.List;

import com.briup.bean.Link;
import com.briup.utils.CustomerException;

/**
 * 关于链接的相关操作
 * @author 14151
 *
 */
public interface ILinkService {
	
	/**
	 * 保存链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link) throws CustomerException;
	
	/**
	 * @return 并且返回受影响的列数
	 * @throws CustomerException
	 */
	void deleteLinkById(Integer id) throws CustomerException;
	
	
	/**
	 * @param id 通过id来查找link
	 * @return
	 * @throws CustomerException
	 */
	Link getOne(Integer id) throws CustomerException; 
	
	/**
	 * 
	 * @return 数据库中所有的link
	 * @throws CustomerException
	 */
	List<Link> findAllLinks() throws CustomerException; 
	
	/**
	 * 
	 * @param name 通过模糊查询
	 * @return 返回一个列表
	 * @throws CustomerException
	 */
	List<Link> findLinksByName(String name) throws CustomerException; 
}

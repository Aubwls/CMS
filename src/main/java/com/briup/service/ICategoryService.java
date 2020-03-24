
package com.briup.service;

import java.util.List;

import com.briup.bean.Category;
import com.briup.bean.ex.CategoryEx;
import com.briup.utils.CustomerException;
/**
 * 栏目管理实现类 
 * @author 14151
 *
 */
public interface ICategoryService {
	/**
	 * 
	 * @param category 存一个category对象进去或者修改一个category
	 * @throws CustomerException
	 */
	void saveOrUpdateCategory(Category category) throws CustomerException;
	
	/**
	 * 
	 * @param id 需要删除的category的id
	 * @return 返回受影响的行数
	 * @throws CustomerException
	 */
	void deleteCategoryById(Integer id) throws CustomerException;
	
	/**
	 * 
	 * @param id 查询的category的id
	 * @return 一个category
	 * @throws CustomerException
	 */
	Category findCageoryById(Integer id) throws CustomerException;
	
	/**
	 * 
	 * @return 所有的category
	 * @throws CustomerException
	 */
	List<Category> findAllCategorys() throws CustomerException;
	/**
	 * 
	 * @return 所有的categoryEx
	 * @throws CustomerException
	 */
	List<CategoryEx> findAllCategoryExs() throws CustomerException;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws CustomerException
	 */
	CategoryEx findCateforyExByName(String name) throws CustomerException;
}

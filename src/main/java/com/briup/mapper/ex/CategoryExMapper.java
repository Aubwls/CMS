package com.briup.mapper.ex;

import java.util.List;

import com.briup.bean.ex.CategoryEx;

/**
 * 处理查询栏目及其包含的文章信息
 * @author 14151
 *
 */
public interface CategoryExMapper {
	/**
	 * 
	 * @return 所有栏目及其及级联的article
	 */
	List<CategoryEx> findAllCategoryExs();
	CategoryEx findCateforyExByName(String name);
}

package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.ArticleExample;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.bean.ex.CategoryEx;
import com.briup.mapper.ArticleMapper;
import com.briup.mapper.CategoryMapper;
import com.briup.mapper.ex.CategoryExMapper;
import com.briup.service.ICategoryService;
import com.briup.utils.CustomerException;
import com.briup.utils.StatusCodeUtil;

@Service
public class ICategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CategoryExMapper categoryExMapper;
	
	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if (category != null) {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andCodeEqualTo(category.getCode()).andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if (list.size() != 0 )
				throw new CustomerException(StatusCodeUtil.ERROR_PARA, "参数已存在");
			if (category.getId() == null)
				categoryMapper.insert(category);
			else {
				categoryMapper.updateByPrimaryKey(category);
			}
				
		}else{
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数为空)");
		}
	}

	@Override
	public void deleteCategoryById(Integer id) throws CustomerException {
		if (id > 0) {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andCategoryIdEqualTo(id);
			articleMapper.deleteByExample(example);
			categoryMapper.deleteByPrimaryKey(id);
		}else{
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数必须大于0)");
		}
	}

	@Override
	public Category findCageoryById(Integer id) throws CustomerException {
		if (id > 0) {
			Category category = categoryMapper.selectByPrimaryKey(id);
			return category;
		}else{
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数必须大于0)");
		}
	}

	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public List<CategoryEx> findAllCategoryExs() throws CustomerException {
		return categoryExMapper.findAllCategoryExs();
	}

	@Override
	public CategoryEx findCateforyExByName(String Name) throws CustomerException {
		return categoryExMapper.findCateforyExByName(Name);
	}

}

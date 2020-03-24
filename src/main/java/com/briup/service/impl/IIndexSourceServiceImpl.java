package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.bean.Link;
import com.briup.bean.ex.CategoryEx;
import com.briup.bean.ex.IndexSource;
import com.briup.mapper.ArticleMapper;
import com.briup.mapper.CategoryMapper;
import com.briup.service.IArticleService;
import com.briup.service.ICategoryService;
import com.briup.service.IIndexSourceService;
import com.briup.service.ILinkService;

@Service
public class IIndexSourceServiceImpl implements IIndexSourceService{
	
	@Autowired
	private ILinkService linkService;	
	@Autowired
	private ICategoryService categoryService;
	
	@Override
	public IndexSource findAll() {
		//获得所有的链接
		List<Link> links = linkService.findAllLinks();
		//获得所有的栏目并且级联article
		List<CategoryEx> categoryExs = categoryService.findAllCategoryExs();
		return new IndexSource(categoryExs, links);
	}

}

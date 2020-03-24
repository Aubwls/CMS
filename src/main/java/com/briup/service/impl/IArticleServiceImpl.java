package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.mapper.ArticleMapper;
import com.briup.mapper.CategoryMapper;
import com.briup.service.IArticleService;
import com.briup.utils.CustomerException;
import com.briup.utils.StatusCodeUtil;
@Service
public class IArticleServiceImpl implements IArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public void saveOrUpdateArticle(Article article) throws CustomerException {
		if (article != null) {
			if (article.getId() == null) {
				article.setClicktimes(0);
				article.setPublishdate(new Date());
				articleMapper.insert(article);
			}
			else {
				Article article2 = articleMapper.selectByPrimaryKey(article.getId());
				article.setClicktimes(article2.getClicktimes());
				article.setPublishdate(new Date());
				articleMapper.updateByPrimaryKey(article);
			}
				
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数为空)");
		}
	}

	@Override
	public void deleteArticleById(Integer id) throws CustomerException {
		if (id > 0) {
			articleMapper.deleteByPrimaryKey(id);
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数必须大于0)");
		}
	}

	@Override
	public Article findArticleById(Integer id) throws CustomerException {
		if (id > 0) {
			Article article = articleMapper.selectByPrimaryKey(id);
			return article;
		}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数必须大于0)");
		}
	}

	@Override
	public List<Article> findAllArticles() throws CustomerException {
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public List<Article> findArticleByTitlelike(String title) throws CustomerException {
		title = title == null ? "" : title;
		ArticleExample example = new ArticleExample();
		example.createCriteria().andTitleLike("%"+title+"%");
		return articleMapper.selectByExample(example);
	}

	@Override
	public List<Article> findArticleByClicktimes(Integer min, Integer max) throws CustomerException {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andClicktimesNotBetween(min, max);
		return articleMapper.selectByExample(example);
	}

	@Override
	public List<Article> findArtticleByCondition(String keyStr, String condition) throws CustomerException {
		keyStr = keyStr==null? "" : keyStr.trim();
		condition = condition==null? "" : condition.trim();
		ArticleExample example = new ArticleExample();
		CategoryExample example2 = new CategoryExample();
		if ("".equals(keyStr) && "".equals(condition)) {
			return articleMapper.selectByExample(example);
		}else if (!("".equals(keyStr)) && "".equals(condition)){
			example.createCriteria().andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
		}else if (!"".equals(condition) && "".equals(keyStr)) {
			example2.createCriteria().andNameEqualTo(condition);
			List<Category> list = categoryMapper.selectByExample(example2);
			example.createCriteria().andCategoryIdEqualTo(list.get(0).getId());
			if(list.size()>0) {
				return articleMapper.selectByExample(example);
			}
			else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数错误(参数为空)");
			}
		}else {
			example2.createCriteria().andNameEqualTo(condition);
			List<Category> list = categoryMapper.selectByExample(example2);
			example.createCriteria().
			andCategoryIdEqualTo(list.get(0).getCode()).andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
		}
	}

	@Override
	public void UpdateArticleCilck(Integer id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		article.setClicktimes(article.getClicktimes()+1);
		articleMapper.updateByPrimaryKey(article);
	}
}

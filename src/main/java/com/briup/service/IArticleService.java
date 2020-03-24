package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.utils.CustomerException;

/**
 * @author 14151
 *	关于文章的相关操作
 */
public interface IArticleService {
	
	/**
	 * 
	 * @param article 存一个article对象进去或者修改一个article
	 * @throws CustomerException
	 */
	void saveOrUpdateArticle(Article article) throws CustomerException;

	/**
	 * 
	 * @param id 需要删除的article的id
	 * @return 返回受影响的行数
	 * @throws CustomerException
	 */
	void deleteArticleById(Integer id) throws CustomerException;
	void UpdateArticleCilck(Integer id) throws CustomerException;
	/**
	 * 
	 * @param id 查询的article的id
	 * @return 一个article
	 * @throws CustomerException
	 */
	Article findArticleById(Integer id) throws CustomerException;
	
	/**
	 * 
	 * @return 所有的Article
	 * @throws CustomerException
	 */
	List<Article> findAllArticles() throws CustomerException;
	
	/**
	 * 
	 * @param name 
	 * @return
	 * @throws CustomerException
	 */
	List<Article> findArticleByTitlelike(String title) throws CustomerException;
	/**
	 * 
	 * @param min 最小点击量
	 * @param max 最大点击量
	 * @return 在这个区间的文章集合
	 * @throws CustomerException
	 */
	List<Article> findArticleByClicktimes(Integer min,Integer max) throws CustomerException;
	
	/**
	 * 
	 * @param keyStr 关键字
	 * @param condition
	 * @return
	 * @throws CustomerException
	 */
	List<Article> findArtticleByCondition(String keyStr,String condition) throws CustomerException;
	
}

package com.briup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.service.IArticleService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 与article相关的   和前端交互的web层
 * @author 14151
 *
 */
@RestController
@Api(description = "文章相关接口")
public class ArticleController {
	
	@Autowired 
	private IArticleService articleService;
	
	//插入操作用post
	@PostMapping("/addArticle")
	@ApiOperation("新增文章")
	public Message<String> addArticle(Article article) {
		try {
			articleService.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	//插入操作用post
	@PostMapping("/deleteArticle")
	@ApiOperation("删除文章")
	public Message<String> deleteArticle(Integer id) {
		try {
			articleService.deleteArticleById(id);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getArticleById")
	@ApiOperation("获得文章(id)")
	public Message<Article> getArticle(Integer id) {
		try {
			Article article = articleService.findArticleById(id);
			return MessageUtil.success(article);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getArticleByClicktimes")
	@ApiOperation("获得文章(点击量)")
	public Message<List<Article>> getArticleByClicktimes(Integer min,Integer max) {
		try {
			List<Article> list = articleService.findArticleByClicktimes(min, max);
			return MessageUtil.success(list);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getAllArticles")
	@ApiOperation("获得文章(All)")
	public Message<List<Article>> findAllArticles() {
		try {
			return MessageUtil.success(articleService.findAllArticles());
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getAllArticlesByTitle")
	@ApiOperation("获得文章(模糊查询title)")
	public Message<List<Article>> findArticlesByCondition(String keyStr,String condition) {
		try {
			return MessageUtil.success(articleService.findArtticleByCondition(keyStr, condition));
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	
	@PostMapping("/updateArticle")
	@ApiOperation("更改文章")
	public Message<String> updateArticle(Article article) {
		try {
			articleService.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/updateArticleClick")
	@ApiOperation("更改文章")
	public Message<Article> updateArticleClick(Integer id) {
		try {
			articleService.UpdateArticleCilck(id);
			return MessageUtil.success(articleService.findArticleById(id));
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
}

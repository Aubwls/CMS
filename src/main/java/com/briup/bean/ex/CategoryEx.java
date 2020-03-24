package com.briup.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.bean.Article;
/**
 * 每个栏目并且级联旗下的所以article
 * @author 14151
 *
 */
public class CategoryEx implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer code;
	
	private String name;
	
	private List<Article> articles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	public CategoryEx(Integer id, Integer code, String name, List<Article> articles) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.articles = articles;
	}

	
	public CategoryEx() {
		super();
	}
	
	
	
}

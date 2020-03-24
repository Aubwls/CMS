package com.briup.bean.ex;

import java.io.Serializable;
import java.util.List;

/**
 * 保存index页面需要的所有信息
 * @author 14151
 *
 */


import com.briup.bean.Link;
public class IndexSource implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<CategoryEx> CategoryExs;
	
	private List<Link> links;

	/**
	 * @param categoryExs
	 * @param links
	 */
	public IndexSource(List<CategoryEx> categoryExs, List<Link> links) {
		super();
		CategoryExs = categoryExs;
		this.links = links;
	}
	
	public IndexSource() {
		super();
	}
	
	public List<CategoryEx> getCategoryExs() {
		return CategoryExs;
	}

	public void setCategoryExs(List<CategoryEx> categoryExs) {
		CategoryExs = categoryExs;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
}

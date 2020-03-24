package com.briup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Category;
import com.briup.bean.ex.CategoryEx;
import com.briup.bean.ex.IndexSource;
import com.briup.service.ICategoryService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与Category相关的   和前端交互的web层
 * @author 14151
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	@Autowired 
	private ICategoryService categoryService;
	
	//插入操作用post
	@PostMapping("/addCategory")
	@ApiOperation("新增栏目")
	public Message<String> addCategoryr(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	//插入操作用post
	@PostMapping("/deleteCategory")
	@ApiOperation("删除栏目")
	public Message<String> deleteCategory(Integer id) {
		try {
			categoryService.deleteCategoryById(id);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getCategory")
	@ApiOperation("获得栏目")
	public Message<Category> getCategory(Integer id) {
		try {
			Category category = categoryService.findCageoryById(id);
			return MessageUtil.success(category);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/updateCategory")
	@ApiOperation("更改栏目")
	public Message<String> updateCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/getOne")
	@ApiOperation("获得需要的数据")
	public Message<CategoryEx> findOne(String name) {
		return MessageUtil.success(categoryService.findCateforyExByName(name));
	}
}

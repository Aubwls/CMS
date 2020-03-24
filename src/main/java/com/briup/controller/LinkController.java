package com.briup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Link;
import com.briup.service.ILinkService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与link相关的   和前端交互的web层
 * @author 14151
 *
 */
@RestController
@Api(description = "链接相关接口")
public class LinkController {
	
	@Autowired 
	private ILinkService linkService;
	
	//插入操作用post
	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> addLink(Link link) {
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	//插入操作用post
	@GetMapping("/deleteLink")
	@ApiOperation("删除链接")
	public Message<String> deleteLink(Integer id) {
		try {
			linkService.deleteLinkById(id);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/getLink")
	@ApiOperation("获得链接")
	public Message<Link> getLink(Integer id) {
		try {
			Link link = linkService.getOne(id);
			return MessageUtil.success(link);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("更改链接")
	public Message<String> updateLink(Link link) {
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/findAllLinks")
	@ApiOperation("查找所有链接")
	public Message<List<Link>> findAllLinks() {
		List<Link> list = linkService.findAllLinks();
		return MessageUtil.success(list);
	}
	
	@GetMapping("/findLinksByName")
	@ApiOperation("查找所有链接")
	public Message<List<Link>> findLinksByName(String name) {
		List<Link> list = linkService.findLinksByName(name);
		return MessageUtil.success(list);
	}
}

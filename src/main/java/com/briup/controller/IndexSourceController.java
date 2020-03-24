package com.briup.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.ex.CategoryEx;
import com.briup.bean.ex.IndexSource;
import com.briup.service.IIndexSourceService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "顾客相关接口")
public class IndexSourceController {
	
	@Autowired
	private IIndexSourceService iIndexSourceService;
	
	@GetMapping("/getIndex")
	@ApiOperation("获得index需要的数据")
	public Message<IndexSource> findAll() {
		IndexSource indexSource = iIndexSourceService.findAll();
		return MessageUtil.success(indexSource);
	}
	
}

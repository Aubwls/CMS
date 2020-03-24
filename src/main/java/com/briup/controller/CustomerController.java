package com.briup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 与Customer相关的   和前端交互的web层
 * @author 14151
 *
 */
@RestController
@Api(description = "顾客相关接口")
public class CustomerController {
	@Autowired 
	private ICustomerService customerService;
	
	@PostMapping("/addCustomer")
	@ApiOperation("新增顾客")
	public Message<String> addCustomer(Customer customer) {
		try {
			customerService.save(customer);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/checkCustomer")
	@ApiOperation("新增顾客")
	public Message<String> checkCustomer(String username,String password) {
		try {
			Customer customer2 = customerService.findByUsername(username);
			if (customer2 == null) {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "用户名错误");
			}else if (customer2 != null && customer2.getPassword().equals(password)){
				return MessageUtil.success("登陆成功");
			}else {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "密码错误");
			}
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_Login, "系统错误："+e.getMessage());
		}
	}
}

package com.briup.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;

public interface ICustomerService extends  JpaRepository<Customer, Integer>{
	Customer findByUsername(String username);
}

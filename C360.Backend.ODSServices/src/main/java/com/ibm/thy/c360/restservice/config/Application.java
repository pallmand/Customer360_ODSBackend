package com.ibm.thy.c360.restservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ibm.thy.c360.restservice.service.ods.impl.SearchCustomerServiceImpl;

@EnableTransactionManagement
@Configuration
public class Application {

	@Autowired
	DataSource dataSource;

	@Bean
	public SearchCustomerServiceImpl searchCustomerService() {
		return new SearchCustomerServiceImpl(dataSource);
	}

}
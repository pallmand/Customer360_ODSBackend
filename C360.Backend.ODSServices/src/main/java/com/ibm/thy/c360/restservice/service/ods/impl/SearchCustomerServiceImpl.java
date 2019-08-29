package com.ibm.thy.c360.restservice.service.ods.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.thy.c360.restservice.domain.common.Cons;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.Customer;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerResponse;
import com.ibm.thy.c360.restservice.jdbc.NamedParameterJdbcTemplateWithLogging;
import com.ibm.thy.c360.restservice.service.ods.SearchCustomerService;
import com.ibm.thy.graylog.GrayLogger;
import com.ibm.thy.graylog.LogAttributeHolder;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class SearchCustomerServiceImpl implements SearchCustomerService {

	private static final Logger logger = GrayLogger.getLogger("log." + SearchCustomerServiceImpl.class.getName());

	private NamedParameterJdbcTemplateWithLogging namedParameterJdbcTemplateWithLogging;

	public SearchCustomerServiceImpl(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.setQueryTimeout(Cons.JDBCTIMEOUT);
		this.namedParameterJdbcTemplateWithLogging = new NamedParameterJdbcTemplateWithLogging(template);
	}

	@Override
	public SearchCustomerResponse getSearchCustomer(LogAttributeHolder lah, SearchCustomerRequest searchCustomerRequest) {
		SearchCustomerResponse customerResponse = new SearchCustomerResponse();
		customerResponse.setClientTID("qwe123");
		
		List<Customer> customers = new ArrayList<>();
		
		Customer c = new Customer();
		c.setId(123);
		c.setName("faruk");
		c.setSurname("onder");
		
		customers.add(c);
		customerResponse.setCustomers(customers);

		// TODO make the jdbc call thru either NamedParameterJdbcTemplateWithLogging or
		// JdbcTemplateWithLogger and reply back with response type

		return customerResponse;
	}

}

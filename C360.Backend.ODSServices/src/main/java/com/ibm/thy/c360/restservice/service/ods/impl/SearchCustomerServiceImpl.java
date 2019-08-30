package com.ibm.thy.c360.restservice.service.ods.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.thy.c360.restservice.domain.common.Cons;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.Customer;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerResponse;
import com.ibm.thy.c360.restservice.jdbc.NamedParameterJdbcTemplateWithLogging;
import com.ibm.thy.c360.restservice.service.ods.SearchCustomerService;
import com.ibm.thy.c360.restservice.domain.common.ODSQueries;

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
		String selectByCondition =null;
		
		
		//selecting ods query by checking input of searchCustomer service
		
		SqlParameterSource nameParameters = null;
		
		if(searchCustomerRequest.getName() !=null && searchCustomerRequest.getSurname()!= null && searchCustomerRequest.getPassportNumber()!= null)
		{
			selectByCondition= ODSQueries.SearchCustomerByNameSurnamePassport;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getName()).
				addValue("surname", searchCustomerRequest.getSurname()).
				addValue("passport", searchCustomerRequest.getPassportNumber());
		}
		else if(searchCustomerRequest.getName() !=null && searchCustomerRequest.getSurname()!= null && searchCustomerRequest.getTckn()!= null)
			{
			selectByCondition= ODSQueries.SearchCustomerByNameSurnameTCKN;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getName()).
					addValue("surname", searchCustomerRequest.getSurname()).
					addValue("passport", searchCustomerRequest.getTckn());
			}
		else if(searchCustomerRequest.getName() !=null && searchCustomerRequest.getSurname()!= null && searchCustomerRequest.getEmail()!= null)
			{
			selectByCondition= ODSQueries.SearchCustomerByNameSurnameEmail;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getName()).
					addValue("surname", searchCustomerRequest.getSurname()).
					addValue("passport", searchCustomerRequest.getEmail());
			}
		else if(searchCustomerRequest.getName() !=null && searchCustomerRequest.getSurname()!= null && searchCustomerRequest.getTelephoneNumber()!= null)
			{
			selectByCondition= ODSQueries.SearchCustomerByNameSurnameTelephone;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getName()).
					addValue("surname", searchCustomerRequest.getSurname()).
					addValue("passport", searchCustomerRequest.getTelephoneNumber());
			}
		else if(searchCustomerRequest.getTccNumber()!= null)
			{
			selectByCondition= ODSQueries.SearchCustomerByTCCNumber;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getTccNumber());
			}
		else if(searchCustomerRequest.getTkNumber()!= null)
			{
			selectByCondition= ODSQueries.SearchCustomerByTKNumber;
			nameParameters = new MapSqlParameterSource("name", searchCustomerRequest.getTkNumber());
					
			}
		else
			selectByCondition= "pallavi";
		
		
		
		/*
		
		lah.setPurpose("count records for for the combination of name surname and passport");
		int count = this.namedParameterJdbcTemplateWithLogging.queryForObject(lah,selectByNameSurnamePassport , nameParameters, Integer.class);
		
		customers = this.namedParameterJdbcTemplateWithLogging.query(lah,selectByNameSurnamePassport , nameParameters, new SearchCustomerTR());
		
		customerResponse.setCustomers(customers);
		  */
				
		c.setSurname("Mandal"); c.setEmail("emailtest"); c.setId(123); c.setMnsNumber("MnS123"); c.setName(selectByCondition);c.setPassportNumber("pass123");c.setTckn("tckn123");c.setTkNumber("tk123");
		customers.add(c);
		customerResponse.setCustomers(customers);
		
		return customerResponse;
	}
	
	private static final class SearchCustomerTR implements RowMapper<Customer>{
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer= new Customer();
			customer.setName("CI.SECTORID");
			return customer;
		}
	}

}

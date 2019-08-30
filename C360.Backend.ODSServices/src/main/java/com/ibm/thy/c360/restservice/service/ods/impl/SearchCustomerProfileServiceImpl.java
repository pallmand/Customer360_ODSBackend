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
import com.ibm.thy.c360.restservice.domain.common.ODSQueries;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.CustomerProfile;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.SearchCustomerProfileRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.SearchCustomerProfileResponse;
import com.ibm.thy.c360.restservice.jdbc.NamedParameterJdbcTemplateWithLogging;
import com.ibm.thy.c360.restservice.service.ods.SearchCustomerProfileService;
import com.ibm.thy.graylog.GrayLogger;
import com.ibm.thy.graylog.LogAttributeHolder;

@Transactional(readOnly= true, propagation=Propagation.REQUIRED)
public class SearchCustomerProfileServiceImpl implements SearchCustomerProfileService{
	private static final Logger logger = GrayLogger.getLogger("log." + SearchCustomerServiceImpl.class.getName());

	private NamedParameterJdbcTemplateWithLogging namedParameterJdbcTemplateWithLogging;

	public SearchCustomerProfileServiceImpl(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.setQueryTimeout(Cons.JDBCTIMEOUT);
		this.namedParameterJdbcTemplateWithLogging = new NamedParameterJdbcTemplateWithLogging(template);
	}
	
	@Override
	public SearchCustomerProfileResponse getCustomerProfile(LogAttributeHolder lah, SearchCustomerProfileRequest searchCustomerProfileRequest) {
	  SearchCustomerProfileResponse searchCustomerProfileResponse = new SearchCustomerProfileResponse();
	  searchCustomerProfileResponse.setClientTID("123");
	  
	  List<CustomerProfile> customerProfileList = new ArrayList<>();
	  
	  CustomerProfile customerProfile= new CustomerProfile();
	  
	  SqlParameterSource nameParameters = null;
	  
	  String selectODSQuery= ODSQueries.SearchCustomerProfile;	  
	  
	  nameParameters = new MapSqlParameterSource("name", searchCustomerProfileRequest.getName()).
				addValue("surname",searchCustomerProfileRequest.getSurname()).
				addValue("TKNumber", searchCustomerProfileRequest.getTKNumber());
	  
	  //query
	  
	  customerProfile.setAddress("address"); customerProfile.setBehaviorSegmentationInfo("test"); customerProfile.setChurnRate("test"); customerProfile.setDoBoB("test");
	  customerProfile.setEmailAddress("test");  customerProfile.setFlightBlacklist("test");  customerProfile.setGender("test");
	  customerProfile.setMnSBlacklist("yes");  customerProfile.setMnSTierInformation("test");  customerProfile.setName("pallavi");
	  customerProfile.setNationality("Indian");  customerProfile.setProfession("eng.");  customerProfile.setSurname("mandal");
	  customerProfile.setTelephoneNumber("123");  customerProfile.setTKNumber("unknown");  customerProfile.setTotalAmountofBonusMiles("0");
	  customerProfile.setTotalAmountofStatusMiles("0");  customerProfile.setValueSegmentationInfo("baapre"); customerProfile.setVIP_CIPTag("Nope");
	  
	  customerProfileList.add(customerProfile);
	  searchCustomerProfileResponse.setCustomerProfile(customerProfileList);
	  return searchCustomerProfileResponse;
	  
	  
	}
	
	private static final class SearchCustomerProfileTR implements RowMapper<CustomerProfile>{
		public CustomerProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerProfile customerProfile= new CustomerProfile();
			customerProfile.setName("CI.ODS_Name");
			return customerProfile;
		}
	}
	

	

}

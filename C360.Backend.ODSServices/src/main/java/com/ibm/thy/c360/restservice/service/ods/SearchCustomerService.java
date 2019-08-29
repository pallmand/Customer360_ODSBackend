package com.ibm.thy.c360.restservice.service.ods;

import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerResponse;
import com.ibm.thy.graylog.LogAttributeHolder;

public interface SearchCustomerService {

	public SearchCustomerResponse getSearchCustomer(LogAttributeHolder lah, SearchCustomerRequest searchCustomerRequest);

}

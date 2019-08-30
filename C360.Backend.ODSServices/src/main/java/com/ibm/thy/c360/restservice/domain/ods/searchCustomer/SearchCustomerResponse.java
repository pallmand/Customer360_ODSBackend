package com.ibm.thy.c360.restservice.domain.ods.searchCustomer;
import java.util.ArrayList;
import java.util.List;

import com.ibm.thy.c360.restservice.domain.common.BaseResponse;

public class SearchCustomerResponse extends BaseResponse {
	
	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}

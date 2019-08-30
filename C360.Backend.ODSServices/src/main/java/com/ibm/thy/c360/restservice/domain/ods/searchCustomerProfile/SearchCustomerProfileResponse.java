package com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile;

import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.CustomerProfile;

import java.util.ArrayList;
import java.util.List;

import com.ibm.thy.c360.restservice.domain.common.BaseResponse;

public class SearchCustomerProfileResponse extends BaseResponse{

	private List<CustomerProfile> customerProfile = new ArrayList();
	
	public List<CustomerProfile> getCustomerProfile(){
		return customerProfile;
		
	}
	
	public void setCustomerProfile(List<CustomerProfile> customerProfile ) {
		this.customerProfile = customerProfile;
	}
	
	
}

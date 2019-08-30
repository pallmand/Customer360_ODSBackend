package com.ibm.thy.c360.restservice.service.ods;

import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.SearchCustomerProfileRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomerProfile.SearchCustomerProfileResponse;
import com.ibm.thy.graylog.LogAttributeHolder;

public interface SearchCustomerProfileService {

	public SearchCustomerProfileResponse getCustomerProfile(LogAttributeHolder lah, SearchCustomerProfileRequest searchCustomerProfileRequest );
		
	}


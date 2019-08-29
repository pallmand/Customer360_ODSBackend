package com.ibm.thy.c360.restservice.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.thy.c360.restservice.domain.common.Cons;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerRequest;
import com.ibm.thy.c360.restservice.domain.ods.searchCustomer.SearchCustomerResponse;
import com.ibm.thy.c360.restservice.service.ods.SearchCustomerService;
import com.ibm.thy.c360.restservice.util.ObjectToJson;
import com.ibm.thy.c360.restservice.util.Stopwatch;
import com.ibm.thy.graylog.GrayLogger;
import com.ibm.thy.graylog.LogAttributeHolder;

@RestController
@RequestMapping("/api/c360/services/ods")
public class C360ServicesRestControllerODS {

	@Autowired
	private SearchCustomerService searchCustomerService;

	private static final Logger logger = GrayLogger.getLogger("log." + C360ServicesRestControllerODS.class.getName());

	@RequestMapping(value = "/searchCustomer", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ResponseEntity<?> searchCustomer(@RequestHeader("clientTID") String clientTID,
			@RequestBody SearchCustomerRequest searchCustomerRequest) {

		Stopwatch sw = new Stopwatch();

		LogAttributeHolder lah = new LogAttributeHolder(clientTID, "UnicaMobileGateway", "getInterestList");

		if (logger.isDebugEnabled()) {

			lah.setAction(Cons.REQ);
			lah.setPurpose(lah.getInterfase() + " " + lah.getOperation() + " request");
			lah.setPayload("clientTID : " + clientTID + " SearchParam1 : " + searchCustomerRequest.getSearchParam1() + " SearchParam2 : " + searchCustomerRequest.getSearchParam2());
			lah.setElapsedTime(sw.elapsedTimeMiliSecondString());

			GrayLogger.logPre(lah);
			logger.debug(lah.getPurpose());
			GrayLogger.logPurgeParams();
		}

		SearchCustomerResponse searchCustomerResponse = new SearchCustomerResponse();
		searchCustomerResponse.setClientTID(clientTID);
		try {
			searchCustomerResponse = searchCustomerService.getSearchCustomer(lah, searchCustomerRequest);
			searchCustomerResponse.setResult(Cons.SUCCESS);

			if (logger.isDebugEnabled()) {

				lah.setAction(Cons.RES);
				lah.setPurpose(lah.getInterfase() + " " + lah.getOperation() + " response");
				lah.setPayload(ObjectToJson.doIt(searchCustomerResponse));
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());

				GrayLogger.logPre(lah);
				logger.debug(lah.getPurpose());
				GrayLogger.logPurgeParams();

			}

			return new ResponseEntity<>(searchCustomerResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			searchCustomerResponse.setResult(Cons.FAIL_0);
			searchCustomerResponse.setResultMessage(e.getMessage());

			lah.setAction(Cons.EXC);
			lah.setPurpose(lah.getInterfase() + " " + lah.getOperation() + " exception");
			lah.setPayload(ObjectToJson.doIt(searchCustomerResponse));
			lah.setElapsedTime(sw.elapsedTimeMiliSecondString());

			GrayLogger.logPre(lah);
			logger.error(lah.getPurpose(), e);
			GrayLogger.logPurgeParams();

			return new ResponseEntity<>(searchCustomerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
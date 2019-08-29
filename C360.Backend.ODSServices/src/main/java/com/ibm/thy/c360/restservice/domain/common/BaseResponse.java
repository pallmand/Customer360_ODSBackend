package com.ibm.thy.c360.restservice.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {
	private String result;
	private String resultMessage;
	private String clientTID;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getClientTID() {
		return clientTID;
	}

	public void setClientTID(String clientTID) {
		this.clientTID = clientTID;
	}


}
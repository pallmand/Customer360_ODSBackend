package com.ibm.thy.c360.restservice.util;

import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.thy.graylog.GrayLogger;

public class ObjectToJson {
	
	private static final Logger logger = GrayLogger.getLogger("log." + ObjectToJson.class.getName());
	
	static private ObjectMapper objectMapper = new ObjectMapper();
	
	static public String doIt(Object obj) {

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
        	logger.error("failed conversion: object to Json", e);
        	return "";
        }
    }

}

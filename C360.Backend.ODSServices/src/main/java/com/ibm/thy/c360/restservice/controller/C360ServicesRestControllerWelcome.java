package com.ibm.thy.c360.restservice.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.thy.graylog.GrayLogger;

@RestController
public class C360ServicesRestControllerWelcome {

	private static final Logger logger = GrayLogger.getLogger("log." + C360ServicesRestControllerWelcome.class.getName());

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String welcome() {
		return "<a href=\"swagger-ui.html\">UnicaMobileGateway rest interfaces pls go swagger-UI for operations <a/>";
	}

}
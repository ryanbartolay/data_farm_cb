package com.ryan.service.security;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class ServiceLoggerFactory implements LoggerFactory {

	/**
		     The constructor should be public as it will be called by
		     configurators in different packages.  */
	public ServiceLoggerFactory() {
	}

	public Logger makeNewLoggerInstance(String name) {
		return new ServiceLogger(name);
	}
}

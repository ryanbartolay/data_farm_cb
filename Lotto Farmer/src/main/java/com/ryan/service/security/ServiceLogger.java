package com.ryan.service.security;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ServiceLogger extends Logger {

	  // It's usually a good idea to add a dot suffix to the fully
	  // qualified class name. This makes caller localization to work
	  // properly even from classes that have almost the same fully
	  // qualified class name as MyLogger, e.g. MyLoggerTest.
	  static String FQCN = ServiceLogger.class.getName() + ".";

	  // It's enough to instantiate a factory once and for all.
	  private static ServiceLoggerFactory myFactory = new ServiceLoggerFactory();

	  /**
	     Just calls the parent constuctor.
	   */
	  public ServiceLogger(String name) {
	    super(name);
	  }

	  /**
	     Overrides the standard debug method by appending " world" at the
	     end of each message.  */
	  public 
	  void debug(Object message) {
	    super.log(FQCN, Level.DEBUG, message + " world.", null);    
	  }

	  /**
	     This method overrides {@link Logger#getLogger} by supplying
	     its own factory type as a parameter.
	  */
	  public static Logger getLogger(String name) {
	    return Logger.getLogger(name, myFactory); 
	  }

	  public void trace(Object message) {
	    super.log(FQCN, Level.TRACE, message, null); 
	  }
	
}

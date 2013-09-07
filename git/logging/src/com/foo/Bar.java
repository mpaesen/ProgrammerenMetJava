package com.foo;

import org.apache.log4j.Logger;

public class Bar {
	static Logger logger = Logger.getLogger(Bar.class);

	public void doIt() {
		if (logger.isDebugEnabled()) {
			logger.debug("Did it again!");
		}
	}
}
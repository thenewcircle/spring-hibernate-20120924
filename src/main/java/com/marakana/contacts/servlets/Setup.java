package com.marakana.contacts.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// instantiate an AddressRepository
		// init
		// go nuts!!
	}

}

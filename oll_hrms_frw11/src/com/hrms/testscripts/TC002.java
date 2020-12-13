package com.hrms.testscripts;

import com.hrms.lib.General;

//import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

public class TC002 {

	@Test
	public void tc002() throws Exception
	{
		//DOMConfigurator.configure("log4j.xml");
		General general=new General();
		general.openApplication();
		general.login();
		general.addEmployee();
		general.deleteEmployee();
		general.logout();
		general.closeApplication();
		
	}

}
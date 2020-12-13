package com.hrms.testscripts;

import com.hrms.lib.General;

//import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

public class TC001 {

	@Test
	public void tc001() throws Exception
	{
		// TODO Auto-generated method stub
		//DOMConfigurator.configure("log4j.xml");
		General general=new General();
		general.openApplication();
		general.login();
		general.logout();
		general.closeApplication();
		
	}

}

package org.test.testcases;

import org.test.base.CreateDriver;
import org.testng.annotations.Test;


public class Test_001 extends CreateDriver {
	
	@Test
	public void TC_01(){
		
		
		login.enterUserName("Test");
		login.enterPassword("test123");
		System.out.println("Test1");
	}

}

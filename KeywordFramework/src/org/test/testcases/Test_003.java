package org.test.testcases;

import org.test.base.CreateDriver;
import org.testng.annotations.Test;

public class Test_003 extends CreateDriver {
	
@Test	
public void TC_03(){
		
		
		login.enterUserName("Test");
		login.enterPassword("test123");
		System.out.println("Test03");
	}
}
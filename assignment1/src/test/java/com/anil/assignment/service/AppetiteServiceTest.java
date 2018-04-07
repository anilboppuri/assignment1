package com.anil.assignment.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

public class AppetiteServiceTest extends AppetiteTest {
	
	@Autowired
	private AppetiteService appetiteService;
	
     @Test
	public void testMinApptiteValue(){
		 
    	 int  result  =  appetiteService.optimizer(261);
    	 Assert.assertEquals(558,result);
		
	}
     
  @Test
     public void testInvalidMaxAppetiteValue(){
    	 
    	 int result = appetiteService.optimizer(99506);
    	 Assert.assertEquals(883,result);
     }
  
     
    @Test
     public void testComputeApptiteValueKeyMatches(){
    	 
    	  	int result =  appetiteService.optimizer(44304);
    	  	 Assert.assertTrue(result >=7  && result <=982);
     }
    
    @Test
    public void testComputeApptetieValueKeyNotMatch(){
    	
     	int result =  appetiteService.optimizer(9999);
	  	 Assert.assertTrue(result >=7  && result <=982);
    }

}

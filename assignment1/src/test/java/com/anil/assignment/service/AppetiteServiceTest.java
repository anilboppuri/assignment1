package com.anil.assignment.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

public class AppetiteServiceTest extends AppetiteTest {
	
	@Autowired
	private AppetiteService appetiteService;
	
  
     
    @Test
    public void testOptimizer(){
    	
     	int result =  appetiteService.optimizer(30);
     	System.out.println(result);
        Assert.assertTrue(result > 0);
    }

}

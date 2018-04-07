package com.anil.assignment.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
 *  This abstract class is create to be super class for all the 
 *  service test classes which may be created in this project,
 *  so that we need not annotate all service test classes.
 *  Its a one time configuration 
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AppetiteTest {

}

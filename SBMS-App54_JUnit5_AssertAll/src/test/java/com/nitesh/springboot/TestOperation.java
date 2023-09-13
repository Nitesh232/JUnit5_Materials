package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOperation {
	
	
	static Logger logger = LoggerFactory.getLogger(TestOperation.class);
	
	private static Operation op;
	
	private static int count = 0;

	
	
	@BeforeEach
	public void beforeEach() {
		
		op = new Operation();
		
		count++;
		
		logger.info("Executing before each method.... "+count+" times");
		
	}
	
	@AfterEach
	public void afterEach() {
		
		op = new Operation();
		
		count--;
		
		logger.info("Executing after each method.... "+count+" times");
		
	}
	
	
	// Note:- Adding more than one test case in single test method will not execute all test case,
	// it will only execute the first test case.
	// As in below we have four test case but only execute the first test case i.e. assertEquals(a+a, op.add(a, a));
	
	
	
	@DisplayName("TestFromValueSource")
	@Test
	void testValueSource1() {
		logger.info("Executing test case from Value Source.... with value of a :: ");
		
		assertAll(
				
				() -> assertEquals(25, op.add(10, 15)),
				() -> assertEquals(25, op.mul(5, 5)),
				() -> assertEquals(2, op.devide(10, 5)),
				() -> assertEquals(0, op.sub(10, 10))
				
		);
		
	}
	
	
}

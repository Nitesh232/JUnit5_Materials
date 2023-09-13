package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOperation{
	

	
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
		
	
	@Nested
	@DisplayName("RepeatedTestWithOutDisplayName")
	class testValueSource{
		
		
		@RepeatedTest(5)
		void add() {
			
			logger.info("Executing test case for addition from Value Source.... ");
			assertEquals(15+5, op.add(15, 5));
			
		}
		
		
		@RepeatedTest(5)
		void mul() {
			
			logger.info("Executing test case for multiplication from Value Source.... ");
			assertEquals(5*5, op.mul(5, 5));
			
		}
		
		
		
	}
	
	
	
	@Nested
	@DisplayName("RepeatedTestWithDisplayName")
	class testMethodSource{
		
		
		@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
		void add() {
			
			logger.info("Executing test case for addition from Method Source....");
			assertEquals(5+5, op.add(5, 5));
			
		}
		
		
		@RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
		void mul() {
			
			logger.info("Executing test case for multiplication from Method Source.... ");
			assertEquals(5*5, op.mul(5, 5));
			
		}
		
		@RepeatedTest(value = 5, name = "Custom Name :: {currentRepetition}/{totalRepetitions}")
		void divide() {
			
			logger.info("Executing test case for division from Method Source.... ");
			assertEquals(1, op.devide(5, 5));
			
		}
		
		
		
		
	}

	
}

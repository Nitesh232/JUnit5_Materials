package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOperation {
	
	
	static Logger logger = LoggerFactory.getLogger(TestOperation.class);
	
	private static Operation op;
	
	private static int count = 0;

	@BeforeAll
	public static void beforeAll() {
		logger.info("Executing before all method....");
	}
	
	
	@AfterAll
	public static void afterAll() {
		logger.info("Executing after all method....");
	}
	
	
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
	
	@Test
	void testAdd() {
		logger.info("Executing test case for addition....");
		assertEquals(20, op.add(5, 15));
	}
	
	@Test
	void testmul() {
		logger.info("Executing test case for multiplication....");
		assertEquals(75, op.mul(5, 15));
	}
	
	@Test
	void testDevide() {
		logger.info("Executing test case for devision....");
		assertEquals(2, op.devide(10, 5));
	}
	
	@Test
	void testASub() {
		logger.info("Executing test case for subtraction....");
		assertEquals(35, op.sub(50, 15));
	}
	
}

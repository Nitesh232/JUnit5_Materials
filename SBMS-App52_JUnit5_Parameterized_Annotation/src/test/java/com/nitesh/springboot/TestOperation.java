package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 20, 25, 30})
	void testValueSource(int a) {
		logger.info("Executing test case from Value Source.... with value of a :: "+a);
		assertEquals(a+a, op.add(a, a));
		assertEquals(a*a, op.mul(a, a));
		assertEquals(1, op.devide(a, a));
		assertEquals(0, op.sub(a, a));
	}
	
	
	
	@DisplayName("TestFromMethodSource")
	@ParameterizedTest
	@MethodSource("intProvider")
	void testMethodSource(int a) {
		logger.info("Executing test case from Method Source.... with value of a :: "+a);
		assertEquals(a+a, op.add(a, a));
		assertEquals(a*a, op.mul(a, a));
		assertEquals(1, op.devide(a, a));
		assertEquals(0, op.sub(a, a));
		
	}
	
	static Stream<Integer> intProvider() {
	    return Stream.of(10, 15, 20, 25, 30);
	}
	
	
	@DisplayName("TestFromCSVSource")
	@ParameterizedTest
	@CsvSource({
	    "10, 15",
	    "20, 25",
	    "30, 35",
	    "40, 45"
	})
	void testCsvSource(int a, int b) {
		logger.info("Executing test case From CSV Source.... with value of a :: "+a+" and value of b ::"+b);
		assertEquals(a+b, op.add(a, b));
		assertEquals(a*b, op.mul(a, b));
		assertEquals(a/b, op.devide(a, b));
		assertEquals(a-b, op.sub(a, b));
		
	}
	
	
	@DisplayName("TestFromCSVFileSource")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void testCsvFileSource(int a) {
		logger.info("Executing test case from CSV File Source.... with value of a :: "+a);
		assertEquals(a+a, op.add(a, a));
		assertEquals(a*a, op.mul(a, a));
		assertEquals(1, op.devide(a, a));
		assertEquals(0, op.sub(a, a));
		
	}
	
	
	@DisplayName("TestFromArgumentsSource")
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testArgumentsSource(int a) {
		logger.info("Executing test case from Argument Source.... with value of a :: "+a);
		assertEquals(a+a, op.add(a, a));
		assertEquals(a*a, op.mul(a, a));
		assertEquals(1, op.devide(a, a));
		assertEquals(0, op.sub(a, a));
		
	}
	
}

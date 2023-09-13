package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
	@DisplayName("TestFromValueSource")
	class testValueSource{
		
		
		@DisplayName("When Adding two numbers")
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 20, 25, 30})
		void add(int a) {
			
			logger.info("Executing test case for addition from Value Source.... with value of a :: "+a);
			assertEquals(a+a, op.add(a, a));
			
		}
		
		
		@DisplayName("When multiply two numbers")
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 20, 25, 30})
		void mul(int a) {
			
			logger.info("Executing test case for multiplication from Value Source.... with value of a :: "+a);
			assertEquals(a*a, op.mul(a, a));
			
		}
		
		@DisplayName("When dividing two numbers")
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 20, 25, 30})
		void divide(int a) {
			
			logger.info("Executing test case for division from Value Source.... with value of a :: "+a);
			assertEquals(1, op.devide(a, a));
			
		}
		
		
		@DisplayName("When subtracting two numbers")
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 20, 25, 30})
		void sub(int a) {
			
			logger.info("Executing test case for subtraction from Value Source.... with value of a :: "+a);
			assertEquals(0, op.sub(a, a));
			
		}
		
		
		
	}
	
	
	
	@Nested
	@DisplayName("TestFromMethodSource")
	class testMethodSource{
		
		
		@DisplayName("When Adding two numbers")
		@ParameterizedTest
		@MethodSource("intProvider")
		void add(int a) {
			
			logger.info("Executing test case for addition from Method Source.... with value of a :: "+a);
			assertEquals(a+a, op.add(a, a));
			
		}
		
		
		@DisplayName("When multiply two numbers")
		@ParameterizedTest
		@MethodSource("intProvider")
		void mul(int a) {
			
			logger.info("Executing test case for multiplication from Method Source.... with value of a :: "+a);
			assertEquals(a*a, op.mul(a, a));
			
		}
		
		@DisplayName("When dividing two numbers")
		@ParameterizedTest
		@MethodSource("intProvider")
		void divide(int a) {
			
			logger.info("Executing test case for division from Method Source.... with value of a :: "+a);
			assertEquals(1, op.devide(a, a));
			
		}
		
		
		@DisplayName("When subtracting two numbers")
		@ParameterizedTest
		@MethodSource("intProvider")
		void sub(int a) {
			
			logger.info("Executing test case for subtraction from Method Source.... with value of a :: "+a);
			assertEquals(0, op.sub(a, a));
			
		}
		
		static Stream<Integer> intProvider() {
		    return Stream.of(10, 15, 20, 25, 30);
		}
		
		
		
	}
	
	

	@Nested
	@DisplayName("TestFromCSVSource")
	class testCsvSource{
		
		
		@DisplayName("When Adding two numbers")
		@ParameterizedTest
		@CsvSource({
		    "10, 15",
		    "20, 25",
		    "30, 35",
		    "40, 45"
		})
		void add(int a, int b) {
			
			logger.info("Executing test case for addition from CSV Source.... with value of a :: "+a+" and value of b ::"+b);
			assertEquals(a+b, op.add(a, b));
			
			
		}
		
		
		@DisplayName("When multiply two numbers")
		@ParameterizedTest
		@CsvSource({
		    "10, 15",
		    "20, 25",
		    "30, 35",
		    "40, 45"
		})
		void mul(int a, int b) {
			
			logger.info("Executing test case for multiplication from CSV Source.... with value of a :: "+a+" and value of b ::"+b);
			assertEquals(a*b, op.mul(a, b));
			
			
		}
		
		@DisplayName("When dividing two numbers")
		@ParameterizedTest
		@CsvSource({
		    "10, 15",
		    "20, 25",
		    "30, 35",
		    "40, 45"
		})
		void divide(int a, int b) {
			
			logger.info("Executing test case for division from CSV Source.... with value of a :: "+a+" and value of b ::"+b);
			assertEquals(a/b, op.devide(a, b));
			
			
		}
		
		
		@DisplayName("When subtracting two numbers")
		@ParameterizedTest
		@CsvSource({
		    "10, 15",
		    "20, 25",
		    "30, 35",
		    "40, 45"
		})
		void sub(int a, int b) {
			
			logger.info("Executing test case for subtraction from CSV Source.... with value of a :: "+a+" and value of b ::"+b);
			assertEquals(a-b, op.sub(a, b));
			
		}
		
	}
	
	
	
	/**
	@Nested
	@DisplayName("TestFromCSVFileSource")
	class testCsvFileSource{
		
		
		@DisplayName("When Adding two numbers")
		@ParameterizedTest
		@CsvFileSource(resources = "src/main/resources/data.csv", numLinesToSkip = 1)
		void add(int a) {
			
			logger.info("Executing test case for addition from CSV File Source.... with value of a :: "+a);
			assertEquals(a+a, op.add(a, a));
			
		}
		
		
		@DisplayName("When multiply two numbers")
		@ParameterizedTest
		@CsvFileSource(resources = "string", numLinesToSkip = 1)
		void mul(int a) {
			
			logger.info("Executing test case for multiplication from CSV File Source.... with value of a :: "+a);
			assertEquals(a*a, op.mul(a, a));
			
		}
		
		@DisplayName("When dividing two numbers")
		@ParameterizedTest
		@CsvFileSource(resources = "classpath:data.csv", numLinesToSkip = 1)
		void divide(int a) {
			
			logger.info("Executing test case for division from CSV File Source.... with value of a :: "+a);
			assertEquals(1, op.devide(a, a));
			
		}
		
		
		@DisplayName("When subtracting two numbers")
		@ParameterizedTest
		@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
		void sub(int a) {
			
			logger.info("Executing test case for subtraction from CSV File Source.... with value of a :: "+a);
			assertEquals(0, op.sub(a, a));
			
		}
		
	}
	**/


	@Nested
	@DisplayName("TestFromArgumentsSource")
	class testArgumentsSource{
		
		
		@DisplayName("When Adding two numbers")
		@ParameterizedTest
		@ArgumentsSource(MyArgumentsProvider.class)
		void add(int a) {
			
			logger.info("Executing test case for addition from Argument Source.... with value of a :: "+a);
			assertEquals(a+a, op.add(a, a));
			
		}
		
		
		@DisplayName("When multiply two numbers")
		@ParameterizedTest
		@ArgumentsSource(MyArgumentsProvider.class)
		void mul(int a) {
			
			logger.info("Executing test case for multiplication from Argument Source.... with value of a :: "+a);
			assertEquals(a*a, op.mul(a, a));
			
		}
		
		@DisplayName("When dividing two numbers")
		@ParameterizedTest
		@ArgumentsSource(MyArgumentsProvider.class)
		void divide(int a) {
			
			logger.info("Executing test case for division from Argument Source.... with value of a :: "+a);
			assertEquals(1, op.devide(a, a));
			
		}
		
		
		@DisplayName("When subtracting two numbers")
		@ParameterizedTest
		@ArgumentsSource(MyArgumentsProvider.class)
		void sub(int a) {
			
			logger.info("Executing test case for subtraction from Argument Source.... with value of a :: "+a);
			assertEquals(0, op.sub(a, a));
			
		}
		
	}




	
	
	
	
}

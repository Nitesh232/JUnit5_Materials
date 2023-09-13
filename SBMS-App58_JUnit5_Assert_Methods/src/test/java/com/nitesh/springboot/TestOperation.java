package com.nitesh.springboot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
				
				// Checks if the expected value is equal to the actual value. Uses the equals() method for comparison.
				
				() -> assertEquals(25, op.add(10, 15)),
				() -> assertEquals('a', 'a', "Assert Equal method"),
				
				// Checks if the expected value is not equal to the actual value.
				
				() -> assertNotEquals(5, 6, "Testing Assert not Equal"),
				
				// Checks if the given condition is true.
				
				() -> assertTrue(1 == 1, "Testing Assert True Method.."),
				
				// Checks if the given condition is false.
				
				() -> assertFalse(1 == 0, "Testing Assert False Method.."),
				
				// Checks if the given object is null.
				
				() -> assertNull(null, "Testing Assert Null method.."),
				
				// Checks if the given object is not null.
				
				() -> assertNotNull(1 == 1, "Testing assert Not Null method.."),
				
				// Checks if the expected and actual references point to the same object in memory.
				
				() -> assertSame(10, 10, "Testing Assert Same Method.."),
				
				// Checks if the expected and actual references point to different objects in memory.
				
				() -> assertNotSame(10, "as", "Testing Assert not Same method..")
				
		);
		
	}
	
	
	// Checks if invoking the executable code block throws an exception of the specified exceptionType.
	
	
	@DisplayName("TestAssertThrows")
	@Test
    void exceptionTesting() {
        assertThrows(ArithmeticException.class, () -> Math.floorDiv(10, 0), "Testing Assert Throws Method..");
    }
	
	
	// Checks if invoking the executable code block completes within the specified duration. If not, the test fails.
	
	@DisplayName("TestAssertTimeout")
	@Test
    void timeoutTesting() {
		assertTimeout(Duration.ofNanos(10), () -> Math.floorDiv(10, 1), "Testing Assert Timeout method..");
    }
	
	
	// Similar to assertTimeout, but this method runs the executable in a separate thread and forcefully 
	// terminates it if it exceeds the specified duration.
	
	@DisplayName("TestAssertTimeoutPreemptively")
	@Test
    void timeoutPreempetivelyTesting() {
		assertTimeoutPreemptively(Duration.ofNanos(1), () -> Math.floorDiv(10, 10), "Testing Assert Timeout Preemptively method..");
    }
	
	
	
	
	String[] getArray() {
		List<String> list = new ArrayList<>();
		
		list.add("Book");
		list.add("Laptop");
		list.add("TV");
		
		return list.toArray(new String[list.size()]);
	}
	
	
	// Checks if the expectedArray and actualArray are equal, element by element.
	
	@DisplayName("TestAssertArrayEquals")
	@Test
    void arrayEqualsTesting() {
		assertArrayEquals(getArray(), getArray(), "Testing Assert Array Equal Method..");
    }
	
	
	
}

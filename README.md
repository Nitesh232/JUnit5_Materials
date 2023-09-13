
**Note:** Visit [Here](https://junit.org/junit5/docs/current/user-guide/#overview) to find the official documentation for JUnit5.

# What is Unit Testing

Unit testing is a software testing technique where individual components or units of code are tested in isolation to ensure their correctness. A "unit" typically refers to the smallest testable part of an application, such as a single function, method, or class. The goal of unit testing is to verify that each unit of code behaves as expected and meets its specified requirements.

Unit testing is a fundamental practice in test-driven development (TDD), where tests are written before the actual code is implemented. TDD follows a cycle of writing a failing test, implementing the code to make the test pass, and then refactoring as needed.


# JUnit5 Architecture

**JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage**

**JUnit Platform:** The JUnit Platform serves as a foundation for launching testing frameworks on the JVM. It also defines the TestEngine API for developing a testing framework that runs on the platform. Furthermore, the platform provides a Console Launcher to launch the platform from the command line and the JUnit Platform Suite Engine for running a custom test suite using one or more test engines on the platform. First-class support for the JUnit Platform also exists in popular IDEs (IntelliJ IDEA, Eclipse, NetBeans, and Visual Studio Code) and build tools (Gradle, Maven, and Ant).


**JUnit Jupiter:** JUnit Jupiter is the combination of the programming model and extension model for writing tests and extensions in JUnit 5. The Jupiter sub-project provides a TestEngine for running Jupiter based tests on the platform.

**JUnit Vintage:** JUnit Vintage provides a TestEngine for running JUnit 3 and JUnit 4 based tests on the platform. It requires JUnit 4.12 or later to be present on the class path or module path.


# JUnit5 Annotations


**@Test:**  
```
Denotes that a method is a test method. Unlike JUnit 4’s @Test annotation, this annotation does not declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated annotations. Such methods are inherited unless they are overridden.
```

**@BeforeEach:**
```
Denotes that the annotated method should be executed before each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class
```

**@AfterEach:**
```
Denotes that the annotated method should be executed after each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class
```

**@BeforeAll:**
```	
Denotes that the annotated method should be executed before all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class
```

**@AfterAll:**
```
Denotes that the annotated method should be executed after all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class
```

**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Annotations/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with @BeforeAll, @AfterAll, @BeforeEach and @AfterEach annotations.


**@Tag:**
```
Test classes and methods can be tagged via the @Tag annotation. Those tags can later be used to filter test discovery and execution. Such annotations are inherited at the class level but not at the method level. 
```

**@DisplayName:**
```
Test classes and test methods can declare custom display names via @DisplayName — with spaces, special characters, and even emojis — that will be displayed in test reports and by test runners and IDEs.
```

**@Disabled:**
```
Used to disable a test class or test method; analogous to JUnit 4’s @Ignore. Such annotations are not inherited.
```

**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Disabled_and_DisplayName/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with @Disabled and @DisplayName annotation.


### @ParameterizedTest

This annotation is used to create parameterized tests, which allow you to run the same test method with different sets of parameters. To provide these parameters, you can use various sources and annotations to customize how the parameters are supplied to the test method. Here are the commonly used annotations and sources in conjunction with `@ParameterizedTest:`


**@ValueSource:**
```
@ValueSource is one of the simplest possible sources. It lets you specify a single array of literal values and can only be used for providing a single argument per parameterized test invocation.
```

**@MethodSource:**
```
@MethodSource allows you to refer to one or more factory methods of the test class or external classes.

Factory methods within the test class must be static unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS); whereas, factory methods in external classes must always be static.
```

**@CsvSource:**
```
@CsvSource allows you to express argument lists as comma-separated values (i.e., CSV String literals). Each string provided via the value attribute in @CsvSource represents a CSV record and results in one invocation of the parameterized test. The first record may optionally be used to supply CSV headers
```

**@CsvFileSource:**
```
@CsvFileSource lets you use comma-separated value (CSV) files from the classpath or the local file system. Each record from a CSV file results in one invocation of the parameterized test. The first record may optionally be used to supply CSV headers. You can instruct JUnit to ignore the headers via the numLinesToSkip attribute. If you would like for the headers to be used in the display names, you can set the useHeadersInDisplayName attribute to true. 
```

**@ArgumentsSource:**
```
@ArgumentsSource can be used to specify a custom, reusable ArgumentsProvider. Note that an implementation of ArgumentsProvider must be declared as either a top-level class or as a static nested class.
```

**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Parameterized_Annotation/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with @ParameterizedTest annotation.


## Repeated Tests :

JUnit Jupiter provides the ability to repeat a test a specified number of times by annotating a method with @RepeatedTest and specifying the total number of repetitions desired. Each invocation of a repeated test behaves like the execution of a regular @Test method with full support for the same lifecycle callbacks and extensions.

In addition to specifying the number of repetitions and failure threshold, a custom display name can be configured for each repetition via the `name` attribute as `name = RepeatedTest.LONG_DISPLAY_NAME` of the @RepeatedTest annotation. Furthermore, the display name can be a pattern composed of a combination of static text and dynamic placeholders. The following placeholders are currently supported.

- **{displayName}:** display name of the @RepeatedTest method

- **{currentRepetition}:** the current repetition count

- **{totalRepetitions}:** the total number of repetitions

**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Repeated_Test/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with @RepeatedTest annotation.

## Nested Tests :

@Nested tests give the test writer more capabilities to express the relationship among several groups of tests. Such nested tests make use of Java’s nested classes and facilitate hierarchical thinking about the test structure. Here’s an elaborate example, both as source code and as a screenshot of the execution within an IDE.

**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Nested_Test/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with @Nested annotation.


## TestInfo and RepetitionInfo :

In JUnit 5, TestInfo and RepetitionInfo are two special types of objects that provide information about the currently executing test method. They are available as method parameters in test methods when used as arguments. These objects can be particularly useful for customizing and tracking information about your test methods, especially in parameterized tests or repeated tests.

**TestInfo:**

- TestInfo is an interface that provides information about the currently executing test method.
- It can be used to retrieve details such as the test method name, test class name, and associated display name.
- You can use TestInfo to create custom reporting or logging for your tests.

**RepetitionInfo:**

- RepetitionInfo is an interface provided specifically for repeated tests (tests annotated with @RepeatedTest).
- It allows you to access information about the current repetition of a repeated test.
- You can use RepetitionInfo to customize test logic based on the repetition index, total repetitions, and other details.


**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_TestInfo_and_RepetitionInfo/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with TestInfo and RepetitionInfo.


## Assertions :

In JUnit 5, assertions are statements or conditions that you use to verify the expected outcomes of your tests. They are used to check whether the actual results of your code match the expected results. If an assertion fails during a test, it indicates that something in your code is not behaving as expected, and the test fails.

JUnit 5 provides several assertion methods to perform different types of checks. These assertion methods are typically static methods in the org.junit.jupiter.api.Assertions class. Here are some of the commonly used assertion methods in JUnit 5:

**assertEquals(expected, actual):**

- Checks if the expected value is equal to the actual value. Uses the equals() method for comparison.

- `Example: assertEquals(5, calculator.add(2, 3));`

**assertNotEquals(expected, actual):**

- Checks if the expected value is not equal to the actual value.

- `Example: assertNotEquals(0, list.size());`

**assertTrue(condition):**

- Checks if the given condition is true.
-  `Example: assertTrue(result > 0);`

**assertFalse(condition):**

- Checks if the given condition is false.
- `Example: assertFalse(list.isEmpty());`

**assertNull(object):**

- Checks if the given object is null.
- `Example: assertNull(someObject);`

**assertNotNull(object):**

- Checks if the given object is not null.
- `Example: assertNotNull(result);`


**assertSame(expected, actual):**

- Checks if the expected and actual references point to the same object in memory.
- `Example: assertSame(expectedList, actualList);`

**assertNotSame(expected, actual):**

- Checks if the expected and actual references point to different objects in memory.

- `Example: assertNotSame(expected, actual);`

**assertArrayEquals(expectedArray, actualArray):**

- Checks if the expectedArray and actualArray are equal, element by element.
-  `Example: assertArrayEquals(expectedArray, actualArray);`

**assertThrows(exceptionType, executable):**

- Checks if invoking the executable code block throws an exception of the specified exceptionType.
- `Example: assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));`

**assertTimeout(duration, executable):**

- Checks if invoking the executable code block completes within the specified duration. If not, the test fails.
- `Example: assertTimeout(Duration.ofMillis(100), () -> someOperation());`

**assertTimeoutPreemptively(duration, executable):**

- Similar to assertTimeout, but this method runs the executable in a separate thread and forcefully terminates it if it exceeds the specified duration.


**Note:** Visit [here](https://github.com/Nitesh232/JUnit5_Materials/blob/main/JUnit5_Assert_Methods/src/test/java/com/nitesh/springboot/TestOperation.java) to find an example with Assertions methods.

**Note:** Visit [Here](https://junit.org/junit5/docs/current/user-guide/#overview) to find the official documentation for JUnit5.

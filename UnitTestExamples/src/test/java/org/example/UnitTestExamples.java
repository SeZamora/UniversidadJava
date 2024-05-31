/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.example;

import java.io.IOException;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;


class UnitTestExamples {

    public static Person globalPerson;
    public Person person;
    public Calculator calculator;

    private static String greeting() {
        return "Hello, World!";
    }


    @BeforeAll
    static void initAll() {
        globalPerson = new Person("Person", "Global");
    }

    @BeforeEach
    void init() {
        this.person = new Person("Person", "Scoped");
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("Succeeding test")
    void succeedingTest() {
        assertEquals(1,1);
    }

    @Test
    @DisplayName("Failing test")
    void failingTest() {
        fail("a failing test");
    }

    @Test
    void failingAssertTrueTest() {
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Person", person.getFirstName()),
                () -> assertEquals("Scoped", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), UnitTestExamples::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }

    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        System. gc();
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All tests already ran");
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101",
            "12 , 24 , 1"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    class TestHttp {
        public String getHttpResponse() {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            try {
                HttpGet request = new HttpGet("https://example.com");
                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
                return responseString;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    class TestHttp2 {
        private CloseableHttpClient httpClient;
        public TestHttp2(CloseableHttpClient httpClient) {
            this.httpClient = httpClient;
        }
        public String getHttpResponse() {
            try {
                HttpGet request = new HttpGet("https://example.com");
                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();
                String responseString = entity.toString();
                return String.format("\"%s\" was the response", responseString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Test
    void testGetHttpResponse() throws IOException {
        CloseableHttpClient httpClientMock;
        CloseableHttpResponse responseMock;
        HttpEntity entityMock;
        httpClientMock = Mockito.mock(CloseableHttpClient.class);
        responseMock = Mockito.mock(CloseableHttpResponse.class);
        entityMock = Mockito.mock(HttpEntity.class);

        String rawResponse = "any raw response";
        String expectedResponse = "\"any raw response\" was the response";

        when(httpClientMock.execute(any(HttpGet.class))).thenReturn(responseMock);
        when(responseMock.getEntity()).thenReturn(entityMock);
        when(entityMock.toString()).thenReturn(rawResponse);


        TestHttp2 test = new TestHttp2(httpClientMock);
        String response = test.getHttpResponse();

        assertEquals(expectedResponse, response);

    }
}
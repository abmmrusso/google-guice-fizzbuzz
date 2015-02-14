package net.toryu.playground.guice.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzUpperLimitParserTest {

    private FizzBuzzUpperLimitParser testInstance;

    @Before
    public void setup() {
        testInstance = new FizzBuzzUpperLimitParser();
    }

    @Test(expected=IllegalArgumentException.class)
    public void givenNullValueStringToParseUpperLimitThrowsIllegalArgumentException() {
        testInstance.parseUpperLimit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericValueStringThrowsIllegalArgumentException() {
        testInstance.parseUpperLimit("Not-a-number");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNumericValueStringBelowOneThrowsIllegalArgumentException() {
        testInstance.parseUpperLimit("0");
    }

    @Test
    public void givenNumericValueStringReturnsNumericValue() {
        assertThat(testInstance.parseUpperLimit("15"), equalTo(15));
    }
}

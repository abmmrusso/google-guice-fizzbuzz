package net.toryu.playground.guice.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzNumberTranslatorTest {

    private FizzBuzzNumberTranslator testInstance;

    @Before
    public void setup() {
        testInstance = new FizzBuzzNumberTranslator();
    }

    @Test
    public void givenNumberNotDivisibleByThreeOrFiveReturnsNumber() {
        assertThat(testInstance.translate(1), equalTo("1"));
    }

    @Test
    public void givenNumberDivisibleByThreeReturnsFizz() {
        assertThat(testInstance.translate(3), equalTo("Fizz"));
    }

    @Test
    public void givenNumberDivisibleByFiveReturnsBuzz(){
        assertThat(testInstance.translate(5), equalTo("Buzz"));
    }

    @Test
    public void givenNumberDivisibleByThreeAndFiveReturnsFizzBuzz() {
        assertThat(testInstance.translate(15), equalTo("FizzBuzz"));
    }
}

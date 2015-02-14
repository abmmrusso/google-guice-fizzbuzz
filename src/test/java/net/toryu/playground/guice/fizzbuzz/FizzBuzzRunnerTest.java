package net.toryu.playground.guice.fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzRunnerTest {

    private PrintStream originalSystemOut;
    private ByteArrayOutputStream writtenOutput;
    private FizzBuzzRunner testInstance;

    @Before
    public void setup() {
        writtenOutput = new ByteArrayOutputStream();
        PrintStream dummySystemOut = new PrintStream(writtenOutput);
        originalSystemOut = System.out;
        System.setOut(dummySystemOut);

        testInstance = new FizzBuzzRunner();
    }

    @After
    public void teardown() {
        System.setOut(originalSystemOut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNoParameterOnMainMethodExecutionThrowsIllegalArgumentException() {
        FizzBuzzRunner.main(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericValueAsParameterOnMainMethodExecutionThrowsIllegalArgumentException() {
        FizzBuzzRunner.main(new String[] {"NonNumeric"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenLowerThanOneAsUpperLimitOnMainMethodExecutionThrowsIllegalArgumentException() {
        FizzBuzzRunner.main(new String[] {"0"});
    }

    @Test
    public void givenValidUpperLimitValueAsParameterOnMainMethodExecutionPerformsFizzBuzz() {
        FizzBuzzRunner.main((new String[] {"15"}));

        String[] writtenValuesPerLine = writtenOutput.toString().split(System.getProperty("line.separator"));
        assertThat(writtenValuesPerLine.length, equalTo(15));
        assertThat(writtenValuesPerLine[0], equalTo("1"));
        assertThat(writtenValuesPerLine[1], equalTo("2"));
        assertThat(writtenValuesPerLine[2], equalTo("Fizz"));
        assertThat(writtenValuesPerLine[3], equalTo("4"));
        assertThat(writtenValuesPerLine[4], equalTo("Buzz"));
        assertThat(writtenValuesPerLine[5], equalTo("Fizz"));
        assertThat(writtenValuesPerLine[6], equalTo("7"));
        assertThat(writtenValuesPerLine[7], equalTo("8"));
        assertThat(writtenValuesPerLine[8], equalTo("Fizz"));
        assertThat(writtenValuesPerLine[9], equalTo("Buzz"));
        assertThat(writtenValuesPerLine[10], equalTo("11"));
        assertThat(writtenValuesPerLine[11], equalTo("Fizz"));
        assertThat(writtenValuesPerLine[12], equalTo("13"));
        assertThat(writtenValuesPerLine[13], equalTo("14"));
        assertThat(writtenValuesPerLine[14], equalTo("FizzBuzz"));
    }

}

package net.toryu.playground.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NumberTranslationRunnerTest {

    @Inject private NumberTranslationRunner testInstance;
    @Inject private ByteArrayOutputStream writtenData;
    @Inject private NumberParameters testInputData;

    @Before
    public void setup() {
        Guice.createInjector(new NumberTranslationRunnerTestModule()).injectMembers(this);
    }

    @Test(expected=IllegalArgumentException.class)
    public void givenLowerBoundGreaterThanUpperBoundThrowsIllegalArgumentException() {
        testInputData.setLowerLimit(5);
        testInputData.setUpperLimit(1);
        testInstance.runNumberTranslation(testInputData);
    }

    @Test
    public void translatesAllNumbersFromLowerToUpperGivenBoundsAndWritesThemToOutput() {
        testInputData.setLowerLimit(1);
        testInputData.setUpperLimit(5);
        testInstance.runNumberTranslation(testInputData);

        String[] writtenLines = writtenData.toString().split(System.getProperty("line.separator"));

        assertThat(writtenLines.length, equalTo(5));
        assertThat(writtenLines[0], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "1"));
        assertThat(writtenLines[1], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "2"));
        assertThat(writtenLines[2], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "3"));
        assertThat(writtenLines[3], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "4"));
        assertThat(writtenLines[4], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "5"));
    }

    private class NumberTranslationRunnerTestModule extends AbstractModule {

        @Override
        protected void configure() {
            ByteArrayOutputStream writtenOutput = new ByteArrayOutputStream();
            bind(ByteArrayOutputStream.class).toInstance(writtenOutput);
            bind(NumberTranslator.class).to(DummyNumberTranslator.class);
            bind(PrintStream.class).toInstance(new PrintStream(writtenOutput));
        }
    }
}

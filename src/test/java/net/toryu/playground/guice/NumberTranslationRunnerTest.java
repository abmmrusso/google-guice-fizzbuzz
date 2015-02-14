package net.toryu.playground.guice;

import net.toryu.playground.guice.NumberTranslationRunner;
import net.toryu.playground.guice.NumberTranslator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NumberTranslationRunnerTest {

    @Test
    public void translatesAllNumbersFromLowerToUpperGivenBoundsAndWritesThemToOutput() {
        ByteArrayOutputStream writtenData = new ByteArrayOutputStream();

        NumberTranslationRunner testInstance = new NumberTranslationRunner(new DummyNumberTranslator(), new PrintStream(writtenData));

        testInstance.runNumberTranslation(1,5);

        String[] writtenLines = writtenData.toString().split(System.getProperty("line.separator"));

        assertThat(writtenLines.length, equalTo(5));
        assertThat(writtenLines[0], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "1"));
        assertThat(writtenLines[1], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "2"));
        assertThat(writtenLines[2], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "3"));
        assertThat(writtenLines[3], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "4"));
        assertThat(writtenLines[4], equalTo(DummyNumberTranslator.TRANSLATION_PREFIX + "5"));
    }

    private class DummyNumberTranslator implements NumberTranslator {

        public static final String TRANSLATION_PREFIX = "translated-";

        @Override
        public String translate(int numberToTranslate) {
            return TRANSLATION_PREFIX + numberToTranslate;
        }
    }
}

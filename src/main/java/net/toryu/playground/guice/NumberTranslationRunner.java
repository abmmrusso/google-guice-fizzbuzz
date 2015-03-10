package net.toryu.playground.guice;

import com.google.inject.Inject;
import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class NumberTranslationRunner {

    private NumberTranslator numberTranslator;
    private PrintStream outputStream;

    @Inject
    NumberTranslationRunner(NumberTranslator numberTranslator, PrintStream outputStream) {
        this.numberTranslator = numberTranslator;
        this.outputStream = outputStream;
    }

    public void runNumberTranslation(NumberParameters inputData) {
        if(inputData.getLowerLimit() > inputData.getUpperLimit()) {
            throw new IllegalArgumentException("Lower bound is greater than Upper bound.");
        }

        for(int current = inputData.getLowerLimit(); current <= inputData.getUpperLimit(); current++) {
            outputStream.println(numberTranslator.translate(current));
        }
    }
}

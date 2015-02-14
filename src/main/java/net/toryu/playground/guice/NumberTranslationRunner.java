package net.toryu.playground.guice;

import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class NumberTranslationRunner {

    private NumberTranslator numberTranslator;
    private PrintStream outputStream;

    public NumberTranslationRunner(NumberTranslator numberTranslator, PrintStream outputStream) {
        this.numberTranslator = numberTranslator;
        this.outputStream = outputStream;
    }

    public void runNumberTranslation(int lowerBound, int upperBound) {
        for(int current = lowerBound; current <= upperBound; current++) {
            outputStream.println(numberTranslator.translate(current));
        }
    }
}

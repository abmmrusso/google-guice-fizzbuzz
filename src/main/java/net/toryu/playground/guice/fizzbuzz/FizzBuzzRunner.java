package net.toryu.playground.guice.fizzbuzz;

import net.toryu.playground.guice.NumberTranslationRunner;
import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class FizzBuzzRunner extends NumberTranslationRunner {

    public FizzBuzzRunner(NumberTranslator numberTranslator, PrintStream outputStream) {
        super(numberTranslator, outputStream);
    }

    public static void main(String[] input) {
        if(input.length < 1) {
            throw new IllegalArgumentException("Program requires supplied upper limit as a parameter");
        }

        FizzBuzzRunner fizzBuzzRunner = new FizzBuzzRunner(new FizzBuzzNumberTranslator(), System.out);
        fizzBuzzRunner.runNumberTranslation(1,new FizzBuzzUpperLimitParser().parseUpperLimit(input[0]));
    }
}

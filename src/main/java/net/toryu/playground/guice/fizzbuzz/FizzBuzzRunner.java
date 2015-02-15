package net.toryu.playground.guice.fizzbuzz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.toryu.playground.guice.NumberTranslationRunner;
import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class FizzBuzzRunner {

    public static void main(String[] input) {
        if(input.length < 1) {
            throw new IllegalArgumentException("Program requires supplied upper limit as a parameter");
        }

        Injector guiceInjector = Guice.createInjector(new FizzBuzzModule());
        NumberTranslationRunner fizzBuzzRunner = guiceInjector.getInstance(NumberTranslationRunner.class);
        fizzBuzzRunner.runNumberTranslation(1,new FizzBuzzUpperLimitParser().parseUpperLimit(input[0]));
    }
}

package net.toryu.playground.guice.fizzbuzz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.toryu.playground.guice.CommandLineParser;
import net.toryu.playground.guice.NumberTranslationRunner;
import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class FizzBuzzMain {

    public static void main(String[] input) {
        Injector guiceInjector = Guice.createInjector(new FizzBuzzModule());
        NumberTranslationRunner fizzBuzzRunner = guiceInjector.getInstance(NumberTranslationRunner.class);
        fizzBuzzRunner.runNumberTranslation(new CommandLineParser().parseCmdParameters(input));
    }
}

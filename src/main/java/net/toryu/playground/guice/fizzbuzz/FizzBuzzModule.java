package net.toryu.playground.guice.fizzbuzz;

import com.google.inject.AbstractModule;
import net.toryu.playground.guice.NumberTranslator;

import java.io.PrintStream;

public class FizzBuzzModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NumberTranslator.class).to(FizzBuzzNumberTranslator.class);
        bind(PrintStream.class).toInstance(System.out);
    }
}

package net.toryu.playground.guice.fizzbuzz;

import net.toryu.playground.guice.NumberTranslator;

public class FizzBuzzNumberTranslator implements NumberTranslator {
    @Override
    public String translate(int numberToTranslate) {
        StringBuilder translation = new StringBuilder();

        if(numberToTranslate % 3 == 0) {
            translation.append("Fizz");
        }

        if(numberToTranslate % 5 == 0) {
            translation.append("Buzz");
        }

        if(translation.length() == 0) {
            translation.append(numberToTranslate);
        }

        return translation.toString();
    }
}

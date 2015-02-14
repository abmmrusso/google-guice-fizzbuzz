package net.toryu.playground.guice.fizzbuzz;

public class FizzBuzzUpperLimitParser {
    public int parseUpperLimit(String toParse) {
        if(toParse == null) {
            throw new IllegalArgumentException("Value to parse cannot be null");
        }

        try{
            int upperLimit = Integer.parseInt(toParse);

            if(upperLimit < 1) {
                throw new IllegalArgumentException("Upper limit for Fizz Buzz must be one or greater");
            }

            return upperLimit;
        }catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Value to parse must be numerical. Was given " + toParse);
        }
    }
}

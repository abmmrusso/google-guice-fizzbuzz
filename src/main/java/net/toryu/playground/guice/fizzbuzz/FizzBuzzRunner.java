package net.toryu.playground.guice.fizzbuzz;

public class FizzBuzzRunner {
    public static void main(String[] input) {
        if(input.length < 1) {
            throw new IllegalArgumentException("An numerical Upper limit is required to execute");
        }

        try {
            int upperLimit = Integer.parseInt(input[0]);

            if(upperLimit < 1) {
                throw new IllegalArgumentException("Upper limit must be one or greater");
            }

            StringBuilder sb = new StringBuilder();
            for(int current = 1; current <= upperLimit; current++) {
                sb.setLength(0);
                if(current % 3 == 0) {
                    sb.append("Fizz");
                }

                if(current % 5 == 0) {
                    sb.append("Buzz");
                }

                if(sb.length() == 0) {
                    sb.append(current);
                }

                System.out.println(sb.toString());
            }

        }catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("Provided Upper limit is non-numerical: " + input);
        }
    }
}

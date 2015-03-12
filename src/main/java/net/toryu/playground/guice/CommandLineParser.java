package net.toryu.playground.guice;

import net.toryu.playground.guice.NumberParameters;

import java.util.*;

public class CommandLineParser {

    public NumberParameters parseCmdParameters(String[] cmdParameters) {
        if(cmdParameters == null || cmdParameters.length == 0) {
            throw new IllegalArgumentException("A numeric upper limit is required as parameter");
        }

        NumberParameters parsedParameters = new NumberParameters();

        List<String> parameterStack = new LinkedList<>(Arrays.asList(cmdParameters));

        if(parameterStack.size() > 1) {
            try {
                parsedParameters.setLowerLimit(Integer.parseInt(parameterStack.remove(0)));
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Lower limit must be numeric");
            }
        } else {
            parsedParameters.setLowerLimit(1);
        }

        try {
            parsedParameters.setUpperLimit(Integer.parseInt(parameterStack.remove(0)));
        }catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("Upper limit must be numeric");
        }

        if(parsedParameters.getUpperLimit() < parsedParameters.getLowerLimit()) {
            throw new IllegalArgumentException("Lower limit (" + parsedParameters.getLowerLimit() + ") is higher than upper limit (" + parsedParameters.getUpperLimit() + ")");
        }

        return parsedParameters;
    }
}

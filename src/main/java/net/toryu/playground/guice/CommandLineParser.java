package net.toryu.playground.guice;

import net.toryu.playground.guice.NumberParameters;

public class CommandLineParser {

    public NumberParameters parseCmdParameters(String[] cmdParameters) {
        if(cmdParameters == null || cmdParameters.length == 0) {
            throw new IllegalArgumentException("A numeric upper limit is required as parameter");
        }

        NumberParameters parsedParameters = new NumberParameters();

        try {
            parsedParameters.setUpperLimit(Integer.parseInt(cmdParameters[0]));
        }catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("Upper limit must be numeric");
        }

        if(cmdParameters.length > 1) {
            try {
                parsedParameters.setLowerLimit(Integer.parseInt(cmdParameters[1]));
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Lower limit must be numeric");
            }
        } else {
            parsedParameters.setLowerLimit(1);
        }

        if(parsedParameters.getUpperLimit() < parsedParameters.getLowerLimit()) {
            throw new IllegalArgumentException("Lower limit (" + parsedParameters.getLowerLimit() + ") is higher than upper limit (" + parsedParameters.getUpperLimit() + ")");
        }

        return parsedParameters;
    }
}

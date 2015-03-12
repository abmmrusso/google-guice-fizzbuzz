package net.toryu.playground.guice;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CommandLineParserTest {

    private CommandLineParser testInstance;

    @Before
    public void setup() {
        testInstance = new CommandLineParser();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullParameterListToParseThrowsIllegalArgumentException() {
        testInstance.parseCmdParameters(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyParameterListToParseThrowsIlllegalArgumentException() {
        testInstance.parseCmdParameters(new String[] {});
    }

    @Test(expected =  IllegalArgumentException.class)
    public void givenNonNumericParameterUpperLimitToParseThrowsIllegalArgumentException() {
        testInstance.parseCmdParameters(new String[] { "NaN"});
    }

    @Test
    public void givenOnlyUpperLimitParameterParsesItAndLowerLimitDefaultsToOne() {
        NumberParameters toTest = testInstance.parseCmdParameters(new String[] {"10"});
        assertThat(toTest.getUpperLimit(), equalTo(10));
        assertThat(toTest.getLowerLimit(), equalTo(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericParameterLowerLimitToParseThrowsIllegalArgumentException() {
        testInstance.parseCmdParameters(new String[] { "1", "NaN" });
    }

    @Test
    public void givenBothLimitParametersParsesThem() {
        NumberParameters toTest = testInstance.parseCmdParameters(new String[] {"2", "10"});
        assertThat(toTest.getUpperLimit(), equalTo(10));
        assertThat(toTest.getLowerLimit(), equalTo(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenUpperLimitLowerThanLowerLimitThrowsIllegalArgumentException() {
        testInstance.parseCmdParameters(new String[] {"2", "1"});
    }
}

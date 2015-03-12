This repository exemplifies a FizzBuzz implemented with the help of Google Guice.
The work in here was performed as a quick study of Google Guice usage.

Starting at a unit tested resolution of the FizzBuzz kata/exercise, the log will show the following:
- Refactoring of the original solution to allow for dependency injection.
- Performing of Google Guice powered injection
- Refactoring for better project structure
- Minor cleanups and consolidation.

The project is powered by a Gradle build.
Assuming you already have Gradle installed (follow http://gradle.org/installation if not), you can perform the following:
- gradle test
  - Executed the existing unit tests
- gradle run -PappArgs="['<LOWER BOUND', '<UPPER BOUND>']"
  - Builds and executes the FizzBugg main class.
    <LOWER BOUND> represents an integer value greater than one where the FizzBuzz must start
    <UPPER BOUND> represents an integer value greater or equal to the lower bound where the FizzBuzz will end.
    For example, using -PappArgs="['4','15']" will perform the FizzBuzz for all numbwes between 4 and 15.
    <LOWER BOUND> can be ommited (for example -PappArgs="['15']"). If so, it is automatically set to 1.

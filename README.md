# Mini-JUnit

A small unit testing framework built with annotations and reflection, demonstrated on the Hand class of my Blackjack project.

## Requirements

- Java 11
- Windows, Git Bash (or any shell with `javac`)

## Build and run

```
javac -d out $(find src -name "*.java")
java -cp out peldateszt.Main
```

## How the runner works

The runner is the TesztFuttato class. It gets a Class<?> object and uses reflection to find all the methods marked with @Teszt. The tests are sorted by name, so the report order is always the same. For every single test a new instance of the test class is created, so the tests cannot affect each other. First the @Elotte methods run on this instance, then the test method itself, and at the end the @Utana methods run, even if the test failed. The methods are called with Method.invoke, which wraps every exception in an InvocationTargetException, so the real exception is taken out with getCause(). If the real exception is an AssertHiba, the test FAILED. If it is any other exception, it is an ERROR, because something unexpected happened. If the test has @VartKivetel, it passes only when the thrown exception is an instance of the expected type, otherwise it fails. At the end the summary shows the number of passed, failed and error tests and the elapsed time in milliseconds.

## Design

See the class diagram in [docs/uml.md](docs/uml.md).

## Example output

```
FAIL INTENTIONAL_FAIL_wrongBust - expected: <true> but was: <false>
FAIL INTENTIONAL_FAIL_wrongValue - expected: <16> but was: <15>
PASS aceCountsAsEleven
PASS aceCountsAsOneWhenBust
PASS addCardIncreasesSize
PASS blackjackWithAceAndKing
PASS bustOverTwentyOne
PASS emptyHandValueIsZero
PASS fromStringToStringRoundTrip
PASS nullCardIsRejected
PASS threeCardTwentyOneIsNotBlackjack
Passed: 9, Failed: 2, Errors: 0, Time: 29 ms
```

The two FAIL lines are intentional (required by the assignment). PASS/FAIL/ERROR is used instead of check marks, because the Windows console does not handle Unicode well.

## AI usage

I used Claude as a tutor. It did not write my code. It guided me step by step: it explained the concepts (annotations, reflection, InvocationTargetException), gave me skeleton code with TODO comments and the key line as a comment, and reviewed the code I sent back with targeted corrections. I typed every line into the project myself.
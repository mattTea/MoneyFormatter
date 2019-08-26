Thoughts
========

1. Created a `mockMoneyFormatter` to use in tests, so that each individual function can be tested in isolation.

2. Just written and passed `createMoneyAdder -> should return "315"` - kind of wrote the code first before I was able to work out how to test it.

3. Was struggling a bit with the benefits of this Higher Order Functions pattern
    - Should be understood as simply dependency injection
    - Inject different behaviour depending on your context - real application, test, or different behaviours within the application
    
4. Not sure if my return from `createMoneyAdder` is correct ([at step 1](https://github.com/mattTea/MoneyFormatter/blob/5a1da34e3e/src/main/kotlin/money/formatter/MoneyFormatter.kt)) - I'm invoking `moneyFormatter` directly, but should possibly just be returning a function?

5. Step 2 has been invoked in the tests
    - Created a functional-type test to invoke both these things together
    - And added a `println()` statement to createMoneyAdder to cover the printing of the output
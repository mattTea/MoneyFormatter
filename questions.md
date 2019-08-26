Questions & thoughts
====================

1. Created a `mockMoneyFormatter` to use in tests, so that each individual function can be tested in isolation.

2. Just written and passed `createMoneyAdder -> should return "315"` - kind of wrote the code first before I was able to work out how to test it.

3. Was struggling a bit with the benefits of this Higher Order Functions pattern
    - Should be understood as simply dependency injection
    - Inject different behaviour depending on your context - real application, test, or different behaviours within the application
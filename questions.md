Questions & thoughts
====================

1. Set up the typealiases at start of the file, and although the first function (`defaultMoneyFormatter`)
is of typealias MoneyFormatter, I'm not yet referring to the typealias

2. Created a `mockMoneyFormatter` to use in tests even though I was using only a single file and could have used functions, classes, etc without mocking.
  - The `mockMonetFormatter` was a class rather than a typealias, is this expected, as I'm not expecting to write a real class for this in the code?
    - I think this is ok, as it seems to be similar to the implementation of the `HttpHandler` (MockAtg) in `AtgCategoryFinderTest`

3. Just written and passed `createMoneyAdder -> should return "315"` - kind of wrote the code first before I was able to work out how to test it.
  - Not sure yet how I could have broken down the test and implementation into smaller chunks.
  - Also, still not really sure of the benefits of this HoF pattern.
  - Looks like I jumped straight over and completed step 2 and 3 together as well.

4. Ok, corrected my `createMoneyAdder -> should return "315"` test to use (::defaultMoneyFormatter) so I don't have to create and use the mock.
This makes me happier, it didn't feel right that I wasn't using the only actual MoneyFormatter I'd written!

5. Step 3 is maybe creating a real MoneyFormatter (rather than a mock) and using it to print a proper output
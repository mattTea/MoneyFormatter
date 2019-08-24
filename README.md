Higher Order Functions in Kotlin - MoneyFormatter
=================================================

A simple exercise to practice using higher order functions, and the patterns used in my current product team. 

This can be written in one file to keep it simple.

------

## Overview

Work with the following function types:

```kotlin
typealias MoneyFormatter = (BigDecimal) -> String
```

```kotlin
typealias MoneyAdder = (BigDecimal, BigDecimal) -> String
```

------

## Steps

### Step 1: Write a bunch of functions

`defaultMoneyFormatter` - should take a `BigDecimal` and return a `String` (i.e. it is a `MoneyFormatter`)
- this will just take a `BigDecimal` and return it's default `.toString()` value

`createMoneyAdder` - should take a `MoneyFormatter` and return a `MoneyAdder`
- this will return a function
- the function that it returns should take two `BigDecimal`s, add them together and format them
using the `MoneyFormatter` that was passed in to `createMoneyAdder`

------

### Step 2: Invoke `createMoneyAdder`

Invoke the `createMoneyAdder` with the `defaultMoneyFormatter` to create a function that adds together and formats `BigDecimal`s.
- use this function to add two BigDecimals together and print the output

------

### Step 3: Create a better `MoneyFormatter`

`betterMoneyFormatter` - should take a `BigDecimal` and return a `String` (i.e. it is a `MoneyFormatter`)
- this will return **Truth Table A** from below

Then invoke the same `createMoneyAdder`, but using the `betterMoneyFormatter` to create a function that
- adds together two `BigDecimal`s, but formats them better
- use this function and print the output

------

### Step 4: (Optional) Create an even better `MoneyFormatter`

`bestMoneyFormatter` - should take a `BigDecimal` and return a `String` (i.e. it is a MoneyFormatter)
- this will return **Truth Table B** from below

------

#### Truth Table A

| Input | Output |
|-------|--------|
| 0 | £0.00 |
| 0.01 | £0.01 |
| 1 | £1.00 |
| -1 | £-1.00 |


#### Truth Table B

| Input | Output |
|-------|--------|
| 0 | Free |
| 0.01 | £0.01 |
| 1 | £1.00 |
| -1 | -£1.00 |

package money.formatter

import java.math.BigDecimal

typealias MoneyFormatter = (BigDecimal) -> String

typealias MoneyAdder = (BigDecimal, BigDecimal) -> String

internal fun defaultMoneyFormatter(amount: BigDecimal): String = amount.toString()

internal fun betterMoneyFormatter(amount: BigDecimal): String {
    return "£${amount.setScale(2)}"
}

internal fun bestMoneyFormatter(amount: BigDecimal): String =
    when {
        amount == BigDecimal(0) -> "Free"
        amount < BigDecimal(0) -> formatNegative(amount)
        else -> "£${amount.setScale(2)}"
    }

// createMoneyAdder takes a function (that takes a BigDecimal and returns a String) and returns a function (that takes 2 BigDecimals and returns a String)
internal fun createMoneyAdder(moneyFormatter: MoneyFormatter): MoneyAdder = { firstAmount, secondAmount ->
    println("Formatted total: ${moneyFormatter(firstAmount + secondAmount)}")

    moneyFormatter(firstAmount + secondAmount)
}

private fun formatNegative(amount: BigDecimal): String {
    val positiveAmount = amount * (BigDecimal(-1))
    return "-£${positiveAmount.setScale(2)}"
}
package money.formatter

import java.math.BigDecimal

typealias MoneyFormatter = (BigDecimal) -> String

typealias MoneyAdder = (BigDecimal, BigDecimal) -> String

internal fun defaultMoneyFormatter(amount: BigDecimal): String = amount.toString()

internal fun createMoneyAdder(moneyFormatter: MoneyFormatter): MoneyAdder = { firstAmount, secondAmount ->
    moneyFormatter(firstAmount + secondAmount)
}

// Alternative createMoneyAdder using fun keyword when returning function (both do the same)
internal fun createMoneyAdder2(moneyFormatter: MoneyFormatter): MoneyAdder =
    fun(firstAmount: BigDecimal, secondAmount: BigDecimal): String {
        return moneyFormatter(firstAmount + secondAmount)
    }
package money.formatter

import java.math.BigDecimal

typealias MoneyFormatter = (BigDecimal) -> String

typealias MoneyAdder = (BigDecimal, BigDecimal) -> String

internal fun defaultMoneyFormatter(amount: BigDecimal): String = amount.toString()

internal fun createMoneyAdder(moneyFormatter: MoneyFormatter): MoneyAdder = { firstAmount, secondAmount ->
    val totalAmount = firstAmount + secondAmount
    moneyFormatter(totalAmount)
}
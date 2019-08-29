package money.formatter

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal

object MoneyFormatterTest : Spek ({

    describe("defaultMoneyFormatter") {

        val result = defaultMoneyFormatter(BigDecimal(450))

        it("should return a string") {
            assertThat(result).isInstanceOf(String::class.java)
        }

        it("should return string representation of money value") {
            assertThat(result).isEqualTo("450")
        }
    }

    describe("createMoneyAdder") {

        // createMoneyAdder takes mockMoneyFormatter and returns moneyAdder here
        val moneyAdder = createMoneyAdder(::mockMoneyFormatter)

        // the we call moneyAdder with 2 BigDecimals
        val result = moneyAdder(BigDecimal(200), BigDecimal(115))

        it("should return '315'") {
            assertThat(result).isEqualTo("315")
        }
    }

    describe("createMoneyAdder functional test (to invoke it) using defaultMoneyFormatter") {

        // we can next replace mockMoneyFormatter and inject defaultMoneyFormatter instead for different behaviour (benefits of dependency injection)
        val moneyAdder = createMoneyAdder(::defaultMoneyFormatter)

        val result = moneyAdder(BigDecimal(250), BigDecimal(85))

        it("should return '335'") {
            assertThat(result).isEqualTo("335")
        }
    }

    describe("createMoneyAdder functional test (to invoke it with positive total) using betterMoneyFormatter") {

        val moneyAdder = createMoneyAdder(::betterMoneyFormatter)

        val result = moneyAdder(BigDecimal(250), BigDecimal(85))

        it("should return '£355.00'") {
            assertThat(result).isEqualTo("£335.00")
        }
    }

    describe("createMoneyAdder functional test (to invoke it with negative total) using betterMoneyFormatter") {

        val moneyAdder = createMoneyAdder(::betterMoneyFormatter)

        val result = moneyAdder(BigDecimal(-250), BigDecimal(85))

        it("should return '£-165.00'") {
            assertThat(result).isEqualTo("£-165.00")
        }
    }
})

private fun mockMoneyFormatter(input: BigDecimal): String {
    return input.toString()
}

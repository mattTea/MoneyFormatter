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

        val moneyAdder = createMoneyAdder(::mockMoneyFormatter)

        val result = moneyAdder(BigDecimal(200), BigDecimal(115))

        it("should return '315'") {
            assertThat(result).isEqualTo("315")
        }
    }
})

private fun mockMoneyFormatter(input: BigDecimal): String {
    return input.toString()
}

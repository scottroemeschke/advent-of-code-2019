package dev.cramblings.aoc.d1

import com.google.common.truth.Truth
import org.junit.Test

class TestsPartTwo {

    @Test
    fun testExampleOne() {
        Truth.assertThat(FuelCalculationsPartTwo.totalRequiredForMass(14))
                .isEqualTo(2)
    }

    @Test
    fun testExampleTwo() {
        Truth.assertThat(FuelCalculationsPartTwo.totalRequiredForMass(1969))
                .isEqualTo(966)
    }

    @Test
    fun testExampleThree() {
        Truth.assertThat(FuelCalculationsPartTwo.totalRequiredForMass(100756))
                .isEqualTo(50346)
    }

}

package dev.cramblings.aoc.d1

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class TestsPartOne {

    @Test
    fun testExampleOne() {
        assertThat(FuelCalculationsPartOne.requiredForModule(Module(12)))
                .isEqualTo(2)
    }

    @Test
    fun testExampleTwo() {
        assertThat(FuelCalculationsPartOne.requiredForModule(Module(14)))
                .isEqualTo(2)
    }

    @Test
    fun testExampleThree() {
        assertThat(FuelCalculationsPartOne.requiredForModule(Module(1969)))
                .isEqualTo(654)
    }

    @Test
    fun testExampleFour() {
        assertThat(FuelCalculationsPartOne.requiredForModule(Module(100756)))
                .isEqualTo(33583)
    }

}

package dev.cramblings.aoc.d2

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class TestsPartOne {

    @Test
    fun testExampleOne() {
        val input = listOf(1,0,0,0,99)
        val output = ShipComputer.processIntcodeProgram(input)
        assertThat(output).isEqualTo(listOf(2,0,0,0,99))
    }

    @Test
    fun testExampleTwo() {
        val input = listOf(2,3,0,3,99)
        val output = ShipComputer.processIntcodeProgram(input)
        assertThat(output).isEqualTo(listOf(2,3,0,6,99))
    }

    @Test
    fun testExampleThree() {
        val input = listOf(2,4,4,5,99,0)
        val output = ShipComputer.processIntcodeProgram(input)
        assertThat(output).isEqualTo(listOf(2,4,4,5,99,9801))
    }

    @Test
    fun testExampleFour() {
        val input = listOf(1,1,1,4,99,5,6,0,99)
        val output = ShipComputer.processIntcodeProgram(input)
        assertThat(output).isEqualTo(listOf(30,1,1,4,2,5,6,0,99))
    }


}

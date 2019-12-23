package dev.cramblings.aoc.d2

import dev.cramblings.aoc.runner.runAoc

object DayTwo {
    private val input = listOf(1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 10, 19, 1, 6, 19, 23, 1, 13, 23,
            27, 1, 6, 27, 31, 1, 31, 10, 35, 1, 35, 6, 39, 1, 39, 13, 43, 2, 10, 43, 47, 1, 47, 6, 51, 2, 6,
            51, 55, 1, 5, 55, 59, 2, 13, 59, 63, 2, 63, 9, 67, 1, 5, 67, 71, 2, 13, 71, 75, 1, 75, 5, 79, 1,
            10, 79, 83, 2, 6, 83, 87, 2, 13, 87, 91, 1, 9, 91, 95, 1, 9, 95, 99, 2, 99, 9, 103, 1, 5, 103,
            107, 2, 9, 107, 111, 1, 5, 111, 115, 1, 115, 2, 119, 1, 9, 119, 0, 99, 2, 0, 14, 0)
    operator fun invoke() {
        runAoc {
            day(2)
            title("""
                On the way to our gravity assist around the moon, our ships computer bursts into flames.
                We need to build a new "IntCode" computer. 
            """.trimIndent())

            partOne("""
                The first step is to restore the gravity assist program (your puzzle input) to the "1202 program alarm" 
                state it had just before the last computer caught fire. To do this, before running the program, 
                replace position 1 with the value 12 and replace position 2 with the value 2. 
                
                What value is left at position 0 after the program halts?
            """.trimIndent()) {
                val copiedInput = input.toMutableList()

                //Gotta fix the input
                copiedInput[1] = 12
                copiedInput[2] = 2

                val output = ShipComputer.processIntcodeProgram(copiedInput)
                "Output of the program is: ${output[0]}"
            }
            partTwo("""
                With terminology out of the way, we're ready to proceed. To complete the gravity assist, you need to 
                determine what pair of inputs produces the output 19690720."
            """.trimIndent()) {
                val (noun, verb) = solveForNounVerb(19690720, input.toMutableList())
                """
                    Solved. Noun: $noun, verb: $verb
                    So the answer for (100 x noun + verb) = ${100 * noun + verb}                    "
                """.trimIndent()
            }
        }
    }
}

package dev.cramblings.aoc.runner

data class AocPart(val description: String, val result: () -> Any)

class AocRunDsl {

    var partOne: AocPart? = null
    var partTwo: AocPart? = null
    var dayNumber: Int? = null
    var dayTitle: String? = null

    fun day(day: Int) {
        dayNumber = day
    }

    fun title(title: String) {
        dayTitle = title
    }

    fun partOne(description: String, resultBlock: () -> Any) {
        partOne = AocPart(description, resultBlock)
    }

    fun partTwo(description: String, resultBlock: () -> Any) {
        partTwo = AocPart(description, resultBlock)
    }
}

fun runAoc(block: AocRunDsl.() -> Unit) {
    AocRunDsl().apply(block).run {
        println("Day $dayNumber: $dayTitle")

        println(partOne?.run {
            """
            --------
            PART ONE:
            "$description"

            Result: ${result()}
            --------
            """.trimIndent()
        } ?: "Missing part one...")

        println(partTwo?.run {
            """
            --------
            PART TWO:
            "$description"

            Result: ${result()}
            --------
            """.trimIndent()
        } ?: "Missing part two...")

        println("End day $dayNumber")
    }
}

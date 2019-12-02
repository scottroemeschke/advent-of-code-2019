package dev.cramblings.aoc

import dev.cramblings.aoc.d1.DayOne

val days = listOf(DayOne)

fun main() {
    println("""
        
        Running each days solutions.
    
    """.trimIndent())

    days.forEach { it() }

    println("""
        
        Finished.
    
    """.trimIndent())
}

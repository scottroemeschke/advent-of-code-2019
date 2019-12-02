package dev.cramblings.aoc.d1

import kotlin.math.floor

inline class Module(val mass: Int)

object FuelCalculationsPartOne {
    fun requiredForModule(mod: Module) = floor(mod.mass/3f).toInt() - 2
}

object FuelCalculationsPartTwo {
    fun totalRequiredForMass(mass: Int): Int {
        var massToProcess = mass
        var totalFuel = 0
        while (true) {
            val newFuel = requiredForMass(massToProcess)
            totalFuel += newFuel
            massToProcess = newFuel
            if (newFuel == 0) break
        }
        return totalFuel
    }

    private fun requiredForMass(mass: Int): Int {
        val requirement = floor(mass/3f).toInt() - 2
        if (requirement < 0)
            return 0
        return requirement
    }
}

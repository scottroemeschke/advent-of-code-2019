package dev.cramblings.aoc.d1

import dev.cramblings.aoc.runner.runAoc

val inputModules = listOf(
        Module(95423),
        Module(142796),
        Module(88137),
        Module(105610),
        Module(79299),
        Module(110633),
        Module(136792),
        Module(112578),
        Module(75168),
        Module(115615),
        Module(147584),
        Module(72145),
        Module(108822),
        Module(57753),
        Module(96827),
        Module(69117),
        Module(131220),
        Module(111193),
        Module(120295),
        Module(56240),
        Module(111190),
        Module(80740),
        Module(137267),
        Module(113183),
        Module(126821),
        Module(58966),
        Module(63556),
        Module(110977),
        Module(100328),
        Module(75367),
        Module(57371),
        Module(88235),
        Module(134475),
        Module(109071),
        Module(92653),
        Module(73347),
        Module(135186),
        Module(64534),
        Module(81198),
        Module(55423),
        Module(100060),
        Module(149555),
        Module(110905),
        Module(102826),
        Module(129023),
        Module(112618),
        Module(146542),
        Module(102579),
        Module(67193),
        Module(84258),
        Module(60679),
        Module(86674),
        Module(124720),
        Module(68719),
        Module(55259),
        Module(76421),
        Module(70397),
        Module(67998),
        Module(73366),
        Module(106401),
        Module(59402),
        Module(112481),
        Module(131113),
        Module(142606),
        Module(107732),
        Module(69291),
        Module(61575),
        Module(131019),
        Module(51510),
        Module(101215),
        Module(116973),
        Module(63530),
        Module(146179),
        Module(132427),
        Module(127777),
        Module(127040),
        Module(143964),
        Module(120340),
        Module(144404),
        Module(72156),
        Module(96412),
        Module(140554),
        Module(60228),
        Module(52590),
        Module(128157),
        Module(120444),
        Module(125649),
        Module(111641),
        Module(117476),
        Module(139326),
        Module(149188),
        Module(133599),
        Module(55273),
        Module(83773),
        Module(50458),
        Module(105166),
        Module(76469),
        Module(66681),
        Module(84288),
        Module(103708)
)

object DayOne {
    operator fun invoke() {
        runAoc {
            day(1)
            title("""
            The Elves quickly load you into a spacecraft and prepare to launch.
            At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of fuel required yet.
            Fuel required to launch a given module is based on its mass.
        """.trimIndent())
            partOne("Calculate total fuel requirement for Fuel Counter-Upper") {
                inputModules.map {
                    FuelCalculationsPartOne.requiredForModule(it)
                }.sum().toString()
            }

            partTwo(" Calculating total fuel requirement for Fuel Counter-Upper (for real this time)...") {
                inputModules.map {
                    FuelCalculationsPartTwo.totalRequiredForMass(it.mass)
                }.sum().toString()
            }
        }
    }
}

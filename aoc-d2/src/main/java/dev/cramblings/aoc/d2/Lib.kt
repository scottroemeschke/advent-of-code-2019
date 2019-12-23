package dev.cramblings.aoc.d2

object OpCodes {
    val Halt = 99
    val Add = 1
    val Multiply = 2
}

sealed class OpCode {
    abstract val value: Int

    object Halt: OpCode() {
        override val value = 99
    }

    object Add: OpCode() {
        override val value = 1
    }

    object Multiply: OpCode() {
        override val value = 2
    }
}

typealias IntcodeProgramInput = List<Int>

typealias IntcodeProgramOutput = List<Int>

typealias NounAndVerb = Pair<Int, Int>

fun solveForNounVerb(desiredOutput: Int, input: IntcodeProgramInput): NounAndVerb {
    var currentNoun = 0
    var currentVerb = 0
    while (currentNoun < 99) {
        while (currentVerb < 99) {
            try {
                val copiedInput = input.toMutableList()
                copiedInput[1] = currentNoun
                copiedInput[2] = currentVerb

                val output = ShipComputer.processIntcodeProgram(copiedInput)

                if (output[0] == desiredOutput)
                    return NounAndVerb(currentNoun, currentVerb)
            } catch (e: Exception) {
                //Ignore if we made a "bad" intcode program, and just move on the next set of inputs.
            }
            currentVerb += 1
        }
        currentVerb = 0
        currentNoun += 1
    }
    throw Exception("no match of noun and verb found to get desired output: $desiredOutput")
}

object ShipComputer {

    fun processIntcodeProgram(input: IntcodeProgramInput): IntcodeProgramOutput  {
        //Don't mutate our input, just return a new list
        //Start processing at 0
        return process(0, input.toMutableList())
    }

    private tailrec fun process(currentIndex: Int, currentProgramState: MutableList<Int>): IntcodeProgramOutput {
        when (currentProgramState[currentIndex]) {
            OpCodes.Halt -> return currentProgramState
            OpCodes.Add -> {
                val inputPositionOne = currentProgramState[currentIndex + 1]
                val inputPositionTwo = currentProgramState[currentIndex + 2]
                val outputPosition = currentProgramState[currentIndex + 3]

                val inputOne = currentProgramState[inputPositionOne]
                val inputTwo = currentProgramState[inputPositionTwo]
                val outputAdd = inputOne + inputTwo
                currentProgramState[outputPosition] = outputAdd
            }
            OpCodes.Multiply -> {
                val inputPositionOne = currentProgramState[currentIndex + 1]
                val inputPositionTwo = currentProgramState[currentIndex + 2]
                val outputPosition = currentProgramState[currentIndex + 3]

                val inputOne = currentProgramState[inputPositionOne]
                val inputTwo = currentProgramState[inputPositionTwo]
                val outputMul = inputOne * inputTwo
                currentProgramState[outputPosition] = outputMul
            }
        }
        if (currentProgramState.size - 1 < currentIndex + 4) {
            return currentProgramState
        }
        return process(currentIndex + 4, currentProgramState)
    }

}

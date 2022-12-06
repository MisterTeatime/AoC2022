fun main() {
    fun part1(input: List<String>): String {
        val stacks = getStackSetup(input.takeWhile { it.isNotEmpty() }.dropLast(1))
        val instructions = getInstructions(input.takeLastWhile { it.isNotEmpty() })

        instructions.forEach {
            var sourceStack = stacks[it.source - 1]
            var destinationStack = stacks[it.destination - 1]

            destinationStack += sourceStack.takeLast(it.amount).reversed() //Die Kisten aus dem Ausgangsstapel in umgekehrter Reihenfolge auf den Zielstapel legen
            sourceStack = sourceStack.dropLast(it.amount) //Die Kisten vom Ausgangsstapel entfernen

            stacks[it.source - 1] = sourceStack
            stacks[it.destination - 1] = destinationStack
        }

        return stacks.fold("") { acc, stack -> acc + stack.takeLast(1)}
    }

    fun part2(input: List<String>): String {
        val stacks = getStackSetup(input.takeWhile { it.isNotEmpty() }.dropLast(1))
        val instructions = getInstructions(input.takeLastWhile { it.isNotEmpty() })

        instructions.forEach {
            var sourceStack = stacks[it.source - 1]
            var destinationStack = stacks[it.destination - 1]

            destinationStack += sourceStack.takeLast(it.amount) //Die Kisten aus dem Ausgangsstapel in gleicher Reihenfolge auf den Zielstapel legen
            sourceStack = sourceStack.dropLast(it.amount) //Die Kisten vom Ausgangsstapel entfernen

            stacks[it.source - 1] = sourceStack
            stacks[it.destination - 1] = destinationStack
        }

        return stacks.fold("") { acc, stack -> acc + stack.takeLast(1)}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}

fun getStackSetup(input: List<String>): MutableList<String> {
    val levels = input
        .map { level -> level.chunked(4).map { it[1] } }
        .reversed()

    val stacks = mutableListOf<String>()

    for (i in 0 until levels.maxOf { it.size }) {
       stacks.add(levels.map { it.elementAtOrNull(i) ?: "" }.fold("") { acc, item -> acc+item}.trimEnd())
    }

    return stacks
}

fun getInstructions(input: List<String>): List<ShiftInstruction> {
    val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()

    return input
        .map { regex.find(it)!!.groupValues.drop(1) }
        .map { (amount, source, destination) -> ShiftInstruction(amount.toInt(), source.toInt(), destination.toInt())}
}

data class ShiftInstruction(val amount: Int, val source: Int, val destination: Int)
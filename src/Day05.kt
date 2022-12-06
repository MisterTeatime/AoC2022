fun main() {
    fun part1(input: List<String>): String {

        val stacks = getStackSetup(input.takeWhile { it.isNotEmpty() }.dropLast(1))
        val instructions = getInstructions(input.takeLastWhile { it.isNotEmpty() })


        return ""
    }

    fun part2(input: List<String>): String {
        return ""
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    //check(part2(testInput) == "")

    val input = readInput("Day05")
    println(part1(input))
    //println(part2(input))
}

fun getStackSetup(input: List<String>): MutableList<String> {
    val levels = input
        .map { level -> level.chunked(4).map { it[1] } }
        .reversed()

    val stacks = mutableListOf<String>()

    for (i in 0 until levels.maxOf { it.size }) {
       stacks.add(levels.map { it.elementAtOrNull(i) ?: "" }.fold("") { acc, item -> acc+item})
    }

    return stacks
}

fun getInstructions(input: List<String>): List<ShiftInstruction> {
    return listOf()
}

data class ShiftInstruction(val amount: Int, val source: Int, val destination: Int)
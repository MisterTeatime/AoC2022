fun main() {
    fun part1(input: List<String>): Int {
        return input.partitionGroups("")
            .map { elf -> elf.sumOf { it.toInt() } }
            .maxOf { it }
    }

    fun part2(input: List<String>): Int {
        val calories = input.partitionGroups("")
            .map { elf -> elf.sumOf { it.toInt() } }

        return topMax(3, calories).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
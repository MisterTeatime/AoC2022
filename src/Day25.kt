fun main() {
    fun part1(input: List<String>): String {
        return input.sumOf { it.parseSNAFU() }.toSNAFU()
    }

    fun part2(input: List<String>): String {
        return "input.size"
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day25_test")
    check(part1(testInput) == "2=-1=0")
    //check(part2(testInput) == "1")

    val input = readInput("Day25")
    println(part1(input))
    //println(part2(input))
}

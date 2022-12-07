fun main() {
    fun part1(input: List<String>): Int {
        return getStartIndex(input[0], 4)
    }

    fun part2(input: List<String>): Int {
        return getStartIndex(input[0], 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}

fun getStartIndex(input: String, size: Int): Int {
    val candidates = input.windowed(size, 1)
    val start = candidates.first { it.toCharArray().distinct().size == it.length }

    return candidates.indexOf(start) + size
}
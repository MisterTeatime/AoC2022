fun main() {
    fun part1(input: List<String>): Int {
        val obstacles = input
            .flatMap { line -> line.split(" -> ")
                .windowed(2, 1)
                .flatMap { Line(it).getAllIntegerPoints() }
            }


        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day14_test")
    check(part1(testInput) == 24)
    //check(part2(testInput) == 1)

    val input = readInput("Day14")
    println(part1(input))
    //println(part2(input))
}

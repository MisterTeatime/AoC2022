fun main() {
    fun part1(input: List<String>): Int {

        return input
            .map {line ->
                line.split(",")
                .map { range ->
                    IntRange(
                        range.takeWhile { it != '-' }.toInt()
                        ,range.takeLastWhile { it != '-' }.toInt()
                    ).toSet()
                }
            }
            .map { line ->
                val commonElements = line[0].intersect(line[1])
                commonElements == line[0] || commonElements == line[1]
            }
            .count { it }
    }

    fun part2(input: List<String>): Int {
        return input
            .map {line ->
                line.split(",")
                    .map { range ->
                        IntRange(
                            range.takeWhile { it != '-' }.toInt()
                            ,range.takeLastWhile { it != '-' }.toInt()
                        ).toSet()
                    }
            }
            .map { line ->
                line[0].intersect(line[1])
             }
            .count { it.isNotEmpty() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

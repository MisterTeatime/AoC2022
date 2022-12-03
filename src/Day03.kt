fun main() {
    val priorities = ('a'..'z') + ('A'..'Z')

    fun part1(input: List<String>): Int {
        return input.map {
            it.chunked(it.length / 2)
        }
            .flatMap { (front, back) ->
                front.toSet().intersect(back.toSet())
            }
            .sumOf { priorities.indexOf(it) + 1 }
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .flatMap { group ->
                group.fold(group[0].toSet()) { acc, line ->
                    acc.intersect(line.toSet())
                }
            }
            .sumOf { priorities.indexOf(it) + 1 }
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

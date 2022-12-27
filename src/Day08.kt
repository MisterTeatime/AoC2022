fun main() {
    fun part1(input: List<String>): Int {
        val cols = (0 until input[0].length)
            .map { input.fold("") {acc, s -> acc + s[it] } }

        return input.mapIndexed { rIndex, row ->
            row.mapIndexed { cIndex, c ->
                isVisible(row, cIndex, c.digitToInt()) || isVisible(cols[cIndex], rIndex, c.digitToInt())
            }
        }.sumOf { row -> row.count { it } }
    }

    fun part2(input: List<String>): Int {
        val cols = (0 until input[0].length)
            .map { input.fold("") {acc, s -> acc + s[it] } }

        val scenicScores = input.mapIndexed { rIndex, row ->
            row.mapIndexed { cIndex, _ ->
                getScenicScore(row, cIndex) * getScenicScore(cols[cIndex], rIndex)
            }
        }

        return scenicScores.maxOf { row -> row.maxOf { it } }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    //check(part1(testInput) == 21)
    check(part2(testInput) == 8)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}

fun isVisible(group: String, pos: Int, item: Int): Boolean {
    val before = group.take(pos).map { it.digitToInt() }
    val after = group.takeLast(group.length - 1 -pos).map { it.digitToInt() }

    return before.all { it < item } || after.all { it < item }
}

fun getScenicScore(group: String, pos: Int): Int {
    val item = group[pos].digitToInt()
    val before = group.take(pos).map { it.digitToInt() }
    val after = group.takeLast(group.length - 1 - pos).map { it.digitToInt() }

    val testBefore = before.reversed().takeWhile { it < item }.count()
    val testAfter = after.takeWhile { it < item }.count()

    return (if (testBefore < before.count()) testBefore + 1 else testBefore) *
            (if (testAfter < after.count()) testAfter + 1 else testAfter)
}
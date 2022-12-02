fun main() {
    /*
       A, X = Rock
       B, Y = Paper
       C, Z = Scissors
     */


    fun part1(input: List<String>): Int {
        val duelPoints = mapOf(
            "AX" to 3 + 1, //Rock, Rock, Draw
            "AY" to 6 + 2, //Rock, Paper, Win
            "AZ" to 0 + 3, //Rock, Scissors, Loss
            "BX" to 0 + 1, //Paper, Rock, Loss
            "BY" to 3 + 2, //Paper, Paper, Draw
            "BZ" to 6 + 3, //Paper, Scissors, Win
            "CX" to 6 + 1, //Scissors, Rock, Win
            "CY" to 0 + 2, //Scissors, Paper, Loss
            "CZ" to 3 + 3  //Scissors, Scissors, Draw
        )

        return input
            .map { it.split(" ") }
            .sumOf { (elf, me) -> duelPoints[elf + me]!! }
    }

    fun part2(input: List<String>): Int {
        val duelPoints = mapOf(
            "AX" to 0 + 3, //Rock, Loss, Scissors
            "AY" to 3 + 1, //Rock, Draw, Rock
            "AZ" to 6 + 2, //Rock, Win, Paper
            "BX" to 0 + 1, //Paper, Loss, Rock
            "BY" to 3 + 2, //Paper, Draw, Paper
            "BZ" to 6 + 3, //Paper, Win, Scissors
            "CX" to 0 + 2, //Scissors, Loss, Paper
            "CY" to 3 + 3, //Scissors, Draw, Scissors
            "CZ" to 6 + 1  //Scissors, Win, Rock
        )
        return input
            .map { it.split(" ") }
            .sumOf { (elf, outcome) -> duelPoints[elf + outcome]!! }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

import java.math.BigInteger

fun main() {
    fun part1(input: List<String>): Int {
        val encrypted = input.map { it.toInt() }.mapIndexed { index, i -> index to i }
        val decrypted = encrypted.toMutableList()

        encrypted.forEach { (key, steps) ->
            val index = decrypted.indexOfFirst { it.first == key }
            val size = decrypted.size
            val newIndex = (index + steps).mod(size - 1)

            decrypted.moveAt(index, newIndex)
        }

        val index0 = decrypted.indexOfFirst { it.second == 0}
        val pos1 = decrypted[(1000 + index0).mod(decrypted.size)].second
        val pos2 = decrypted[(2000 + index0).mod(decrypted.size)].second
        val pos3 = decrypted[(3000 + index0).mod(decrypted.size)].second

        return pos1 + pos2 + pos3
    }

    fun part2(input: List<String>): Long {
        val decryptKey = 811589153
        val encrypted = input.map { it.toLong() * decryptKey }.mapIndexed { index, i -> index to i }
        val decrypted = encrypted.toMutableList()

        repeat(10)
        {
            encrypted.forEach { (key, steps) ->
                val index = decrypted.indexOfFirst { it.first == key }
                val size = decrypted.size
                val newIndex =  (index + steps).mod(size - 1)


                decrypted.moveAt(index, newIndex)
            }
        }

        val index0 = decrypted.indexOfFirst { it.second == 0L}
        val pos1 = decrypted[(1000 + index0).mod(decrypted.size)].second
        val pos2 = decrypted[(2000 + index0).mod(decrypted.size)].second
        val pos3 = decrypted[(3000 + index0).mod(decrypted.size)].second

        return pos1 + pos2 + pos3
    }

    println((-5).mod(3))
    println((-5) % 3)

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day20_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 1623178306L)

    val input = readInput("Day20")
    println(part1(input))
    println(part2(input))
}

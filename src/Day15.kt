import java.math.BigInteger

fun main() {

    fun part1(input: List<String>, y: Int): Int {
        val beacons = mutableListOf<Point2D>()
        val sensors = getSensors(input, beacons)
        var covered = 0

        // Die Grenzen der Ausdehnung bestimmen.
        // Es kann kein Punkt jenseits der niedrigsten X-Koordinate minus Beacon-Abstand existieren.
        // Gleiches gilt für Punkte jenseits der höchsten X-Koordinate plus Abstand.
        val boundaries = sensors
            .map { listOf(it.key.x - it.value, it.key.x + it.value) }
            .reduce { best, next -> listOf(minOf(best[0], next[0]), maxOf(best[1], next[1])) }

        for (x in boundaries[0]..boundaries[1]) {
            val point = Point2D(x, y)

            if (beacons.contains(point)) continue

            if (sensors.keys.contains(point)) continue

            if (sensors.any { sensor -> sensor.key.distanceTo(point) <= sensor.value})
                covered += 1
        }

        return covered
    }

    fun part2(input: List<String>, to: Int, from: Int = 0): BigInteger {
        val beacons = mutableListOf<Point2D>()
        val sensors = getSensors(input, beacons)

        val aCoefficients = mutableSetOf<Int>()
        val bCoefficients = mutableSetOf<Int>()

        aCoefficients.addAll(sensors.map { (p, r) -> p.y - p.x + r + 1 })
        aCoefficients.addAll(sensors.map { (p, r) -> p.y - p.x - r - 1 })

        bCoefficients.addAll(sensors.map { (p, r) -> p.x + p.y + r + 1 })
        bCoefficients.addAll(sensors.map { (p, r) -> p.x + p.y - r - 1 })

        val intersections = aCoefficients
            .flatMap { a ->
                bCoefficients.map { b ->
                    ((b - a) / 2) to ((a + b) / 2)
                }
            }
            .map { Point2D(it.first, it.second) }
            .filter { it.x in 0 .. to && it.y in 0..to }

            return intersections.filter { p -> sensors.all { sensor -> p.distanceTo(sensor.key) > sensor.value } }.map { (x,y) -> x.toBigInteger() * 4_000_000.toBigInteger() + y.toBigInteger() }.first()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day15_test")
    check(part1(testInput, 10) == 26)
    check(part2(testInput, 20) == 56_000_011.toBigInteger())

    val input = readInput("Day15")
    println(part1(input, 2_000_000))
    println(part2(input, 4_000_000))
}

fun getSensors(input: List<String>, beacons: MutableList<Point2D>): MutableMap<Point2D, Int> {
    val sensors = mutableMapOf<Point2D, Int>()
    val regex = """x=(-?\d+), y=(-?\d+).*x=(-?\d+), y=(-?\d+)""".toRegex()

    input.forEach {
        val (sensorX, sensorY, beaconX, beaconY) = regex.find(it)!!.destructured
        val sensor = Point2D(sensorX.toInt(), sensorY.toInt())
        val beacon = Point2D(beaconX.toInt(), beaconY.toInt())
        sensors[sensor] = sensor.distanceTo(beacon)
        beacons.add(beacon)
    }

    return sensors
}

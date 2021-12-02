fun main() {
    fun part1(input: List<String>): Int =
        input.map {
            val (cmd, _x) = it.split(" ")
            val x = _x.toInt()
            when (cmd) {
                "forward" -> Pair(x, 0)
                "down" -> Pair(0, x)
                "up" -> Pair(0, -x)
                else -> throw IllegalArgumentException()
            }
        }.fold(Pair(0,0)) { (pos, depth), (x1, x2) ->
            Pair(pos + x1, depth + x2)
        }.let { it.first * it.second }

    fun part2(input: List<String>): Int =
        input.fold(Triple(0,0,0)) { (pos, depth, aim), line ->
            val (cmd, _steps) = line.split(" ")
            val steps = _steps.toInt()
            when (cmd) {
                "forward" -> Triple(pos + steps, depth + aim*steps, aim)
                "down" -> Triple(pos, depth, aim + steps)
                "up" -> Triple(pos, depth, aim - steps)
                else -> throw IllegalArgumentException()
            }
        }.let { it.first * it.second }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

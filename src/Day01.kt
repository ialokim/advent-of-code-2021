fun main() {
    fun part1(input: List<String>): Int =
        input
            .map { it.toInt() }
            .windowed(2)
            .count { (i1,i2) -> i2 - i1 > 0 }

    fun part2(input: List<String>): Int =
        input
            .map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { (i1,i2) -> i2 - i1 > 0 }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

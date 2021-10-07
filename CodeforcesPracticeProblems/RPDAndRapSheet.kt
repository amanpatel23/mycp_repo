private fun solve() {
    val (n, _) = readLine()!!.split(' ').map { it.toInt() }
    for (y in 0 until n) {
        val result = askQuery(y)
        if (result == 1)
            return
    }
}

private fun askQuery(y: Int): Int {
    println(if (y == 0) y else (y.xor(y - 1)))
    val r = readLine()!!.toInt()
    return r
}

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        solve()
    }
}
/* 
    Author: Aman Patel
    Date: 12-06-2021
*/

import java.util.*
import kotlin.collections.*
import kotlin.math.*

fun solve() {

    var (l, r) = readLine()!!.split(" ").map { it.toLong() }

    var result = 0L
    result += (r - l)
    while ((r / 10) > 0) {
        r /= 10
        l /= 10

        result += (r - l)
    }

    println(result)
}

fun main() {

    val t = readLine()!!.toInt()
    for (i in 1..t)
        solve()

}

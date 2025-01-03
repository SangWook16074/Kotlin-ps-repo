package 누적합

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int {nextToken(); return nval.toInt()}
    val n = nextInt(); val m = nextInt()
    val ground = IntArray(n) {nextInt()}
    val pSum = IntArray(n + 1) {0}
    repeat(m) {
        val x = nextInt(); val y = nextInt(); val c = nextInt()
        pSum[x] += c
        if (y != n) pSum[y + 1] -= c
    }
    val sb = StringBuilder()
    for (i in 1 .. n) {
        pSum[i] += pSum[i - 1]
        sb.append("${ground[i-1] + pSum[i]} ")
    }
    print(sb)
}
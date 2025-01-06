import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val dp = Array(30) { LongArray(30) {0} }
    for (i in 1 .. 29) {
        dp[1][i] = i.toLong()
    }
    for (i in 2 .. 29) {
        dp[i][i] = 1
    }
    for (i in 2 .. 29) {
        if (i == 29) { continue }
        for (j in i + 1 .. 29) {
            dp[i][j] += dp[i][j - 1] + dp[i - 1][j - 1]
        }
    }
    val sb = StringBuilder()
    repeat(nextInt()) {
        sb.appendLine(dp[nextInt()][nextInt()])
    }
    print(sb)
}
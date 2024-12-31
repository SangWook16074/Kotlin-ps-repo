import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    val n = nextInt(); val h = nextInt()
    val line = IntArray(h) {0}
    repeat(n) { idx ->
        val size = nextInt()
        if (idx % 2 == 0) {
            line[h - size] += 1
        } else {
            line[0] += 1
            line[size] -= 1
        }
    }
    for (i in 1 ..< h) {
        line[i] += line[i - 1]
    }

    val ans = line.min(); var cnt = 0
    line.forEach { l ->
        if (l == ans) { cnt += 1 }
    }
    println("$ans $cnt")
}

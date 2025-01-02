fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine()
    val m = n.split("-")
    val x = m[0].split("+").map { it.toInt() }.fold(0) { acc, s -> acc + s }
    var ans = if (n[0] == '-') -x else x
    for (i in 1 ..< m.size) {
        val di = m[i].split("+").map { it.toInt() }.fold(0) {acc, s -> acc + s}
        ans -= di
    }
    bw.write("$ans")
    bw.flush()
    br.close()
    br.close()
}
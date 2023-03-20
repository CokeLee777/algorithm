package implement

import java.util.Scanner

val moves = listOf(Pair(-2,-1), Pair(-2,1), Pair(2,-1), Pair(2,1), Pair(1,-2), Pair(1,2), Pair(-1,-2), Pair(-1,2))

fun main(){
    val sc = Scanner(System.`in`)
    val point = sc.next()
    //현재 나이트가 서 있는 위치
    val x = point[1].digitToInt() - 1
    val y = point[0] - 'a'

    var pathCount = 0
    for (move in moves) {
        val nx = x + move.first
        val ny = y + move.second
        if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue
        pathCount += 1
    }

    println(pathCount)
}
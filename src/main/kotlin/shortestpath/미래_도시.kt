package shortestpath

import java.util.*
import kotlin.math.*

private const val INF = 1e9.toInt()

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val graph = mutableListOf<MutableList<Int>>()
    for(i in 0..n){
        graph.add(mutableListOf())
        for(j in 0..n){
            if(i == j) graph[i].add(0)
            else graph[i].add(INF)
        }
    }
    //경로 입력받기
    for(i in 0 until m){
        val a = sc.nextInt()
        val b = sc.nextInt()

        graph[a][b] = 1
        graph[b][a] = 1
    }

    val x = sc.nextInt()    //목적지
    val k = sc.nextInt()    //경유지

    //플로이드 워셜 알고리즘 수행
    for(l in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                graph[i][j] = min(graph[i][j], graph[i][l] + graph[l][j])
            }
        }
    }

    when{
        graph[1][k] + graph[k][x] >= INF -> println(-1)
        else -> println(graph[1][k] + graph[k][x])
    }
}
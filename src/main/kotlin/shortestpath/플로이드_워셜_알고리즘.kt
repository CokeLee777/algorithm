package shortestpath

import java.util.*
import kotlin.math.*

private const val INF = 1e9.toInt()

fun main(){
    val sc = Scanner(System.`in`)
    //노드의 개수 및 간선의 개수 입력받기
    val n = sc.nextInt()
    val m = sc.nextInt()
    //그래프 초기화
    val graph = mutableListOf<MutableList<Int>>()
    for(i in 0..n){
        graph.add(mutableListOf())
        for(j in 0..n){
            if(i == j) graph[i].add(0)
            else graph[i].add(INF)
        }
    }

    //각 간선에 대한 정보를 받아 초기화
    for(i in 0 until m){
        val a = sc.nextInt()
        val b = sc.nextInt()
        val c = sc.nextInt()

        graph[a][b] = c
    }

    //플로이드 워셜 알고리즘 수행
    for(k in 1..n){
        for(a in 1..n){
            for(b in 1..n){
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    //결과 출력
    for(i in 1..n){
        for(j in 1..n){
            when(graph[i][j]){
                INF -> print("INFINITY ")
                else -> print("${graph[i][j]} ")
            }
        }
        println()
    }
}
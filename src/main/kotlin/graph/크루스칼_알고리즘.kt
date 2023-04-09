package graph

import java.util.*
import kotlin.math.*


fun main(){
    val sc = Scanner(System.`in`)
    val v = sc.nextInt()
    val e = sc.nextInt()

    val parent = IntArray(v + 1)
    for(i in 1..v){
        parent[i] = i
    }

    fun findParent(x: Int): Int {
        if(x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    fun unionParent(a: Int, b: Int){
        val parentA = findParent(a)
        val parentB = findParent(b)
        if(parentA < parentB) parent[parentB] = parent[parentA] else parent[parentA] = parent[parentB]
    }

    //간선에 대한 정보 입력받기
    val edges = arrayListOf<Edge>()
    for(i in 0 until e){
        val a = sc.nextInt()
        val b = sc.nextInt()
        val cost = sc.nextInt()
        edges.add(Edge(a, b, cost))
    }
    //거리 순서대로 정렬
    edges.sortBy { it.distance }

    //간선을 확인하면서 산장 트리를 만족하는 최소비용 측정
    var totalCost = 0
    for(edge in edges){
        val nodeA = edge.nodeA
        val nodeB = edge.nodeB
        val cost = edge.distance
        //사이클이 발생하지 않은 경우만 포함
        if(findParent(nodeA) != findParent(nodeB)){
            unionParent(nodeA, nodeB)
            totalCost += cost
        }
    }

    println(totalCost)
}

data class Edge(val nodeA: Int, val nodeB: Int, val distance: Int)
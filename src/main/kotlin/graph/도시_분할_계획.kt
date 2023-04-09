package graph

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()    //집의 개수
    val m = sc.nextInt()    //도로(양방향)의 개수

    val parent = IntArray(n + 1)
    for(i in 1..n){
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

    val cities = arrayListOf<City>()
    for(i in 0 until m){
        val a = sc.nextInt()
        val b = sc.nextInt()
        val cost = sc.nextInt()
        cities.add(City(a, b, cost))
    }

    cities.sortBy { it.cost }

    var maxCost = 0
    var totalCost = 0
    for(city in cities){
        val nodeA = city.nodeA
        val nodeB = city.nodeB
        val cost = city.cost
        //사이클이 발생하지 않았다면
        if(findParent(nodeA) != findParent(nodeB)){
            unionParent(nodeA, nodeB)
            totalCost += cost
            maxCost = cost
        }
    }

    println(totalCost - maxCost)
}

data class City(val nodeA: Int, val nodeB: Int, val cost: Int)
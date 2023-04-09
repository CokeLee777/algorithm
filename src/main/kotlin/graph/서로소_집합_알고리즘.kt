package graph

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val v = sc.nextInt()    //노드의 개수
    val e = sc.nextInt()    //간선의 개수

    val parent = IntArray(v + 1)
    //부몰 테이블에서 부모를 자기 자신으로 초기화
    for(i in 1..v){
        parent[i] = i
    }

    fun findParent(x: Int): Int {
        //루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
        if(x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    fun unionParent(a: Int, b: Int){
        val parentA = findParent(a)
        val parentB = findParent(b)
        //부모의 인덱스가 작은 것으로 합침
        if(parentA < parentB) parent[parentB] = parent[parentA] else parent[parentA] = parent[parentB]
    }

    //Union 연산을 각각 수행
    for(i in 0 until e){
        val a = sc.nextInt()
        val b = sc.nextInt()
        unionParent(a, b)
    }

    //각 원소가 속한 집합 출력
    for(i in 1..v){
        print("${findParent(i)} ")
    }
    println()

    //부모 테이블 내용 출력
    for(i in 1..v){
        print("${parent[i]} ")
    }
    println()
}
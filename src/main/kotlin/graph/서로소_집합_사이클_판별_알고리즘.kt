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

    //사이클 발생 여부
    var cycle = false
    for(i in 0 until e){
        val a = sc.nextInt()
        val b = sc.nextInt()
        //사이클이 발생한 경우 종료(아직 합치치 않았는데, 부모가 같은 경우)
        if(findParent(a) == findParent(b)){
            cycle = true
            break
        } else {
            unionParent(a, b)
        }
    }

    if(cycle) print("사이클이 발생했습니다.") else print("사이클이 발생하지 않았습니다.")
}
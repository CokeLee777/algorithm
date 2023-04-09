package graph

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()    //팀의 개수
    val m = sc.nextInt()    //연산의 개수
    
    //부모 테이블 초기화
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
        if(parentA < parentB) parent[b] = parentA else parent[a] = parentB
    }
    
    //연산들 입력받기
    val results = arrayListOf<String>()
    for(i in 0 until m){
        val calc = sc.nextInt()
        val a = sc.nextInt()
        val b = sc.nextInt()
        when(calc){
            0 -> unionParent(a, b)
            1 -> {
                if(findParent(a) == findParent(b)) results.add("YES")
                else results.add("NO")
            }
        }
    }

    for (result in results) {
        println(result)
    }
}
package shortestpath

import java.util.*
import kotlin.Comparator
import kotlin.math.*

private const val INF = 1e9.toInt()

fun main(){
    val sc = Scanner(System.`in`)
    //노드의 개수와 간선의 개수 입력받기
    val n = sc.nextInt()
    val m = sc.nextInt()
    //시작노드 번호 입력받기
    val start = sc.nextInt()
    //최단거리 테이블 초기화
    val distances = IntArray(n + 1) { INF }
    //그래프 입력받기
    val graph = mutableListOf<MutableList<Node>>()
    for(i in 0 .. n){
        graph.add(mutableListOf())
    }
    for(i in 0 until m){
        val a = sc.nextInt()
        val b = sc.nextInt()
        val cost = sc.nextInt()

        graph[a].add(Node(b, cost))
    }

    fun dijkstra(start: Int){
        val pq = PriorityQueue<Node>()
        //시작 노드는 최단 경로를 0으로 설정
        pq.add(Node(start, 0))
        distances[start] = 0
        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            val node = pq.poll()
            val now = node.index
            val distance = node.distance
            //현재 노드가 이미 처리된 적이 있다면 무시
            if(distances[now] < distance) continue
            //현재 노드와 연결된 다른 인접한 노드들을 확인
            for(i in 0 until graph[now].size){
                val cost = distance + graph[now][i].distance
                //비용이 더 적게 든다면
                if(cost < distances[graph[now][i].index]){
                    distances[graph[now][i].index] = cost
                    pq.offer(Node(graph[now][i].index, cost))
                }
            }
        }
    }

    dijkstra(start)

    for(i in 1 .. n){
        when(distances[i]){
            INF -> println("INFINITY")
            else -> println(distances[i])
        }
    }
}

data class Node(val index: Int, val distance: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int = this.distance - other.distance
}
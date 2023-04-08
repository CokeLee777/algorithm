package shortestpath

import java.util.*
import kotlin.math.*

private const val INF = 1e9.toInt()

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val start = sc.nextInt()

    //최단거리 테이블 초기화
    val distances = IntArray(n + 1) { INF }
    //그래프 초기화
    val graph = mutableListOf<MutableList<City>>()
    for(i in 0..n){
        graph.add(mutableListOf())
    }
    //그래프 입력받기
    for(i in 0 until m){
        val x = sc.nextInt()
        val y = sc.nextInt()
        val z = sc.nextInt()

        graph[x].add(City(y, z))
    }

    fun dijkstra(start: Int){
        val pq = PriorityQueue<City>()
        //시작 노드 삽입 및 거리 0으로 초기화
        pq.offer(City(start, 0))
        distances[start] = 0
        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            val city = pq.poll()
            val now = city.index
            val distance = city.distance
            //이미 처리된 도시라면 무시
            if(distances[now] < distance) continue
            //아니라면 연결되어있는 도시들 탐색
            for(i in 0 until graph[now].size){
                val cost = distances[now] + graph[now][i].distance
                //더 거리가 짧다면 업데이트
                if(cost < distances[graph[now][i].index]){
                    distances[graph[now][i].index] = cost
                    pq.offer(City(graph[now][i].index, cost))
                }
            }
        }
    }

    dijkstra(start)

    val cityCount = distances.count { it != INF && it != 0 }
    val time = distances.maxBy { it != INF && it != 0 }

    println("$cityCount $time")
}

data class City(val index: Int, val distance: Int): Comparable<City> {
    override fun compareTo(other: City): Int  = this.distance - other.distance
}
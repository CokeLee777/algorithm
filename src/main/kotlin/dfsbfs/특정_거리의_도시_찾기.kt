package dfsbfs

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()    //도시의 개수
    val m = sc.nextInt()    //도로의 개수
    val k = sc.nextInt()    //거리 정보
    val x = sc.nextInt()    //출발 도시의 번호

    //최단거리 테이블 초기화
    val distances = IntArray(n + 1) { 1e9.toInt() }
    //그래프 초기화
    val graph = mutableListOf<MutableList<City>>()
    for(i in 0..n){
        graph.add(mutableListOf())
    }
    //그래프 입력받기
    for(i in 0 until m){
        val a = sc.nextInt()
        val b = sc.nextInt()

        graph[a].add(City(b, 1))
    }

    fun dijkstra(start: Int){
        val pq = PriorityQueue<City>()
        //시작 도시 큐에 삽입
        pq.offer(City(start, 0))
        distances[start] = 0
        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            val now = pq.poll()
            val cityNumber = now.number
            val distance = now.distance
            //이미 처리된 도시라면 무시
            if(distances[cityNumber] < distance) continue
            //현재 도시와 연결되어있는 도시 방문
            for(city in graph[cityNumber]){
                val cost = distance + city.distance
                //거리가 더 가깝다면
                if(cost < distances[city.number]){
                    pq.offer(City(city.number, cost))
                    distances[city.number] = cost
                }
            }
        }
    }
    //다익스트라 최단경로 알고리즘 수행
    dijkstra(x)

    if(distances.count{ it == k } == 0) {
        println(-1)
        return
    }

    for(i in distances.indices){
        if(distances[i] == k) println(i)
    }
}

data class City(val number: Int, val distance: Int): Comparable<City> {
    override fun compareTo(other: City): Int = this.distance - other.distance
}

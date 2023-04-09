package graph

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val v = sc.nextInt()
    val e = sc.nextInt()

    val graph = mutableListOf<MutableList<Int>>()
    val indegree = IntArray(v + 1)

    //그래프 초기화
    for(i in 0..v){
        graph.add(mutableListOf())
    }
    //방향 그래프의 모든 간선 정보 입력받기
    for(i in 0 until e){
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a].add(b)
        //전입차수 1 증가
        indegree[b] += 1
    }

    fun topologySort(){
        val results = arrayListOf<Int>()
        val queue: Queue<Int> = LinkedList()

        //처음 시작시 전입차수 0인 노드 삽입
        for(i in 1..v){
            if(indegree[i] == 0){
                queue.offer(i)
            }
        }

        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            val now = queue.poll()
            results.add(now)
            //해당 원소와 연결된 노드들의 전입차수 1 빼기
            for(node in graph[now]){
                indegree[node] -= 1
                //새롭게 전입차수가 0이 되는 노드들 큐에 삽입
                if(indegree[node] == 0){
                    queue.offer(node)
                }
            }
        }

        //결과 출력
        for (result in results) {
            print("$result ")
        }
    }

    topologySort()
}
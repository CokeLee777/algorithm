package dfsbfs

import java.util.LinkedList
import java.util.Queue

fun main(){
    val graph = arrayOf(
        intArrayOf(),
        intArrayOf(2,3,8),
        intArrayOf(1,7),
        intArrayOf(1,4,5),
        intArrayOf(3,5),
        intArrayOf(3,4),
        intArrayOf(7),
        intArrayOf(2,6,8),
        intArrayOf(1,7))

    val visited = BooleanArray(9)

    bfs(graph, 1, visited)
}

fun bfs(graph: Array<IntArray>, start: Int, visited: BooleanArray){
    val queue: Queue<Int> = LinkedList()
    //첫 노드를 방문처리 및 큐에 삽입
    visited[start] = true
    queue.add(start)
    //큐가 빌 때까지 반복
    while(!queue.isEmpty()){
        //큐에 값이 있다면 꺼낸다
        val now = queue.poll()
        print("$now ")
        //이 노드와 연결된 노드들을 큐에 삽입
        for(node in graph[now]){
            if(!visited[node]){
                queue.add(node)
                visited[node] = true
            }
        }
    }
}
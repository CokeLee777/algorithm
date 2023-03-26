package dfsbfs

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt(); val m = sc.nextInt()
    sc.nextLine()

    val graph = arrayListOf<ArrayList<Int>>()
    for(i in 0 until n){
        graph.add(arrayListOf())
        val readLine = sc.nextLine()
        for(j in 0 until m){
            graph[i].add(readLine[j].digitToInt())
        }
    }

    println(bfs(graph, Location(0, 0)))
}

val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
fun bfs(graph: ArrayList<ArrayList<Int>>, start: Location): Int {
    val queue: Queue<Location> = LinkedList()
    //시작위치 삽입
    queue.add(start)
    //큐가 빌때까지 반복
    while(!queue.isEmpty()){
        val now = queue.poll()
        for(direction in directions){
            val nx = now.x + direction.first
            val ny = now.y + direction.second
            //시작위치면 무시
            if(nx == 0 && ny == 0) continue
            //그래프를 벗어나면 무시
            if(nx < 0 || nx >= graph.size || ny < 0 || ny >= graph[0].size) continue
            //괴물이 사는 곳이거나 이미 들른 곳이면 무시
            if(graph[nx][ny] == 0 || graph[nx][ny] != 1) continue
            //처음가는 곳이라면 전진
            queue.add(Location(nx, ny))
            graph[nx][ny] = graph[now.x][now.y] + 1
        }
    }

    return graph[graph.size-1][graph[0].size-1]
}

data class Location(val x: Int, val y: Int)
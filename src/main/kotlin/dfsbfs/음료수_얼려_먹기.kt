package dfsbfs

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

var count = 0
val moves = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

fun main(){
    val sc = Scanner(System.`in`)
    //그래프 입력받기 및 방문처리 배열 초기화
    val n = sc.nextInt(); val m = sc.nextInt()
    val graph = arrayListOf<ArrayList<Int>>()
    val visited = arrayListOf<ArrayList<Boolean>>()
    sc.nextLine()
    for(i in 0 until n){
        graph.add(arrayListOf())
        visited.add(arrayListOf())
        val readLine = sc.nextLine()
        for(j in 0 until m){
            graph[i].add(readLine[j].digitToInt())
            visited[i].add(false)
        }
    }

    //탐색 시작
    for(i in 0 until n){
        for(j in 0 until m){
            if(!visited[i][j] && graph[i][j] == 0){
                bfs(graph, Point(i, j), visited)
                count += 1
            }
        }
    }

    println(count)
}

fun bfs(graph: ArrayList<ArrayList<Int>>, start: Point, visited: ArrayList<ArrayList<Boolean>>){
    val queue: Queue<Point> = LinkedList()
    //시작 위치 방문 처리 및 큐에 삽입
    visited[start.x][start.y] = true
    queue.add(start)
    //큐가 빌 때까지 반복
    while(!queue.isEmpty()){
        val now = queue.poll()
        for(move in moves){
            val dx = now.x + move.first
            val dy = now.y + move.second
            //그래프를 벗어나면 무시
            if(dx < 0 || dy < 0 || dx >= graph.size || dy >= graph[0].size) continue
            //아직 방문도 안했고 칸막이가 아니라면 방문
            if(graph[dx][dy] == 0 && !visited[dx][dy]){
                queue.add(Point(dx, dy))
                visited[dx][dy] = true
            }
        }
    }
}

data class Point(val x: Int, val y: Int)
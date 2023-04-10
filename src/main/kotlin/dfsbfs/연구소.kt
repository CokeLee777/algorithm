package dfsbfs

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    var maxSafetyZoneCount = 0
    val moves = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    val graph = mutableListOf<MutableList<Int>>()
    val tempGraph = mutableListOf<MutableList<Int>>()
    for(i in 0 until n) {
        graph.add(mutableListOf())
        tempGraph.add(mutableListOf())
        for (j in 0 until m) {
            graph[i].add(sc.nextInt())
            tempGraph[i].add(0)
        }
    }

    fun spreadVirus(x: Int, y: Int){
        for((dx, dy) in moves){
            val nx = x + dx
            val ny = y + dy

            //벽이거나 그래프 범위에 벗어나면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || tempGraph[nx][ny] == 1) continue
            //아무것도 없다면 이동
            if(tempGraph[nx][ny] == 0){
                tempGraph[nx][ny] = 2
                spreadVirus(nx, ny)
            }
        }
    }

    fun getSafetyZoneCount(): Int {
        var safetyZoneCount = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(tempGraph[i][j] == 0) safetyZoneCount += 1
            }
        }
        return safetyZoneCount
    }

    var wallCount = 0
    fun dfs(){
        //벽을 3개 세웠다면
        if(wallCount == 3){
            //일시적인 그래프에 복사
            for(i in 0 until n){
                for(j in 0 until m){
                    tempGraph[i][j] = graph[i][j]
                }
            }
            //바이러스 전파 수행
            for(i in 0 until n){
                for(j in 0 until m){
                    if(tempGraph[i][j] == 2){
                        spreadVirus(i, j)
                    }
                }
            }
            //최대값 구하기
            maxSafetyZoneCount = max(maxSafetyZoneCount, getSafetyZoneCount())
            return
        }

        for(i in 0 until n){
            for(j in 0 until m){
                if(graph[i][j] == 0){
                    graph[i][j] = 1
                    wallCount += 1
                    dfs()
                    graph[i][j] = 0
                    wallCount -= 1
                }
            }
        }
    }

    dfs()

    println(maxSafetyZoneCount)
}

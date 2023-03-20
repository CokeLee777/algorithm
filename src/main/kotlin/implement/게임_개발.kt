package implement

import java.util.Scanner
import kotlin.math.abs

var rotateCount = 0
var count = 1

fun main(){
    val sc = Scanner(System.`in`)
    //맵의 크기를 입력받음
    val n = sc.nextInt()
    val m = sc.nextInt()
    val map = mutableListOf<MutableList<Int>>()
    //캐릭터의 위치와 캐릭터가 바라보고 있는 방향을 입력받음
    var x = sc.nextInt()
    var y = sc.nextInt()
    var way = sc.nextInt()
    //맵을 입력받고, 방문 여부 테이블을 초기화
    val visited = mutableListOf<MutableList<Boolean>>()
    for(i in 0 until n){
        map.add(mutableListOf())
        visited.add(mutableListOf())
        for(j in 0 until m){
            map[i].add(sc.nextInt())
            visited[i].add(false)
        }
    }

    //첫 시작점 방문처리
    visited[x][y] = true
    val moves = listOf(Pair(-1,0), Pair(0,1), Pair(1,0), Pair(0,-1))
    while(true){
        //현재 방향을 기준으로 왼쪽 방향으로 회전
        way = rotateLeftWay(way)

        var nx = x + moves[way].first
        var ny = y + moves[way].second
        //가보지 않은 칸이 존재한다면 전진 후 1단계로 돌아감
        if(map[nx][ny] == 0 && !visited[nx][ny]){
            visited[nx][ny] = true
            x = nx
            y = ny
            count += 1
            rotateCount = 0
            continue
        }
        //이미 방문했던 칸이거나 바다인 경우 1단계로 돌아감
        else {
            rotateCount += 1
        }

        //4방향 모두 가본 칸이거나 바다로 되어있다면
        if(rotateCount == 4){
            nx = x - moves[way].first
            ny = y - moves[way].second
            //뒤로 갈 수 있다면 이동
            if(map[nx][ny] == 0) {
                x = nx
                y = ny
                rotateCount = 0
                continue
            }
            break
        }

    }

    println(count)
}

fun rotateLeftWay(way: Int): Int  = if(way - 1 >= 0) way - 1 else 3
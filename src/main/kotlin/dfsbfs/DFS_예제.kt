package dfsbfs

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

    dfs(graph, 1, visited)
}

fun dfs(graph: Array<IntArray>, now: Int, visited: BooleanArray){
    //현재 노드를 방문 처리
    visited[now] = true
    print("$now ")
    //현재 노드와 연결되어있는 노드들 탐색
    for(node in graph[now]){
        //방문하지 않았다면 탐색
        if(!visited[node]) dfs(graph, node, visited)
    }
}
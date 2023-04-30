package shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 화성_탐사 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> results = new ArrayList<>();
        for(int time = 0; time < t; time++){
            int n = sc.nextInt();       //탐사 공간의 크기
            int[][] graph = new int[n][n];   //탐사 공간
            //탐사 공간 입력받기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    graph[i][j] = sc.nextInt();
                }
            }

            //bfs 수행
            boolean[][] visited = new boolean[n][n];
            int result = bfs(graph, visited, n);
            results.add(result);
        }

        for(int result: results){
            System.out.println(result);
        }
    }

    public static int bfs(int[][] graph, boolean[][] visited, int n){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        //시작지점 입력받기
        pq.offer(new Point(0, 0, graph[0][0]));
        visited[0][0] = true;
        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            Point now = pq.poll();
            //네 방향 모두 방문
            for(int i = 0; i < 4; i++){
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                //그래프 범위를 벗어난다면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                //이미 가본곳이라면 무시
                if(visited[nx][ny])
                    continue;
                //아니라면 큐에 다음 칸 삽입
                graph[nx][ny] += graph[now.getX()][now.getY()];
                pq.offer(new Point(nx, ny, graph[nx][ny]));
                visited[nx][ny] = true;
                //목적지에 도달했다면 종료
                if(nx == n-1 && ny == n-1)
                    break;
            }
        }

        return graph[n-1][n-1];
    }
}

class Point implements Comparable<Point> {

    private int x;
    private int y;
    private int cost;

    public Point(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public int compareTo(Point other){
        return this.cost - other.cost;
    }
}

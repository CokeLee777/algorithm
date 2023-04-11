package shortestpath;

import java.util.*;

public class 미래_도시 {

    private static final int INF = (int)1e9;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //회사의 개수와 경로의 개수 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        //모든 최단경로 INF 로 초기화
        graph = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }
        //모든 경로 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //두 회사를 잇는 비용은 1, 양방향
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        //목적지와 경유지 입력받기
        int x = sc.nextInt();
        int y = sc.nextInt();

        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int minDistance = graph[1][y] + graph[y][x];
        if(minDistance >= INF) System.out.println(-1);
        else System.out.println(minDistance);
    }
}

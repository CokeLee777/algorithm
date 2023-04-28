package shortestpath;

import java.util.Scanner;

public class 플로이드 {

    private static final int INF = (int)1e9;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //도시의 개수
        int m = sc.nextInt();   //버스의 개수

        //그래프 초기화
        graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        //버스정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph[a][b] = Math.min(graph[a][b], cost);
        }

        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(graph[i][j] == INF) System.out.print("0 ");
                else System.out.print(String.format("%s ", graph[i][j]));
            }
            System.out.println();
        }
    }
}

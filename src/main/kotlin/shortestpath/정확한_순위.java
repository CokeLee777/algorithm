package shortestpath;

import java.util.Scanner;

public class 정확한_순위 {

    private static final int INF = (int)1e9;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //학생의 수
        int m = sc.nextInt();   //두 학생의 성적을 비교한 횟수

        // 그래프 초기화
        graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        // 그래프 정보 입력받기
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        // 플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++) {
            for(int a = 1; a <= n; a++) {
                for(int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 각 번호별로 모든 노드에 도달 가능한지 확인
        int possibleCorrectOrder = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != INF || graph[j][i] != INF) {
                    count++;
                }
            }
            // 만약 모두 도달 가능하다면 카운트 증가
            if(count == n) possibleCorrectOrder++;
        }

        System.out.println(possibleCorrectOrder);
    }
}

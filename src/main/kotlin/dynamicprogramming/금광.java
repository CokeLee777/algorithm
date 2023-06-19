package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 금광 {

    private static int[][] graph;
    private static int[][] dp;
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // 테스트 케이스의 수
        while(t-- > 0) {
            // 금광의 크기
            int n = sc.nextInt();
            int m = sc.nextInt();

            graph = new int[n][m];
            dp = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    graph[i][j] = sc.nextInt();
                    if(j == 0) dp[i][j] = graph[i][j];
                }
            }

            // 다이나믹 프로그래밍 수행
            for(int j = 1; j < m; j++) {
                for(int i = 0; i < n; i++) {
                    if(i == 0) dp[i][j] = graph[i][j] + Math.max(dp[i][j-1], dp[i+1][j-1]);
                    else if(i == n - 1) dp[i][j] = graph[i][j] + Math.max(dp[i][j-1], dp[i-1][j-1]);
                    else dp[i][j] = graph[i][j] + Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i+1][j-1]));
                }
            }

            // 마지막 열에서 가장 높은 수 결과값에 넣기
            int max = 0;
            for(int i = 0; i < n; i++) {
                if(dp[i][m-1] > max) max = dp[i][m-1];
            }

            results.add(max);
        }

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}

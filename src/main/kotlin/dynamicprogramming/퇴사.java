package dynamicprogramming;

import java.util.Scanner;

public class 퇴사 {

    private static int n;
    private static int[] time;
    private static int[] cost;
    private static int[] dp;
    private static int maxCost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 상담 일정 입력받기
        int n = sc.nextInt();
        time = new int[n];
        cost = new int[n];
        dp = new int[n+1];
        for(int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }

        // 거꾸로 확인
        for(int i = n - 1; i >= 0; i--) {
            int endTime = i + time[i];
            // 상담이 퇴사 전에 끝나는 경우
            if(endTime <= n) {
                // 최고 이익 계산
                dp[i] = Math.max(cost[i] + dp[endTime], maxCost);
                maxCost = dp[i];
            } else {
                dp[i] = maxCost;
            }
        }

        System.out.println(maxCost);
    }

}

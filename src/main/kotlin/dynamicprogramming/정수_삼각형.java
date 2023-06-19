package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 정수_삼각형 {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<List<Integer>> dp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 삼각형의 크기
        int n = sc.nextInt();
        sc.nextLine();

        // 그래프 초기화
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            dp.add(new ArrayList<>());
        }

        // 그래프에 원소 넣기
        for(int i = 0; i < n; i++) {
            String[] inputLine = sc.nextLine().split(" ");
            for (String s : inputLine) {
                int input = Integer.parseInt(s);
                graph.get(i).add(input);
                if(i == 0) dp.get(i).add(input);
            }
        }

        // 다이나믹 프로그래밍 수행
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < graph.get(i).size(); j++) {
                int max;
                if(j == 0) max = graph.get(i).get(j) + dp.get(i-1).get(j);
                else if(j == graph.get(i).size() - 1) max = graph.get(i).get(j) + dp.get(i-1).get(j-1);
                else max = graph.get(i).get(j) + Math.max(dp.get(i-1).get(j-1), dp.get(i-1).get(j));
                dp.get(i).add(max);
            }
        }

        int max = 0;
        for(int j = 0; j < dp.get(n-1).size(); j++) {
            if(dp.get(n-1).get(j) > max) max = dp.get(n-1).get(j);
        }

        System.out.println(max);
    }
}

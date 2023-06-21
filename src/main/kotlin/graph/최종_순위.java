package graph;

import java.util.*;

public class 최종_순위 {

    private static List<Integer> togologySort(List<Integer> teams, List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer teamNumber : teams) {
            // 전입차수가 0이면 큐에 넣기
            if (indegree[teamNumber] == 0) {
                queue.offer(teamNumber);
                // 현재 팀 번호와 상대 등수가 바뀐 팀 탐색
                for (Integer nextTeamNumber : graph.get(teamNumber)) {
                    indegree[nextTeamNumber] -= 1;
                    // 전입차수가 없다면 큐에 삽입
                    if (indegree[nextTeamNumber] == 0) {
                        queue.offer(nextTeamNumber);
                    }
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        while(!queue.isEmpty()) {
            results.add(queue.poll() + 1);
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스의 개수
        int t = sc.nextInt();
        List<List<Integer>> results = new ArrayList<>();
        while(t-- > 0) {
            // 팀의 수
            int n = sc.nextInt();
            // 등수에 따른 팀의 번호 입력받기
            List<Integer> teams = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                teams.add(sc.nextInt() - 1);
                graph.add(new ArrayList<>());
            }

            // 상대적인 등수가 바뀐 쌍의 수
            int numberOfPair = sc.nextInt();
            final int[] indegree = new int[n];
            for(int i = 0; i < numberOfPair; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                // a 가 b 보다 등수가 높다면
                if(teams.indexOf(a) < teams.indexOf(b)) {
                    graph.get(b).add(a);
                    indegree[a] += 1;
                }
                // 반대라면
                else {
                    graph.get(a).add(b);
                    indegree[b] += 1;
                }
            }

            // 위상 정렬 수행
            List<Integer> testResults = togologySort(teams, graph, indegree);
            if(testResults.size() != teams.size()) results.add(new ArrayList<>());
            else results.add(testResults);
        }

        for (List<Integer> result : results) {
            if(result.isEmpty()) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (Integer teamNumber : result) {
                    System.out.print(teamNumber + " ");
                }
            }
            System.out.println();
        }
    }
}

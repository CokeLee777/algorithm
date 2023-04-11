package graph;

import java.util.*;

public class 위상_정렬 {

    private static int[] indegree;
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        //전입차수가 0인 노드 삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌 때까지 반복
        List<Integer> results = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            results.add(now);
            //현재 노드에서 다음으로 가는 길 탐색해서 전입차수 1씩 제거
            for(int i = 0; i < graph.get(now).size(); i++){
                Integer next = graph.get(now).get(i);
                indegree[next] -= 1;
                //전입차수가 0이라면 큐에 삽입
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        for(Integer result: results){
            System.out.print(result + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //노드의 개수
        int m = sc.nextInt();   //간선의 개수

        //그래프 및 전입차수 배열 초기화
        indegree = new int[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        //간선 정보 입력받기
        for(int i = 0; i < m; i++){
            int prev = sc.nextInt();
            int sub = sc.nextInt();

            indegree[sub] += 1;
            graph.get(prev).add(sub);
        }

        topologySort();
    }
}

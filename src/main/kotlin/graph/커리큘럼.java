package graph;

import java.util.*;

public class 커리큘럼 {

    private static int[] indegree;
    private static int[] times;
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        //전입차수가 0인것들 큐에 삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌 때까지 반복
        int[] results = Arrays.copyOf(times, times.length);
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            //현재 강의를 들은 후 들을 수 있는 강의 탐색
            for(int i = 0; i < graph.get(now).size(); i++){
                Integer next = graph.get(now).get(i);
                //총 강의시간이 큰 것을 비교
                results[next] = Math.max(results[next], results[now] + times[next]);
                //전입차수 1빼기
                indegree[next] -= 1;
                //전입차수가 0이면 큐에 삽입
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i < results.length; i++){
            System.out.println(results[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //강의의 개수

        //전입차수 배열 및 그래프 초기화
        indegree = new int[n+1];
        times = new int[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        //간선 정보 입력받기
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String[] input = sc.nextLine().split(" ");
            int courseTime = Integer.parseInt(input[0]);
            for(int j = 1; j < input.length; j++){
                if(input[j].equals("-1")) break;
                int prev = Integer.parseInt(input[j]);
                graph.get(prev).add(i);
                indegree[i] += 1;
            }
            //현재 강의 시간 저장
            times[i] = courseTime;
        }

        topologySort();
    }
}

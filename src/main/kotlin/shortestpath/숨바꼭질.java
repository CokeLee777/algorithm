package shortestpath;

import java.util.*;

public class 숨바꼭질 {

    private static final int INF = (int)1e9;
    private static int[] distances;
    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //헛간의 개수
        int m = sc.nextInt();   //양방향 통로의 개수

        //최단거리 테이블 초기화
        distances = new int[n+1];
        for(int i = 1; i <= n; i++){
            distances[i] = INF;
        }

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        //그래프 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //그래프는 양방향으로 이동 가능
            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        //다익스트라 최단경로 알고리즘 수행
        dyikstra(1);

        //최단거리 테이블에서 최고 거리 탐색
        int indexOfMaxDistance = 0;
        int maxDistance = 0;
        int numberOfMaxDistance = 0;
        for(int i = 2; i <= n; i++){
            //거리가 짧거나 INF라면 무시
            if(distances[i] < maxDistance || distances[i] == INF)
                continue;
            //거리가 더 길다면 초기화
            if(distances[i] > maxDistance){
                maxDistance = distances[i];
                indexOfMaxDistance = i;
                numberOfMaxDistance = 1;
                continue;
            }
            //같다면 갯수 증가
            if(distances[i] == maxDistance){
                numberOfMaxDistance += 1;
            }
        }

        System.out.println(indexOfMaxDistance + " " + maxDistance + " " + numberOfMaxDistance);
    }

    public static void dyikstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distances[start] = 0;
        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();
            //이미 처리되었다면 무시
            if(distances[index] < distance)
                continue;
            //현재 노드와 연결된 노드 탐색
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = distance + graph.get(index).get(i).getDistance();
                //경유해서 가는 경로가 더 짧다면 업데이트
                if(cost < distances[graph.get(index).get(i).getIndex()]){
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                    distances[graph.get(index).get(i).getIndex()] = cost;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        private int index;
        private int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return this.index;
        }

        public int getDistance(){
            return this.distance;
        }

        @Override
        public int compareTo(Node other){
            return this.distance - other.distance;
        }
    }
}

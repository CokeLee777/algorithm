package shortestpath;

import java.util.*;
import java.math.*;

public class 개선된_다익스트라_알고리즘 {

    private static int[] distances;
    private static List<List<Node>> graph = new ArrayList<>();

    private static final int INF = (int)1e9;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작노드 삽입 및 최단거리 0으로 초기화
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();
            //이미 처리된 노드라면 무시
            if(distances[index] < distance) continue;
            //현재 노드와 연결된 노드 처리
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = distance + graph.get(index).get(i).getDistance();
                //더 저렴하다면 업데이트
                if(cost < distances[graph.get(index).get(i).getIndex()]){
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                    distances[graph.get(index).get(i).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 개수와 간선의 개수 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        //시작노드 입력받기
        int start = sc.nextInt();
        //최단거리 테이블 모두 무한대로 초기화
        distances = new int[n+1];
        for(int i = 0; i <= n; i++){
            distances[i] = INF;
        }

        //그래프 초기화 및 입력받기
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(a).add(new Node(b, distance));
        }
        //다익스트라 최단경로 알고리즘 수행
        dijkstra(start);

        for(int i = 1; i <= n; i++){
            if(distances[i] == INF) System.out.println("INFINITY");
            else System.out.println(distances[i]);
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

        //거리가 짧은 순서대로 정렬
        @Override
        public int compareTo(Node other){
            return this.distance - other.distance;
        }
    }
}

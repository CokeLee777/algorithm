package graph;

import java.util.*;

public class 크루스칼_알고리즘 {

    private static int[] parent;
    private static List<Edge> edges = new ArrayList<>();

    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();   //노드의 개수 입력받기
        int e = sc.nextInt();   //간선의 개수 입력받기

        //부모 테이블 초기화
        parent = new int[v+1];
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        //간선 정보 입력받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edge(a, b, cost));
        }
        //비용이 적은 순서대로 정렬
        Collections.sort(edges);

        //집합으로 묶기 수행
        int totalCost = 0;
        for(Edge edge: edges){
            int nodeA = edge.nodeA;
            int nodeB = edge.nodeB;
            int cost = edge.cost;
            //사이클이 발생하지 않았다면
            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                totalCost += cost;
            }
        }

        System.out.println(totalCost);
    }

    static class Edge implements Comparable<Edge> {

        private int nodeA;
        private int nodeB;
        private int cost;

        public Edge(int nodeA, int nodeB, int cost){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int getNodeA(){
            return this.nodeA;
        }

        public int getNodeB(){
            return this.nodeB;
        }

        public int getCost(){
            return this.cost;
        }

        @Override
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }
}

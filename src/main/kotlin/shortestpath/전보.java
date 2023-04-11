package shortestpath;

import java.util.*;

public class 전보 {

    private static final int INF = (int)1e9;
    private static int[] times;
    private static List<List<City>> graph = new ArrayList<>();

    public static void dijkstra(int start){
        PriorityQueue<City> pq = new PriorityQueue<>();
        //시작 도시 삽입 및 자기 자신으로 가는 비용 0으로 초기화
        pq.offer(new City(start, 0));
        times[start] = 0;

        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            City now = pq.poll();
            int number = now.getNumber();
            int time = now.getTime();
            //이미 처리된 도시라면 무시
            if(times[number] < time) continue;
            //현재 도시와 연결된 도시들 처리
            for(int i = 0; i < graph.get(number).size(); i++){
                int cost = time + graph.get(number).get(i).getTime();
                if(cost < times[graph.get(number).get(i).getNumber()]){
                    pq.offer(new City(graph.get(number).get(i).getNumber(), cost));
                    times[graph.get(number).get(i).getNumber()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //도시의 개수
        int m = sc.nextInt();   //통로의 개수
        int c = sc.nextInt();   //출발지

        //최단거리 테이블 초기화
        times = new int[n+1];
        for(int i = 0; i <= n; i++){
            times[i] = INF;
        }

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        //통로 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int time = sc.nextInt();

            graph.get(a).add(new City(b, time));
        }

        dijkstra(c);

        int receivedCityCount = 0;
        int totalReceivedTime = 0;
        for(int i = 1; i <= n; i++){
            if(times[i] < INF) {
                receivedCityCount += 1;
                totalReceivedTime = Math.max(totalReceivedTime, times[i]);
            }
        }

        System.out.println((receivedCityCount-1) + " " + totalReceivedTime);
    }

    static class City implements Comparable<City> {

        private int number;
        private int time;

        public City(int number, int time){
            this.number = number;
            this.time = time;
        }

        public int getNumber(){
            return this.number;
        }

        public int getTime(){
            return this.time;
        }

        @Override
        public int compareTo(City other){
            return this.time - other.time;
        }
    }
}

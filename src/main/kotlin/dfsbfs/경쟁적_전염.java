package dfsbfs;

import java.util.*;

public class 경쟁적_전염 {

    private static int[][] graph;
    private static PriorityQueue<Virus> pq = new PriorityQueue<>();

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static int bfs(int s, int x, int y){
        //큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            Virus now = pq.poll();
            //시간이 지났다면 종료
            if(now.time >= s) break;
            //네 방향 모두 바이러스 전파
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                //그래프 밖이라면 무시
                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph.length) continue;
                //빈칸이라면 바이러스 전파
                if(graph[nx][ny] == 0){
                    graph[nx][ny] = now.number;
                    pq.offer(new Virus(nx, ny, now.number, now.time+1));
                }
            }
        }

        return graph[x-1][y-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //시험관의 가로, 세로 크기
        int k = sc.nextInt();   //최대 바이러스의 번호

        //그래프 및 방문처리 배열 초기화
        graph = new int[n][n];

        //그래프 입력받기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int input = sc.nextInt();
                //첫 바이러스 우선순위 큐에 삽입
                if(input > 0) pq.offer(new Virus(i, j, input, 0));
                graph[i][j] = input;
            }
        }
        //s초 뒤의 x, y
        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int result = bfs(s, x, y);
        System.out.println(result);
    }

    static class Virus implements Comparable<Virus> {
        private int x;
        private int y;
        private int number;
        private int time;

        public Virus(int x, int y, int number, int time){
            this.x = x;
            this.y = y;
            this.number = number;
            this.time = time;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getNumber(){
            return this.number;
        }

        public int getTime(){
            return this.time;
        }

        @Override
        public int compareTo(Virus other){
            //시간 순서대로 정렬하고, 시간이 같으면 번호 순서대로 정렬
            if(this.time < other.time){
                return -1;
            } else if(this.time == other.time){
                return this.number - other.number;
            } else {
                return 1;
            }
        }
    }
}

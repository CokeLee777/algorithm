package greedy;

import java.util.*;

public class 무지의_먹방_라이브 {

    public int solution(int[] food_times, long k) {
        // 전체 음식을 다 먹는 시간 계산
        long totalEatTime = 0;
        for(int i = 0; i < food_times.length; i++) {
            totalEatTime += food_times[i];
        }

        // 전체 음식을 다 먹는 시간보다 k가 더 크다면
        if(totalEatTime <= k) return -1;

        // 큐에 모든 음식 삽입
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        // 큐에서 하나씩 꺼내면서 비교
        totalEatTime = 0;                       // 총 먹은 시간
        long numberOfFood = food_times.length;  // 남은 음식의 개수
        long previousEatTime = 0;               // 직전에 먹은 음식의 시간
        while(!pq.isEmpty() && totalEatTime + ((pq.peek().getEatTime() - previousEatTime) * numberOfFood) <= k) {
            int nowEatTime = pq.poll().getEatTime();
            totalEatTime += (nowEatTime - previousEatTime) * numberOfFood;
            numberOfFood -= 1;
            previousEatTime = nowEatTime;
        }

        List<Food> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }

        result.sort(Comparator.comparingInt(o -> o.index));

        return result.get((int) ((k - totalEatTime) % numberOfFood)).getIndex();
    }

    static class Food implements Comparable<Food> {

        private final int index;
        private final int eatTime;

        public Food(int index, int eatTime) {
            this.index = index;
            this.eatTime = eatTime;
        }

        public int getIndex() {
            return index;
        }

        public int getEatTime() {
            return eatTime;
        }

        @Override
        public int compareTo(Food o) {
            return this.eatTime - o.eatTime;
        }
    }
}

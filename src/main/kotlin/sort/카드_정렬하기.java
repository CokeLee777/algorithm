package sort;

import java.util.*;

public class 카드_정렬하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> cards = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int i = 0; i < n; i++) {
            cards.offer(sc.nextInt());
        }

        int comparingTime = 0;
        while(!cards.isEmpty()) {
            Integer first = cards.poll();
            if(cards.size() == 0) {
                System.out.println(comparingTime);
                break;
            }
            Integer second = cards.poll();
            comparingTime += (first + second);

            cards.offer(first + second);
        }

    }
}

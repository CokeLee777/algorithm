package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {

    private static int[] peopleOfStage;

    public static int[] solution(int N, int[] stages) {
        int people = stages.length;

        peopleOfStage = new int[N+1];
        for(int stage : stages) {
            if(stage > N) continue;
            peopleOfStage[stage] += 1;
        }

        List<Stage> temp = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            double failRatio = 0.0;
            if(people != 0) {
                failRatio = (double) peopleOfStage[i] / people;
            }
            temp.add(new Stage(i, failRatio));
            people -= peopleOfStage[i];
        }

        Collections.sort(temp);

        int[] results = new int[temp.size()];
        for(int i = 0; i < results.length; i++) {
            results[i] = temp.get(i).number;
        }

        return results;
    }

    static class Stage implements Comparable<Stage> {

        private final int number;
        private final double failRatio;

        public Stage(int number, double failRatio) {
            this.number = number;
            this.failRatio = failRatio;
        }

        @Override
        public int compareTo(Stage o) {
            if(this.failRatio > o.failRatio) {
                return -1;
            } else if(this.failRatio == o.failRatio) {
                return this.number - o.number;
            } else {
                return 1;
            }
        }
    }
}

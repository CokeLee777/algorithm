package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 국영수 {

    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n-- > 0) {
            String name = sc.next();
            int koreanScore = sc.nextInt();
            int englishScore = sc.nextInt();
            int mathScore = sc.nextInt();

            students.add(new Student(name, koreanScore, englishScore, mathScore));
        }

        Collections.sort(students);

        for(Student student : students) {
            System.out.println(student.getName());
        }
    }

    static class Student implements Comparable<Student> {

        private final String name;
        private final int koreanScore;
        private final int englishScore;
        private final int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if(this.koreanScore > o.koreanScore) {
                return -1;
            } else if(this.koreanScore == o.koreanScore) {
                if(this.englishScore < o.englishScore) {
                    return -1;
                } else if(this.englishScore == o.englishScore) {
                    if(this.mathScore > o.mathScore) {
                        return -1;
                    } else if(this.mathScore == o.mathScore) {
                        return this.name.compareTo(o.name);
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}

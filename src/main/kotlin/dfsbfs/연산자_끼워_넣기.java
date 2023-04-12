package dfsbfs;

import java.util.*;

public class 연산자_끼워_넣기 {

    private static int[] numbers;
    private static int add, sub, mul, div;
    private static int min = (int)1e9;
    private static int max = (int)-1e9;

    public static void calculate(int numberIndex, int totalCalcNumber){

        if(numberIndex == numbers.length){
            max = Math.max(max, totalCalcNumber);
            min = Math.min(min, totalCalcNumber);
        } else {
            //각 연산에 대해서 dfs 수행
            if(add > 0){
                add -= 1;
                calculate(numberIndex + 1, totalCalcNumber + numbers[numberIndex]);
                add += 1;
            }

            if(sub > 0){
                sub -= 1;
                calculate(numberIndex + 1, totalCalcNumber - numbers[numberIndex]);
                sub += 1;
            }

            if(mul > 0){
                mul -= 1;
                calculate(numberIndex + 1, totalCalcNumber * numbers[numberIndex]);
                mul += 1;
            }

            if(div > 0){
                div -= 1;
                calculate(numberIndex + 1, totalCalcNumber / numbers[numberIndex]);
                div += 1;
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //숫자의 개수

        //숫자 입력받기
        numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        //연산자의 수 입력받기
        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        calculate(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }
}

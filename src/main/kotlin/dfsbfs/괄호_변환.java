package dfsbfs;

import java.util.*;

public class 괄호_변환 {

    public static String toCorrectParentheses(String s){
        int open = 0;
        int close = 0;
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if(now == '(') open++;
            if(now == ')') close++;
            //균형잡힌 괄호 문자열이라면
            if(open == close) {
                String u = s.substring(0, i+1);
                String v = s.substring(i + 1);
                //올바른 괄호 문자열이라면
                if (now == ')') return u + toCorrectParentheses(v);
                //아니라면
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(toCorrectParentheses(v)).append(")");

                for (int j = 1; j < u.length() - 1; j++) {
                    if (u.charAt(j) == '(') sb.append(')');
                    else if (u.charAt(j) == ')') sb.append('(');
                }

                return sb.toString();
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String result = toCorrectParentheses(s);
        System.out.println(result);
    }
}

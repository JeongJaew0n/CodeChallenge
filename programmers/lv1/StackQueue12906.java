package programmers.lv1;

import java.util.*;

public class StackQueue12906 {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public static int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        Arrays.stream(arr).forEach(num -> {
            if(stack.isEmpty()) {
                stack.add(num);
                return;
            }
            if (stack.peek() != num) {
                stack.add(num);
                }
            }
        );

        answer = stack.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}

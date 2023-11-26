package programmers.lv2.p70129;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("0101");
    }
    public int[] solution(String s) {
        // length, Integer[몇회, 0개수]
        HashMap<Integer, int[]> visitedMap = new HashMap<>();

        int countOfZero = 0;
        int length = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 0) {
                countOfZero++;
            } else {
                length++;
            }
        }

        int[] answer = {1,countOfZero};
        System.out.println(answer);

        answer = changeBinary(length, answer);

        return answer;
    }

    int[] changeBinary(int length, int[] counts) {

        if(length == 1) {
            return counts;
        }

        String s = Integer.toBinaryString(length);

        int countOfZero = 0;
        int nextLength = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                countOfZero++;
            } else {
                nextLength++;
            }
        }

        counts[0]++;
        counts[1] += countOfZero;
        System.out.println(Arrays.toString(counts));

        return changeBinary(nextLength, counts);

        // 1. String 이 들어온다.
        // 2. 거기서 0을 없앤다.
        // 3. 길이를 2진수로 변환한다. (String으로 변환)
        // 4. String 을 다시 넣는다.
    }

}

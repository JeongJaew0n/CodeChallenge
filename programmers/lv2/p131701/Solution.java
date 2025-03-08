package programmers.lv2.p131701;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class Solution {
    public int solution(int[] elements) {
        Set<Integer> resultSet = new HashSet<>();

        int len = elements.length;

        for (int i = 1; i <= len; i++) {
            for (int k = 0; k < len; k++) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += elements[(k + j)%len];
                }
                resultSet.add(sum);
            }
        }

        return resultSet.size();
    }

    /**
     * wangjh789@gmail.com
     *
     * @param elements
     * @return
     */
    public int goodSolution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for(int len = 1;len <= elements.length; len++){
            for(int i = 0;i<elements.length;i++){
                dp[i] += elements[(len+i-1)%elements.length];
                set.add(dp[i]);
            }
        }
        return set.size();
    }

    /**
     * C++ 에서 발견한 좋은 풀이.
     */
    public int goodSolutionOfCpp(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;

        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = i; j < i + len; j++) {
                sum += elements[j%len];
                set.add(sum);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{7,9,1,1,4});
        System.out.println(answer);
    }
}

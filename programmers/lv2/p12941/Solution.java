package programmers.lv2.p12941;

import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int[] sortedA = Arrays.stream(A).sorted().toArray();
        int[] sortedB = Arrays.stream(B).sorted().toArray();

        for(int i=0; i<A.length; i++) {
            answer += sortedA[i] * sortedB[A.length-i-1];
        }

        return answer;
    }
}
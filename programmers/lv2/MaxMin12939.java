package programmers.lv2;

import java.util.Arrays;
import java.util.stream.Collector;

public class MaxMin12939 {
    public String solution(String s) {

        int[] number = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = number[0];
        int max = number[0];
        for(int n : number) {
            if(n < min) {
                min = n;
            }
            if(n > max) {
                max = n;
            }
        }

        String answer = min + " " + max;

        return answer;
    }
}

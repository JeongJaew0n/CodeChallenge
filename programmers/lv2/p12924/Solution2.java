package programmers.lv2.p12924;

public class Solution2 {
    public int solution(int n) {
        int answer = 1;

        int sum = 0;
        for(int outer=1; outer<n; outer++) {
            sum = 0;
            for(int i=outer; i<n; i++) {
                sum += i;
                if(sum == n) {
                    answer++;
                }
                if(sum > n) {
                    break;
                }
            }
        }

        return answer;
    }
}

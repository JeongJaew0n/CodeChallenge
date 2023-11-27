package programmers.lv2.p12945;

public class Solution {
    public int solution(int n) {
        //n은 2 이상.

        int preNumber = 1;
        int number = 1;
        int temp = 0;
        for(int i=2; i<n; i++) {
            if( n < 200) {
                temp = number;
                number = number + preNumber;
                preNumber = temp;
            } else {
                temp = number % 1234567;
                number = (number + preNumber) % 1234567;
                preNumber = temp;
            }
        }

        return number % 1234567;
    }
}

package programmers.lv2.p12911;

public class Solution {
    public int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        int numberOfOne = 0;

        for(int i=0; i<binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1') {
                numberOfOne++;
            }
        }

        int count = 1;
        int numberOfNextOne = 0;
        String nextBinaryString;
        while(true) {
            numberOfNextOne = 0;

            nextBinaryString = Integer.toBinaryString(count + n);
            for(int i=0; i<nextBinaryString.length(); i++) {
                if(nextBinaryString.charAt(i) == '1') {
                    numberOfNextOne++;
                }
            }
            if(numberOfNextOne == numberOfOne) {
                return count + n;
            }
            count++;
        }
    }
}

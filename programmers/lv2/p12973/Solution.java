package programmers.lv2.p12973;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = solution.solution("xbaabaax");
        System.out.println(k);
    }
    public int solution(String s)
    {
        if(s.length() % 2 == 1) {
            return 0;
        }

        char[] string = s.toCharArray();

        int prev = 0;
        int count = 1;
        for(int i=1; i<string.length; i++) {
            if(string[i] != '\0') {
                if(string[i] == string[prev]) {
                    string[i] = '\0';
                    string[prev] = '\0';
                    prev = 0;
                    i=0;
                    count = 1;
                } else {
                    prev = i;
                    count = 0;
                }
            }
        }

        return count;
    }
}

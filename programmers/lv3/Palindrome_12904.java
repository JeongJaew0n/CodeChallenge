package programmers.lv3;

import java.util.AbstractMap;

public class Palindrome_12904 {

    public static void main(String[] args) {

        solution("abcdcba");
    }

    public static int solution(String s)
    {
        int answer = 1;

        if(s.length() == 1) {
            return 1;
        }

        for (int i=0; i<s.length(); i++) {
            for(int j=s.length(); j>i+1; j--) {
                if(j-i > answer) {
                    String sub = s.substring(i,j);

                    boolean check = true;
                    for(int ci=0; ci<sub.length()/2; ci++) {
                        // 길이가 5면 -> 1까지만 돌아도됨 abcba 라면 a,b 까지만 돌려도 끝임.
                        // 길이가 6면 -> 2까지만 돌아도됨. abccba 라면 a,b,c 까지만..
                        if(sub.charAt(ci) != sub.charAt(sub.length()-ci-1)) {
                            check = false;
                            break;
                        }
                    }
                    if(check) {
                        answer = sub.length();
                    }
                }
            }
        }

        return answer;
    }
}

package programmers.lv2.p12909;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // 여는 괄호는 언제든시 써도 되지만 닫힌 괄호는 열린 상황에서만 써야 한다.
        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }

        int openCount = 0;
        for(int i=0; i<s.length(); i++) {
            if(openCount < 0) {
                return false;
            }
            if(s.charAt(i) == '(') {
                openCount++;
            } else {
                openCount--;
            }
        }

        return openCount == 0;
    }
}

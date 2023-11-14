package programmers.lv2;

import java.util.Arrays;

/**
 * 제한 조건
 * 공백문자가 연속해서 나오지 않는다.
 *
 * 1. String의 for문을 돈다.
 * 2. 처음으로 만난 문자가 문자가 아스키 코드 65~90 인지 확인해서 맞으면 그대로 통과.
 * 3. 처음으로 만난 문자가 97~122 면 -32를 해주고 반환.
 * 4. String은 불변이니까 char[] 로 만들어 줘야함.
 */

public class JadenCase_12951 {

    public static void main(String[] args) {
        JadenCase_12951 test = new JadenCase_12951();

        System.out.println(test.solution(" h e l o o o o"));
    }

    public String solution(String s) {

        char[] charArr = s.toCharArray();

        boolean space = true;

        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] == 32) {
                space = true;
                continue;
            }
            if(!space) {
                if(65 <= charArr[i] && charArr[i] <= 90){
                    charArr[i] = (char)(charArr[i]+32);
                }
            } else {
                space = false;
                if(97 <= charArr[i] && charArr[i] <= 122) {
                    charArr[i] = (char)(charArr[i]-32);
                }
            }
        }
        return String.valueOf(charArr);
    }
}

package programmers.lv2.p60058;

public class Solution {
    public String solution(String p) {
        return Solution.recursive(p);
    }

    private static String recursive(String p) {
        if (p.isEmpty()) return "";

        StringBuilder uBuilder = new StringBuilder();

        // u 의 규형 맞추기 + 올바른 문자열 판별.
        int count = 0;
        boolean isBalanced = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
            }

            if (count < 0) {
                isBalanced = false;
            }

            uBuilder.append(p.charAt(i));
            if (count == 0) {
                break;
            }
        }
        String u = uBuilder.toString();
        String v = p.substring(u.length());

        if (isBalanced) {
            return u + Solution.recursive(v);
        } else {
            return Solution.change(u, Solution.recursive(v));
        }
    }

    private static String change(String u, String v) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("(");
        stringBuilder.append(v);
        stringBuilder.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }

        return stringBuilder.toString();
    }
}

// 에러 케이스: '더 이상 분리할 수 없어야 한다'

// 1일차. 문제 이해에 23분. 7분 고민.
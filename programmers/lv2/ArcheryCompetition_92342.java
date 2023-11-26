package programmers.lv2;

import java.util.HashSet;

/**
 * 2022 카카오 문제
 * 양궁대회
 */


public class ArcheryCompetition_92342 {

    private static int[] apeachInfo;
    private static int[] answer;
    private static int bestGap = -1;

    public static void main(String[] args) {
        solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0});
    }

    private static int[] solution(int n, int[] info) {
        search(n, new int[11]);

        if(bestGap != -1) {
            return answer;
        }
        return new int[]{-1};
    }

    /*
    1. 언제 종료되어야 하지?: n이 0이면 종료되어야한다.
    2. 어떤 값을 반환해야하지?
    3. 라이언의 화살 정보를 재귀로 찾아나가야한다.
     */
    private static void search(int n, int[] ryanInfo) {
        if(n == 0) {
            calcScore(ryanInfo);
            return;
        }

        for (int i = 0; i < ryanInfo.length; i++) {
            if(ryanInfo[i] > apeachInfo[i]) {
                break;
            }
            ryanInfo[i]++;
            search(n-1, ryanInfo);
            ryanInfo[i]--;

        }
    }

    private static void calcScore(int[] info) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < info.length; i++) {
            if(info[i] == 0 && apeachInfo[i] == 0) {
                continue;
            }
            if(info[i] > apeachInfo[i]) {
                ryanScore += 10-i;
            } else {
                apeachScore += 10-i;
            }
        }

        int gap = ryanScore-apeachScore;
        if(gap >= bestGap) {
            bestGap = gap;
            answer = info.clone();
        }
    }
}
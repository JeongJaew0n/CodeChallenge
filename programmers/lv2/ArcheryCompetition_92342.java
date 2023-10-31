package programmers.lv2;

import java.util.Arrays;

/**
 * 2022 카카오 문제
 * 양궁대회
 */


public class ArcheryCompetition_92342 {

    public static void main(String[] args) {
//        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});

          test(2, new int[]{1,2,3});
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {-1};

        int[] ryanInfo = new int[info.length];

        int apeachScore,ryanScore, restArrow;

        int bestGap = 0;

        for(int out = 0; out < info.length; out++) {
            restArrow = n;
            ryanScore = 0;
            apeachScore = 0;
            Arrays.fill(ryanInfo, 0);
            for(int a=0; a<out; a++) {
                if(info[a] > 0) {
                    apeachScore += 10 - a;
                }
            }
            for (int i = out; i < info.length; i++) {
                // 조건 2
                if (i == info.length - 1) {
                    ryanInfo[i] += restArrow;
                    restArrow = 0;
                }
                // 조건 0
                if (restArrow == 0) {
                    for(int k = i; k<info.length; k++) {
                        if(info[i] > 0) {
                            apeachScore += 10 - k;
                        }
                    }
                    if(ryanScore - apeachScore >= bestGap) {
                        bestGap = ryanScore - apeachScore;
                        answer = ryanInfo.clone();
                    }
                    break;
                }
                //조건 1
                if (ryanInfo[i] + restArrow > info[i]) {
                    int goal = info[i] + 1;
                    restArrow -= (goal - ryanInfo[i]);
                    ryanInfo[i] = goal;
                    ryanScore += 10 - i;
                } else if(info[i] > 0) {
                    apeachScore += 10 - i;
                }
            }
        }

        return answer;
    }

    public static void test(int n, int[] info) {

        int rest = n;
        int[] test = new int[info.length];
        for(int out=0; out<info.length; out++) {
            Arrays.fill(test,0);
            for(int i = out; i<info.length; i++) {
                if(rest!=0) {
                    test[i] += 1;
                    rest--;
                    printer(test);

                    test[i] -= 2;
                    rest += 2;
                }
            }
        }
    }
    public static void printer(int[] info) {
        for(int j=0; j<info.length; j++) {
            System.out.print(info[j] + " ");
        }
        System.out.println();
    }
}

/* n번 쏴서 라이언이 최대 점수차로 이기는걸 구하는데 그 중에서도 낮은 점수를 제일 많이 쏜.
 * n을 구한다. 총합: 5 그리고 총 점수를 구한다...
 * 근데 모든 경우를 구해보고 만드는 과정 중에 종료 조건을 하나씩 추가 해간다.
 * 문제: 1 0 0 4
 * 정답: 2 1 1 1
 *
 * 모든 조합을 구해볼려면 어떻게 해야할까??
 * 1 0 0 0 남은 화살: 4
 * 2 0 0 0 남은 화살: 3
 * 2 1 0 0 남은 화살: 2
 * 2 1 1 0 남은 화살: 1
 * 2 1 1 1 남은 화살: 0
 * 여기서
 * 조건 0. 남은 화살 0이 되면 정상 종료. 점수차이가 최대 점수차이보다 큰지 구한다.
 * 조건 1. 해당 index에서 라이언이 더 많이 쐈으면 다음 index로 넘어간다.
 * 조건 2. 마지막 index에서 모두 쓴다.
 * * 여기서 높은 점수(제일 앞 index)를 쐈을 경우 이기지 않으면 쏘는 의미가 없기 때문에 밑에는 젤 앞이 0인 것.
 * 0 1 0 0 남은 화살: 4
 * 0 1 1 0 남은 화살: 3
 * 0 1 1 3 남은 화살: 0
 * 조건 3. 마지막 index에서 모두 쏜다!
 */

        /*
         1. 어피치와 라이언의 점수는 해당 반복문에서 들고 있다가 다음 반복때는 없어져야 겠다.
         */

//    private static int[] apeachInfo;
//    private static int[] answer;
//    private static int bestGap = -1;
//
//    public static void main(String[] args) {
//        solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0});
//    }
//    private static int[] solution(int n, int[] info) {
//
//        apeachInfo = info;
//
//        search(n, new int[11]);
//
//        if(bestGap != -1) {
//            return answer;
//        }
//        return new int[]{-1};
//    }
//
//    /*
//    1. 언제 종료되어야 하지?: n이 0이면 종료되어야한다.
//    2. 어떤 값을 반환해야하지?
//    3. 라이언의 화살 정보를 재귀로 찾아나가야한다.
//     */
//    private static void search(int n, int[] ryanInfo) {
//        if(n == 0) {
//            calcScore(ryanInfo);
//            return;
//        }
//
//        for (int i = 0; i < ryanInfo.length; i++) {
//            if(ryanInfo[i] > apeachInfo[i]) {
//                break;
//            }
//            ryanInfo[i]++;
//            search(n-1, ryanInfo);
//            ryanInfo[i]--;
//
//        }
//    }
//
//    private static void calcScore(int[] info) {
//        int apeachScore = 0;
//        int ryanScore = 0;
//
//        for (int i = 0; i < info.length; i++) {
//            if(info[i] == 0 && apeachInfo[i] == 0) {
//                continue;
//            }
//            if(info[i] > apeachInfo[i]) {
//                ryanScore += 10-i;
//            } else {
//                apeachScore += 10-i;
//            }
//        }
//
//        int gap = ryanScore-apeachScore;
//        if(gap > bestGap) {
//            bestGap = gap;
//            answer = info.clone();
//        }
//    }
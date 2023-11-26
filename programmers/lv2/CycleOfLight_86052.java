package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class CycleOfLight_86052 {

    private static int L = 1;
    private static int S = 2;
    private static int R = 4;


//    // LRUD
//    private static int L_LIGHT = 0;
//    private static int R_LIGHT = 1;
//    private static int U_LIGHT = 2;
//    private static int D_LIGHT = 3;

    // LRUD
    private static int L_OUT = 0;
    private static int R_OUT = 1;
    private static int U_OUT = 2;
    private static int D_OUT = 4;

    public static void main(String[] args) {
        CycleOfLight_86052 C = new CycleOfLight_86052();
        C.solution(new String[]{"SL","LR"});
    }

    public int[] solution(String[] grid) {
        /*
         * 문자열 파싱해서
         * 최소 1개, 최대 25만개... 객체생성은 안될듯...
         * 그럼 역시 숫자로 표현하자.
         * */
        int[] answer = {};

        /*
        1. 문자열 파싱 후 배열 생성
        2. 모든 문자열의 길이는 같다.
        3. 빛의 방향도 넣어줘야 한다.
        4. 빛의 방향과 함께 계산.
         */

        // 0 = none
        // 1 = L
        // 2 = S
        // 4 = R

        /* 빛의 방향
        * 오른쪽 1 왼쪽 2 위 4 아래 8
        */

        // 종료 조건? 새로 출발 할려 했는데 이미 방문한 노드일 경우!
        int y = grid.length;
        int x = grid[0].length();

        int[][] intGrid = new int[y][x];
        int[][] visited = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i].charAt(j) == 'L') {
                    intGrid[i][j] = L;
                } else if (grid[i].charAt(j) == 'S') {
                    intGrid[i][j] = S;
                } else if (grid[i].charAt(j) == 'R') {
                    intGrid[i][j] = R;
                }
            }
        }

        int start = start(0, 0, intGrid, visited);

        System.out.println(start);

        // start -> if...
        return answer;
    }

    public int start(int x, int y, int[][] grid, int[][] visited) {
        return go(x, y+1, D_OUT, grid, visited, 0);
    }

    // visited가 중요하네..
    // visited 가 상태를 가져야함. 이미 오른쪽으로 나간 기록을 가지고 있는데 또 오른쪽으로 나가야 하면 끝남.
        public int go(int x, int y, int inLightDirection, int[][] grid, int[][] visited,int pathCnt) {
        int outLightDirection = 0;

        // 매개변수로 들어온 방향은 이전 노드가 내보낸 방향이므로 현재 노드에서는 반대. L->R U->D
        // 들어온 방향과 노드 종류에 따라 나갈 방향 결정.
        if(inLightDirection == R_OUT) {
            if(grid[y][x] == L) {
                outLightDirection = U_OUT;
            } else if(grid[y][x] == R) {
                outLightDirection = D_OUT;
            } else {
                outLightDirection = R_OUT;
            }
        } else if(inLightDirection == L_OUT) {
            if(grid[y][x] == L) {
                outLightDirection = D_OUT;
            } else if(grid[y][x] == R) {
                outLightDirection = U_OUT;
            } else {
                outLightDirection = L_OUT;
            }
        } else if(inLightDirection == D_OUT) {
            if(grid[y][x] == L) {
                outLightDirection = R_OUT;
            } else if(grid[y][x] == R) {
                outLightDirection = L_OUT;
            } else {
                outLightDirection = D_OUT;
            }
        } else if(inLightDirection == U_OUT) {
            if(grid[y][x] == L) {
                outLightDirection = L_OUT;
            } else if(grid[y][x] == R) {
                outLightDirection = R_OUT;
            } else {
                outLightDirection = U_OUT;
            }
        }

        // 이미 해당 방향으로 빛이 나간적 있다면 종료.
        if((visited[y][x] >> outLightDirection & 1) == 1) {
            return pathCnt;
        }

        // 나간 방향 기록.
        visited[y][x] += outLightDirection;
        pathCnt++;

        if(outLightDirection == L_OUT) {
            int dx = x-1;
            if(dx < 0) {
                dx = grid[0].length - 1;
            }
            return go(dx,y,L_OUT, grid, visited, pathCnt);
        } else if(outLightDirection == R_OUT) {
            int dx = x+1;
            if(dx == grid[0].length) {
                dx = 0;
            }
            return go(dx,y,R_OUT, grid, visited, pathCnt);
        } else if(outLightDirection == U_OUT) {
            int dy = y-1;
            if(dy == -1) {
                dy = grid.length - 1;
            }
            return go(x,dy,U_OUT, grid, visited, pathCnt);
        } else {
            int dy = y+1;
            if(dy == grid.length) {
                dy = 0;
            }
            return go(x,dy,D_OUT, grid, visited, pathCnt);
        }
    }
}

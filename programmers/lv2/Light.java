package programmers.lv2;

import java.util.*;

public class Light {

    public int[] solution(String[] grid) {
        int[] answer = {};

        /*
         1. 빛의 경로가 지나간 정보를 기록.
            방향 -> L R U D , 인 아웃
            1. 어느 노드에서 나갔는가? 2. 어느 방향으로 나갔는가?
                0
              3   1
                2
            x,y좌표 아래다. 그러면 2를 주는겁니다. 들어온 방향에서 바꿔줘야 합니다. 얘 입장에서보면 들어온 방향입니다.
            0이면 위로간거죠? 0이 들어왔을 경우 (x+2) % 4를 해줍니다.
         2. 해당 경로가 똑같은게 있을 경우 종료.
         3. 경로 개수 반환.
         4. 한번 다 돌아보고, 첫 원소 기준으로 다른 방향으로 쏴 봤을 때, 그게 만약 없는 방향이라면 또 하나 더생기는거고.
         */
        int y = grid.length;
        int x = grid[0].length();

        HashSet hashSet = new HashSet();



        return answer;
    }
}

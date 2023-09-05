package programmers.lv1;

public class ExhaustiveSearch86491 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int widthMax = 0;
        int heightMax = 0;

        for(int[] size: sizes) {
            if(size[1] > size[0]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }

            if(size[0] > widthMax) {
                widthMax = size[0];
            }
            if(size[1] > heightMax) {
                heightMax = size[1];
            }
        }

        answer = widthMax * heightMax;

        return answer;
    }
}

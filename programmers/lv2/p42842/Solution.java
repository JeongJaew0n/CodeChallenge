package programmers.lv2.p42842;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3004, 2996);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int row = yellow, col = 1;
        while (true) {
            int x = (row + 2) * 2 + col * 2;
            if (brown == x) {
                answer[0] = row + 2;
                answer[1] = col + 2;
                return answer;
            }
            do {
                col++;
                row = yellow / col;
            } while (yellow % col != 0);

            if (col > row) {
                break;
            }
        }
        return answer;
    }
}
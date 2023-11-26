package programmers.lv2.p12924;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(0));

    }
    public int solution(int n) {
        int answer = 1;

        int addedThing;

        int i= (n/2);

        for(;i<n; i++) {
            addedThing = 0;
            for(int j=i; j<n; j++) {
                addedThing += n-j;
                if(addedThing == n) {
                    answer++;
                    break;
                }
                if(addedThing > n) {
                    break;
                }
            }
        }

        return answer;
    }
}
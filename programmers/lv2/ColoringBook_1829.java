package programmers.lv2;

public class ColoringBook_1829 {
    // m = y, n = x

    private static int[][] bigPicture;
    private static int sizeOfTheArea = 0;
    private static int maxSizeOfArea = 0;
    private static int countOfArea = 0;

    public int[] solution(int m, int n, int[][] picture) {

        boolean[][] visited = new boolean[m][n];

        bigPicture = picture;

        return null;
    }

    private static void search(int y, int x, boolean[][] visited) {
        for(int i=0; i < visited.length; i++) {
            search(bigPicture[i][x], i, x+i, visited);
        }
    }

    private static void search(int number, int y, int x, boolean[][] visited) {
        if(visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        if(number == 0) {
            return;
        }
    }
}

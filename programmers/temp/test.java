package programmers.temp;

import java.util.Objects;

public class test {

    public static class Point {
        int x;
        int y;

        public Point() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {

        Point point = new Point();
        System.out.println(point.hashCode());

    }

}


package programmers.lv2.p12911;

public class CrazySolutions {
    class TryHelloWorld {
        public int nextBigNumber(int n) {
            int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
            return n + postPattern | smallPattern;
        }
    }

}

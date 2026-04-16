public class RecursionTwo {

    public static int countBinaryZeroes(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }

        int bit = n % 2;
        if (bit == 0) {
            return 1 + countBinaryZeroes(n / 2);
        } else {
            return countBinaryZeroes(n / 2);
        }
    }

    public static void main(String[] args) {
    }
}

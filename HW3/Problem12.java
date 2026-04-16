public class Problem12 {

    public static void generateParenthesis(int n, int open, int close, char[] current, int pos) {
        if (pos == 2 * n) {
            System.out.println(new String(current));
            return;
        }
        if (open < n) {
            current[pos] = '(';
            generateParenthesis(n, open + 1, close, current, pos + 1);
        }
        if (close < open) {
            current[pos] = ')';
            generateParenthesis(n, open, close + 1, current, pos + 1);
        }
    }
}

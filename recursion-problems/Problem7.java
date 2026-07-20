public class Problem7 {

    public static String reverseString(String s) {
        if (s.length() <= 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}

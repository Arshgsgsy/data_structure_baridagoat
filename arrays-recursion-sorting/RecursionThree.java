public class RecursionThree {

    public static boolean isPalindrome(String word) {
        String cleaned = removePunctuation(word).toLowerCase();
        return checkPalindrome(cleaned, 0, cleaned.length() - 1);
    }

    public static boolean checkPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return checkPalindrome(s, left + 1, right - 1);
    }

    public static String removePunctuation(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}

public class ExerciseOne {

    public static int isReversed(String s1, String s2) {
        String a = removeSpaces(s1).toLowerCase();
        String b = removeSpaces(s2).toLowerCase();

        if (a.length() != b.length()) {
            return 0;
        }

        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(len - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

    public static String removeSpaces(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}

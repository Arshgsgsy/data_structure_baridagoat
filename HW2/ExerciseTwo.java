public class ExerciseTwo {

    public static String[] shortestOfThree(String[] words) {
        int resultSize = words.length / 3;
        String[] result = new String[resultSize];

        for (int i = 0; i < words.length; i += 3) {
            String shortest = words[i];
            if (words[i + 1].length() < shortest.length()) {
                shortest = words[i + 1];
            }
            if (words[i + 2].length() < shortest.length()) {
                shortest = words[i + 2];
            }
            result[i / 3] = shortest;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}

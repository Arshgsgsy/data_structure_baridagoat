public class Problem3 {

    public static boolean wordBreak(String s, String[] wordDict, int dictIndex) {
        if (s.length() == 0) return true;
        if (dictIndex >= wordDict.length) return false;
        if (s.startsWith(wordDict[dictIndex])) {
            if (wordBreak(s.substring(wordDict[dictIndex].length()), wordDict, 0)) return true;
        }
        return wordBreak(s, wordDict, dictIndex + 1);
    }
}

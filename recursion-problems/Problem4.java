public class Problem4 {

    public static int findFirstIndex(int[] arr, int x, int index) {
        if (index >= arr.length) return -1;
        if (arr[index] == x) return index;
        return findFirstIndex(arr, x, index + 1);
    }
}

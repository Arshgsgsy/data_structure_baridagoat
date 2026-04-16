public class Problem6 {

    public static int findMissing(int[] arr, int n, int index) {
        if (index >= arr.length) return n * (n + 1) / 2;
        return findMissing(arr, n, index + 1) - arr[index];
    }
}

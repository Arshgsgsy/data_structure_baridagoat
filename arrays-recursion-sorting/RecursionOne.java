public class RecursionOne {

    public static int findMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;
        int maxLeft = findMax(arr, left, mid);
        int maxRight = findMax(arr, mid + 1, right);

        if (maxLeft > maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    public static void main(String[] args) {
    }
}

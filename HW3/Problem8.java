public class Problem8 {

    public static void printArray(int[] arr, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void permute(int[] nums, boolean[] used, int[] current, int depth, int i) {
        if (depth == nums.length) {
            printArray(current, nums.length);
            return;
        }
        if (i >= nums.length) return;
        if (!used[i]) {
            used[i] = true;
            current[depth] = nums[i];
            permute(nums, used, current, depth + 1, 0);
            used[i] = false;
        }
        permute(nums, used, current, depth, i + 1);
    }
}

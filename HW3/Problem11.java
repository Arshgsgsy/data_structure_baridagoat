public class Problem11 {

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

    public static void subsets(int[] nums, int index, int[] current, int size) {
        if (index == nums.length) {
            printArray(current, size);
            return;
        }
        subsets(nums, index + 1, current, size);
        current[size] = nums[index];
        subsets(nums, index + 1, current, size + 1);
    }
}

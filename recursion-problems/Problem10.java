public class Problem10 {

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

    public static void combinationSum(int[] candidates, int target, int start, int[] current, int size) {
        if (target == 0) {
            printArray(current, size);
            return;
        }
        if (target < 0 || start >= candidates.length) return;
        current[size] = candidates[start];
        combinationSum(candidates, target - candidates[start], start, current, size + 1);
        combinationSum(candidates, target, start + 1, current, size);
    }
}

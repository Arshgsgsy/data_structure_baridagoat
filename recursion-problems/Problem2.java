public class Problem2 {

    public static boolean canJump(int[] nums, int index, int jump) {
        if (index >= nums.length - 1) return true;
        if (nums[index] == 0) return false;
        if (jump > nums[index]) return false;
        if (canJump(nums, index + jump, 1)) return true;
        return canJump(nums, index, jump + 1);
    }
}

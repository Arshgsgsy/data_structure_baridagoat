public class Problem1 {

    public static int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length) return 0;
        int oneStep = minCostClimbingStairs(cost, i + 1);
        int twoStep = minCostClimbingStairs(cost, i + 2);
        if (oneStep < twoStep) {
            return cost[i] + oneStep;
        } else {
            return cost[i] + twoStep;
        }
    }
}

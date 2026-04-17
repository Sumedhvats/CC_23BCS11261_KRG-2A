class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return func(dp, arr, k, 0);
    }

    private int func(int[] dp, int[] arr, int k, int i) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            max = Math.max(max, arr[j]);
            int sum = (max * (j - i + 1)) + func(dp, arr, k, j + 1);
            maxSum = Math.max(sum, maxSum);
        }

        return dp[i] = maxSum;
    }
}

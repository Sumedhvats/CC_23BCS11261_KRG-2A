class Solution {
    public long maxSum(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int x : nums) {
            for (int b = 0; b < 32; b++) {
                if (((x >> b) & 1) == 1) cnt[b]++;
            }
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            long val = 0;
            for (int b = 0; b < 32; b++) {
                if (cnt[b] > 0) {
                    val |= (1L << b);
                    cnt[b]--;
                }
            }
            ans += val * val;
        }
        return ans;
    }
}

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minP = new int[n];
        int[] maxP = new int[n];

        maxP[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxP[i] = Math.max(maxP[i - 1], nums[i]);
        }

        minP[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minP[i] = Math.min(minP[i + 1], nums[i]);
        }

        int res = -1;

        for (int i = 0; i < n; i++) {
            int cur = maxP[i] - minP[i];
            if (cur <= k) {
                return i;
            }
        }
        return res;
    }
}
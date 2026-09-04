class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxPre = new int[n];
        int[] minPre = new int[n];

        maxPre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPre[i] = Math.max(maxPre[i - 1], nums[i]);
        }

        minPre[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minPre[i] = Math.min(minPre[i + 1], nums[i]);
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            int cur = maxPre[i] - minPre[i];
            if (cur <= k) {
                return i;
            }
        }

        return res;
    }
}
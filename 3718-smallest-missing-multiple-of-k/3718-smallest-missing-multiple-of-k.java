class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[nums.length + 2];
        for (int num : nums) {
            if (num % k == 0) {
                int x = num / k;
                if (x < present.length) present[x] = true;
            }
        }
        for (int x = 1; x < present.length; x++) if (!present[x]) return x * k;
        return -1;
    }
}
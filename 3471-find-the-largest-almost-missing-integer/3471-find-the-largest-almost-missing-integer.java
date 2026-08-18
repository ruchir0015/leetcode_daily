class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                maxi = Math.max(maxi, nums[i]);
            }
            return maxi;
        }
        if (k == 1) {
            int[] arr = nums.clone();
            Arrays.sort(arr);
            int ans = -1;
            for (int i = 0; i < n; i++) {
                boolean leftOk = (i == 0 || arr[i] != arr[i - 1]);
                boolean rightOk = (i == n - 1 || arr[i] != arr[i + 1]);
                if (leftOk && rightOk)
                    ans = Math.max(ans, arr[i]);
            }
            return ans;
        }
        int ans = -1;
        if (count(nums, nums[0]) == 1)
            ans = Math.max(ans, nums[0]);
        if (count(nums, nums[n - 1]) == 1)
            ans = Math.max(ans, nums[n - 1]);
        return ans;
    }

    private int count(int[] nums, int val) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                c++;
            }
        }   
        return c;
    }
}
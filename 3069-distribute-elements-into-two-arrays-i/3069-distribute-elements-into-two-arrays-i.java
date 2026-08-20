class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int arr1[] = new int[n];
        int arr2[] = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int l = 1, r = 1;

        for (int i = 2; i < n; i++) {
            if (arr2[r - 1] < arr1[l - 1]) {
                arr1[l++] = nums[i];
            } else {
                arr2[r++] = nums[i];
            }
        }
        r = 0;
        while (l < n) {
            arr1[l++] = arr2[r++];
        }

        return arr1;
    }
}
class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int i=31;
        while (n > 0 && i>=0) {
            int rem = n % 2;
            n = n / 2;
            if(rem==1){
                ans+= Math.pow(2,i);
            }
            i--;
        }
        return ans;
    }
}
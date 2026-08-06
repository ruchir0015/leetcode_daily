class Solution {
    public boolean canAliceWin(int n) {
        boolean ans = true;
        int x = 10;
    
        while (n >= x) {
            n -= x;
            ans = !ans;
            x--;
        }
        
        return !ans;
    }
}
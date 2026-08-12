class Solution {
    public boolean isReachable(int x, int y) {
        while(x % 2 == 0) x = x / 2;
      while(y % 2 == 0) y = y / 2;
      return gcd(x,y) == 1;  
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
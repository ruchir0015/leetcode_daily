class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int g = gcd(targetX, targetY);
        if (g == 1) {
            return true;
        }
        while (g % 2 == 0) {
            g /= 2;
        }
        return g == 1;
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
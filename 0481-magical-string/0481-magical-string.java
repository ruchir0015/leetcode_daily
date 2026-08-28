class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        StringBuilder s = new StringBuilder("122");
        int i = 2;      
        int j = 3;      
        int num = 1;    
        int count = 1;  
        while (j < n) {
            int times = s.charAt(i) - '0';
            for (int k = 0; k < times && j < n; k++) {
                s.append(num);
                if (num == 1) count++;
                j++;
            }
            num = 3 - num;
            i++;
        }
        return count;
    }
}
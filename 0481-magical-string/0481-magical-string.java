class Solution {

    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int count = 1;
        StringBuilder s = new StringBuilder("122");
        int i = 2;
        char num = '1';
        while (s.length() < n) {
            int times = s.charAt(i) - '0';
            for (int j = 0; j < times && s.length() < n; j++) {
                s.append(num);
                if (num == '1')  count++;
            }
            if (num == '1') num = '2';
            else  num = '1';
            i++;
        }
        return count;
    }
}
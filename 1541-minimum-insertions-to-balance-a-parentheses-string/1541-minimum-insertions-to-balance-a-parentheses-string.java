class Solution {
    public int minInsertions(String s) {

        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {

                if(close % 2 == 1) {
                    open++;
                    close--;
                }
                close += 2;
            } else {
                close--;
                if(close < 0) {
                    open++;
                    close = 1;
                }
            }
        }


        return open + close;
        
    }
}
class Solution {
    public int minAddToMakeValid(String s) {
        
        int open_count = 0;
        int add_count = 0;

        for(char ch : s.toCharArray()) {

            if(ch == '(') open_count ++;

            else {
                open_count--;
                if(open_count < 0) {
                    open_count = 0;
                    add_count++;
                }
            }
        }

        return open_count + add_count;
    }
}
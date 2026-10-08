class Solution {
    public int minAddToMakeValid(String s) {
        
        int openCount = 0;
        int addCount = 0;

        for(char ch : s.toCharArray()) {

            if(ch == '(') openCount ++;

            else {
                openCount--;
                if(openCount < 0) {
                    openCount = 0;
                    addCount++;
                }
            }
        }

        return openCount + addCount;
    }
}
class Solution {
    public String removeOuterParentheses(String s) {

        int bal = 0;

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {   
                if(bal > 0) sb.append(ch);
                bal++;
            } else {
                bal--;
                if(bal > 0) sb.append(ch);
            }
        }

        return sb.toString();
        
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        int check = x;
        if(x<0) return false;
        int num = 0;
        while(x!=0){
            num=num*10+x%10;
            x=x/10;
        }
        if(check==num){
            return true;
        }
        else{
            return false;
        }
    } 
}
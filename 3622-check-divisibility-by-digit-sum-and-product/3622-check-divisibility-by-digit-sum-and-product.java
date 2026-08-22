class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;
        int sum = 0;
        int product = 1;
        while(n>0){
            sum=sum+(n%10);
            product*=(n%10);
            n=n/10;
        }
        if(x%(sum+product)==0){
            return true;
        }
        else{
            return false;
        }
    }
}
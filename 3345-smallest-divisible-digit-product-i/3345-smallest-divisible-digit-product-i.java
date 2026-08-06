class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        while(true){
            if(product(num)%t==0){
                return num;
            }
            num++;
        }
    }
    public int product(int num){
        int product = 1;
        while(num!=0){
            product=product*(num%10);
            num=num/10;
        }
        return product;
    }
}
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }

        int x = fib(n-1);
        int y = fib(n-2);

        return x + y;
    }
}
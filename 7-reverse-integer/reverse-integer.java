class Solution {
    public int reverse(int x) {
        int revN = 0;
        while (x != 0){
            int lastD = x % 10;
            if((revN > Integer.MAX_VALUE/10)){
                return 0;
            }
            if((revN < Integer.MIN_VALUE/10)){
                return 0;
            }
            revN = (revN * 10) + lastD;
            x = x / 10;
        }
        return revN;
    }
}
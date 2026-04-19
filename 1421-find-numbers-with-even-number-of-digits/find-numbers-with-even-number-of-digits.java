class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) { // for every num in nums
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int numberOfDigits = digits(num);

        if(numberOfDigits % 2 == 0){
            return true;
        }
        return false; 
    }
    static int digits (int num1){
        if(num1 < 0){
            num1 = num1 * -1;
        }
        if(num1 == 0){
            return 1;
        }
        int count = 0;
        while(num1 > 0){
            count++;
            num1 = num1 / 10;
        }
        return count;
    }
}
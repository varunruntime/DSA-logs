class Solution {
    public int[] plusOne(int[] digits) {
         // start from last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // if digit < 9 just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // if digit is 9 -> becomes 0 and carry moves left
            digits[i] = 0;
        }
        
        // if all digits were 9 
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
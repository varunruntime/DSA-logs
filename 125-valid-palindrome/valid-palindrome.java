class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetterOrDigit(ch)) {
                clean.append(ch);
            }
        }
        return pal(0, clean.toString());
    }
    private boolean pal(int i, String s){
        if( i >= s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return pal(i + 1, s);
    }
}
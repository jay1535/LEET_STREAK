class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // If treated as ')'
                maxOpen++; // If treated as '('
            }

            // More ')' than possible '(' and '*' combined
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative; we can choose to treat '*' as "" instead of ')'
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // Valid if we can reach exactly 0 open left parentheses
        return minOpen == 0;
    }
}
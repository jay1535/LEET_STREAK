//Solution

class Solution {
    public String smallestNumber(String pattern) {
       
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int ind = 0;ind<=pattern.length();ind++){    
            stack.push(ind+1);        
            if(ind == pattern.length() || pattern.charAt(ind) == 'I'){
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}

/*

Example 1:
Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

Example 2:
Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.

*/

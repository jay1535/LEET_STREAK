//Solution

class Solution {
    public int maximumGain(String s, int x, int y) {
        int minCharCount = 0, maxCharCount = 0;
        int maxVal = x>y?x:y;
        int minVal = x>y?y:x;

        char maxChar = x>y?'a':'b';
        char minChar = x>y?'b':'a';

        int ans = 0;
        for(int i=0; i<s.length();i++){
            char currChar = s.charAt(i);
            if(currChar == minChar){
                if(maxCharCount>0){
                    ans+=maxVal;
                    maxCharCount--;
                }
                else{
                    minCharCount++;
                }
            }
            else if(currChar==maxChar){
                maxCharCount++;

            }
            else{
                ans+=Math.min(maxCharCount, minCharCount)*minVal;
                minCharCount=0;
                maxCharCount=0;
            }
        }
        ans+=Math.min(maxCharCount, minCharCount)*minVal;
        return ans;
    }
}

/*

Example 1:
Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

Example 2:
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

*/

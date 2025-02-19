//Solution
class Solution {
    String result= "";
    int count = 0;
    public String getHappyString(int n, int k) {
        buildHappyStrings(n,k,new StringBuilder());
        if(count < k)
            return "";
        return result.toString();
    }

    public void buildHappyStrings(int n, int k, StringBuilder sb){
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
                return;
            }
        }
        int sbLen = sb.length();
        if(sbLen < n && count < k){
            for(char c = 'a'; c <='c'; c++){
                if(sbLen == 0 || sb.charAt(sbLen-1) != c){
                    sb.append(c);
                    buildHappyStrings(n,k,sb);
                    sb.deleteCharAt(sbLen);
                }
            }
        }
        
    }
}

/*

Example 1:
Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

Example 2:
Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.

Example 3:
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

*/

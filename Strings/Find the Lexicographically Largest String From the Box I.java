//Solution

class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)return word;

        int n = word.length();
        int m = n - numFriends + 1;
        String ans = "";
        for(int i=0;i<n;i++){
            String ss = word.substring(i,Math.min(i+m,n));
            if(ss.compareTo(ans)>0)
            ans = ss;
        }
        return ans;
    }
}

/*

Example 1:
Input: word = "dbca", numFriends = 2
Output: "dbc"
Explanation: 
All possible splits are:
"d" and "bca".
"db" and "ca".
"dbc" and "a".

Example 2:
Input: word = "gggg", numFriends = 4
Output: "g"
Explanation: 
The only possible split is: "g", "g", "g", and "g".

*/

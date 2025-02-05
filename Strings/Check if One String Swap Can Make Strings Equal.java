//Solution

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int i=-1, j=-1;
        int cnt=0;
        for(int k=0; k<s1.length(); k++){
            if(s1.charAt(k)!=s2.charAt(k)){
                cnt++;
                if(i==-1) i=k;
                else if(j==-1) j=k;
            }
        }
        if(cnt==0) return true;
        else if(cnt==2 && s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
            return true;
        }
        return false;
    }
}

/*

Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.

*/

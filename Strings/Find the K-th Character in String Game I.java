//Solution

class Solution {
    public char kthCharacter(int k) {
        String word = "a";
      return  helper(word,k);
    }
    public static char helper(String word,int k){
        if(word.length()>=k){
            return word.charAt(k-1);
        }
        int index=0;
        StringBuilder str = new StringBuilder(word);
        while(index<word.length()){
            char ch = word.charAt(index);
            str.append((char)(ch + 1));    
            index++;
        }
        return helper(str.toString(),k);
        
    }
}

/*

Example 1:

Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

Generated string is "b", word becomes "ab".
Generated string is "bc", word becomes "abbc".
Generated string is "bccd", word becomes "abbcbccd".
Example 2:

Input: k = 10

Output: "c"

 

Constraints:

1 <= k <= 500

*/

//Solution

class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n<3){
            return false;
        }
        int vowels = 0;
        int consonants = 0;
        for (char c:word.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiouAEIOU".indexOf(c)!= -1){
                    vowels++;
                }
                else{
                    consonants++;
                }
            }
            else if (!Character.isDigit(c)){
                return false;
            }
        }
        return vowels >= 1 && consonants >= 1;

    }
}

/*

Example 1:
Input: word = "234Adas"
Output: true
Explanation:
This word satisfies the conditions.

Example 2:
Input: word = "b3"
Output: false
Explanation:
The length of this word is fewer than 3, and does not have a vowel.

Example 3:
Input: word = "a3$e"
Output: false
Explanation:
This word contains a '$' character and does not have a consonant.

*/

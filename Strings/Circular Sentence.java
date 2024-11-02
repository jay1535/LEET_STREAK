// Solution

public class Solution {

    public boolean isCircularSentence(String sentence) {
        for (int i = 0; i < sentence.length(); ++i) if (
            sentence.charAt(i) == ' ' &&
            sentence.charAt(i - 1) != sentence.charAt(i + 1)
        ) return false;
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}


/* 

Example 1:
Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcode's last character is equal to exercises's first character.
- exercises's last character is equal to sound's first character.
- sound's last character is equal to delightful's first character.
- delightful's last character is equal to leetcode's first character.
The sentence is circular.

Example 2:
Input: sentence = "eetcode"
Output: true
Explanation: The words in sentence are ["eetcode"].
- eetcode's last character is equal to eetcode's first character.
The sentence is circular.

Example 3:
Input: sentence = "Leetcode is cool"
Output: false
Explanation: The words in sentence are ["Leetcode", "is", "cool"].
- Leetcode's last character is not equal to is's first character.
The sentence is not circular.

*/

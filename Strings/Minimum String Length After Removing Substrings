//Solution
class Solution{
 public int minLength(String s){
    Stack<Character> stack = new Stack<>();
    for(int i =0; i< s.length(); i++){
       char curr_char = s.charAt(i);
       if(stack.isEmpty()){
          stack.push(curr_char);
          continue;
       }
       if(curr_char == "B" && stack.peek() == "A"){
            stack.pop();
       }
      else if(curr_char == "D" && stack.peek() == "C"){
            stack.pop();
      }
      else {
           stack.push(curr_char);
}
}
return stack.size();
}}



/* Example 1:

Input: s = "ABFCACDB"
Output: 2
Explanation: We can do the following operations:
- Remove the substring "ABFCACDB", so s = "FCACDB".
- Remove the substring "FCACDB", so s = "FCAB".
- Remove the substring "FCAB", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain. */

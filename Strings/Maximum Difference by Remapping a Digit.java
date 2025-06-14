//Solution

class Solution {
    public int minMaxDifference(int num) {
        char x[]=String.valueOf(num).toCharArray();
        char y[]=String.valueOf(num).toCharArray();
        char p=x[0],q=x[0];
        for(int i=0;i<x.length;i++)
        {
            if(x[i]!='9')
            {
                p=x[i];
                break;
            }
        }
        for(int i=0;i<x.length;i++)
        {
            if(x[i]==p)
            {
                x[i]='9';
            }
        }
        for(int i=0;i<x.length;i++)
        {
            if(y[i]==q)
            {
                y[i]='0';
            }
        }
        return Integer.parseInt(String.valueOf(x)) - Integer.parseInt(String.valueOf(y));
    }
}

/*

Example 1:
Input: num = 11891
Output: 99009
Explanation: 
To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
The difference between these two numbers is 99009.

Example 2:
Input: num = 90
Output: 99
Explanation:
The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can be returned by the function is 0 (if 9 is replaced by 0).
Thus, we return 99.

*/

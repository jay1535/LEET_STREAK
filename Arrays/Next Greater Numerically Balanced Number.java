//Solution

class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i=n+1; i<=1224444; i++){
            if(isBalance(i)){
                return i;
            }
        }
        return -1;
    }
private boolean isBalance(int x){

    int[] count=new int[10];
    while(x>0){
   count[x%10]++;
    x/=10;
}

for(int d=0; d<10; d++){
    if(count[d]>0 && count[d] != d){
        return false;
    }
}
return true;
}
}

/*

Example 1:

Input: n = 1
Output: 22
Explanation: 
22 is numerically balanced since:
- The digit 2 occurs 2 times. 
It is also the smallest numerically balanced number strictly greater than 1.
Example 2:

Input: n = 1000
Output: 1333
Explanation: 
1333 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times. 
It is also the smallest numerically balanced number strictly greater than 1000.
Note that 1022 cannot be the answer because 0 appeared more than 0 times.
Example 3:

Input: n = 3000
Output: 3133
Explanation: 
3133 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times.
It is also the smallest numerically balanced number strictly greater than 3000.
 

Constraints:

0 <= n <= 106

*/

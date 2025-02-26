//Solution

class Solution {
    public int maxAbsoluteSum(int[] a) {
        int n=a.length;
        int tot=0,sum=0;
        int s=a[0];
        int mi=0,ma=0;
        if(a[0]<mi)mi=a[0];
        if(a[0]>ma)ma=a[0];
        for(int i=1;i<n;i++)
        {
            s=s+a[i];
            if(s>ma)ma=s;
            if(s<mi)mi=s;
        }

        return Math.abs(ma-mi);
    }
}


/*

Example 1:
Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

Example 2:
Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 
*/

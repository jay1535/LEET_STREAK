//Solution

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        
        int[] arrBox=new int[n];
        for(int i=0; i<n; i++){
            arrBox[i]=boxes.charAt(i)-'0';
        }

        int[] left=new int[n]; 
        int[] right=new int[n]; 

        int oneCnt=0;
        // Left to right pass moving count
        oneCnt=arrBox[0];
        for(int i=1; i<n; i++){
            left[i]=left[i-1]+oneCnt;
            oneCnt+=arrBox[i];
        }

        // Right to left pass moving count  
        oneCnt=arrBox[n-1];
        for(int i=n-2; i>=0; i--){
            right[i]=right[i+1]+oneCnt;
            oneCnt+=arrBox[i];
        }

        // Sum the left and right 
        for(int i=0; i<n; i++){
            arrBox[i]=left[i]+right[i];
        }        

        return arrBox;
    }
}

/*

Example 1:
Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.

Example 2:
Input: boxes = "001011"
Output: [11,8,5,4,3,4]

*/

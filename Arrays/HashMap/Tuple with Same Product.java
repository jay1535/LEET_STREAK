//Solution

class Solution {
    public int tupleSameProduct(int[] nums) {
        int N=nums.length;
        int res=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        for(Map.Entry<Integer, Integer> enty:map.entrySet()){
            if(enty.getValue()>=2){
                int n=enty.getValue();
                res+=8*(n*(n-1)/2);    
            }
        }

        return res;
    }


}

/*

Example 1:
Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

Example 2:
Input: nums = [1,2,4,5,10]
Output: 16
Explanation: There are 16 valid tuples:
(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 
*/

//Solution

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1; 
        long high =(long) 1e14;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            long canRepair = 0;
            for(int r : ranks){
                canRepair += (long) Math.sqrt(mid/r);
            }
            if(canRepair >= cars){
                high = mid -1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
/*

Example 1:
Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation: 
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

Example 2:
Input: ranks = [5,1,8], cars = 6
Output: 16
Explanation: 
- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

*/

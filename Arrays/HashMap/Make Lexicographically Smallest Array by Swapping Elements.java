//Solution

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int sortArr[] = new int[nums.length];
    for(int i=0; i<nums.length; i++)
    sortArr[i] = nums[i];
    Arrays.sort(sortArr);

    HashMap<Integer, Integer> myGroup = new HashMap<>();
    HashMap<Integer, LinkedList<Integer>>groupMember = new HashMap<>();
    int groupKey = 0; 
    
    myGroup.put(sortArr[0], groupKey);
    groupMember.put(groupKey, new LinkedList<Integer>(Arrays.asList(sortArr[0])));

    for(int i=1; i<nums.length; i++)
    {
       if(Math.abs(sortArr[i]-sortArr[i-1])>limit)
       groupKey++;
       myGroup.put(sortArr[i], groupKey);
       
       if(!groupMember.containsKey(groupKey))
       groupMember.put(groupKey, new LinkedList<Integer>());

       groupMember.get(groupKey).add(sortArr[i]);
    }
   for(int i=0; i<nums.length; i++)
   {
     int currNum = nums[i];
     int groupNumber = myGroup.get(currNum);
     nums[i] = groupMember.get(groupNumber).pop();
   }
    return nums; 

    }
}

/*

Example 1:
Input: nums = [1,5,3,9,8], limit = 2
Output: [1,3,5,8,9]
Explanation: Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.

Example 2:
Input: nums = [1,7,6,18,2,1], limit = 3
Output: [1,6,7,18,1,2]
Explanation: Apply the operation 3 times:
- Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
- Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
- Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
We cannot obtain a lexicographically smaller array by applying any more operations.

Example 3:
Input: nums = [1,7,28,19,10], limit = 3
Output: [1,7,28,19,10]
Explanation: [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.

*/

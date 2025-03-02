//SOlution

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> resultList = new ArrayList<>();
        
        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];
            
            if (id1 < id2) {
                resultList.add(new int[]{id1, val1});
                i++;
            } else if (id2 < id1) {
                resultList.add(new int[]{id2, val2});
                j++;
            } else {
                resultList.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            }
        }
        
        while (i < nums1.length) {
            resultList.add(nums1[i]);
            i++;
        }
        
        while (j < nums2.length) {
            resultList.add(nums2[j]);
            j++;
        }
        
      
        int[][] result = new int[resultList.size()][2];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }
        
        return result;
    }
}

/*

Example 1:
Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.

Example 2:
Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.

*/

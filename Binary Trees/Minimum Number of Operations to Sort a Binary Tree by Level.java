//Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int[] arr1 = new int[size];
            int[] arr2 = new int[size];
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                arr1[i] = temp.val;
                arr2[i] = temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            count += fun(arr1, arr2);
        }
        return count;
    }

    static int fun(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if(n == 1) return 0;
        Arrays.sort(arr1);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(arr1[i], i);
        
        int count = 0;
        for(int i = 0; i < n; ) {
            int index = map.get(arr2[i]);
            if(index == i) i++;
            else {
                count++;
                int temp = arr2[i];
                arr2[i] = arr2[index];
                arr2[index] = temp;
            }
        }
        return count;
    }
}

/*

Example 1:
Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.

Example 2:
Input: root = [1,3,2,7,6,5,4]
Output: 3
Explanation:
- Swap 3 and 2. The 2nd level becomes [2,3].
- Swap 7 and 4. The 3rd level becomes [4,6,5,7].
- Swap 6 and 5. The 3rd level becomes [4,5,6,7].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.

Example 3:
Input: root = [1,2,3,4,5,6]
Output: 0
Explanation: Each level is already sorted in increasing order so return 0.

*/

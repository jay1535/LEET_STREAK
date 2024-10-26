// Solution

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
    int depth[];
    int levelArr[];
    int max1[];
    int max2[];
    public int height(TreeNode root, int level)
    {
     if(root==null)
         return 0; 
     levelArr[root.val] = level; 
     depth[root.val] = 1 + Math.max(height(root.left, level+1), height(root.right, level+1));
     if(max1[level]<depth[root.val]) 
     {
         max2[level] = max1[level];
         max1[level] = depth[root.val];
     }
        else if(max2[level]<depth[root.val])
            max2[level] = depth[root.val]; 
     return depth[root.val];
    }
    
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        depth = new int[100001];
        levelArr = new int[100001];
        max1 = new int[100001];
        max2 = new int[100001];
        
        height(root, 0);
        for(int i=0; i<queries.length; i++)
        {
         int q = queries[i];
         int level = levelArr[q];
         queries[i] = (max1[level]==depth[q]? max2[level] : max1[level]) + level - 1;  
            
        }
        
       return queries; 
    }
}

/* 


Example 1:
Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
Output: [2]
Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
The height of the tree is 2 (The path 1 -> 3 -> 2).

Example 2:
Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
Output: [3,2,3,2]
Explanation: We have the following queries:
- Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 4).
- Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -> 8 -> 1).
- Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 6).
- Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -> 9 -> 3).


*/

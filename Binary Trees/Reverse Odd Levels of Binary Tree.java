//Solution


class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
     
        
        levelTraverse(root.left, root.right, 0);
        return root;
    }

    private void levelTraverse(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null)
            return;
        
        if (level % 2 == 0) {
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }

        levelTraverse(node1.left, node2.right, level + 1);
        levelTraverse(node1.right, node2.left, level + 1);
    }
}

/*

Example 1:
Input: root = [2,3,5,8,13,21,34]
Output: [2,5,3,8,13,21,34]
Explanation: 
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.

Example 2:
Input: root = [7,13,11]
Output: [7,11,13]
Explanation: 
The nodes at level 1 are 13, 11, which are reversed and become 11, 13.

Example 3:
Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
Explanation: 
The odd levels have non-zero values.
The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.

*/

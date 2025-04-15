//SOlution


class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];

        // Position map – where is each element in nums2?
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        long[] left = new long[n];
        int[] bit = new int[n + 2]; // extra room for classic off-by-one safety

        for (int i = 0; i < n; i++) {
            left[i] = query(bit, mapped[i]);
            update(bit, mapped[i] + 1, 1);  // 1-indexed... thanks BIT 🙃
        }

        long[] right = new long[n];
        bit = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            right[i] = query(bit, n) - query(bit, mapped[i] + 1);
            update(bit, mapped[i] + 1, 1);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += left[i] * right[i]; // Middle element magic
        }
        return res;
    }

    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }

    int query(int[] bit, int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }
}

/*

Example 1:

Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3]
Output: 1
Explanation: 
There are 4 triplets (x,y,z) such that pos1x < pos1y < pos1z. They are (2,0,1), (2,0,3), (2,1,3), and (0,1,3). 
Out of those triplets, only the triplet (0,1,3) satisfies pos2x < pos2y < pos2z. Hence, there is only 1 good triplet.
Example 2:

Input: nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
Output: 4
Explanation: The 4 good triplets are (4,0,3), (4,0,2), (4,1,3), and (4,1,2).

*/

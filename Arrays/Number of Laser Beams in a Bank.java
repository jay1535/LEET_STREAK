//Solution

class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0) {
            return 0;
        }
        
        int totalBeams = 0;
        int prevRowDevices = countDevices(bank[0]);
        
        for (int i = 1; i < bank.length; i++) {
            int currentRowDevices = countDevices(bank[i]);
            
            if (currentRowDevices == 0) {
                continue;
            }
            
            totalBeams += prevRowDevices * currentRowDevices;
            prevRowDevices = currentRowDevices;
        }
        
        return totalBeams;
    }
    
    private int countDevices(String row) {
        int deviceCount = 0;
        for (char cell : row.toCharArray()) {
            if (cell == '1') {
                deviceCount++;
            }
        }
        return deviceCount;
    }
}

/*

Example 1:


Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition.
Example 2:


Input: bank = ["000","111","000"]
Output: 0
Explanation: There does not exist two devices located on two different rows.
 

Constraints:

m == bank.length
n == bank[i].length
1 <= m, n <= 500
bank[i][j] is either '0' or '1'.

*/

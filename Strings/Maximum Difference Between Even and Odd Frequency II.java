//Solution

class Solution {
    private int max=100_000;
    private int status(int aCnt,int bCnt){
        return ((aCnt%2)*2)|(bCnt%2);
    }
    public int maxDifference(String s, int k) {
        int n=s.length();
        int maxDiff=-max;
        for(char i='0';i<'5';i++){
            for(char j='0';j<'5';j++){
                if(i==j) continue;
                int[] hash=new int[5];
                Arrays.fill(hash,max);
                int aCurr=0,bCurr=0;
                int aPrev=0,bPrev=0;
                int l=-1;
                for(int r=0;r<n;r++){
                    aCurr+=(s.charAt(r)==i)?1:0;
                    bCurr+=(s.charAt(r)==j)?1:0;
                    while(r-l>=k&&bCurr-bPrev>=2){
                        int x=status(aPrev,bPrev);
                        hash[x]=Math.min(hash[x],aPrev-bPrev);
                        l++;
                        aPrev+=(s.charAt(l)==i)?1:0;
                        bPrev+=(s.charAt(l)==j)?1:0;
                    }
                    int y=status(aCurr,bCurr);
                    if(hash[y^2]!=max) maxDiff=Math.max(maxDiff,aCurr-bCurr-hash[y^2]);
                }
            }
        }
        return maxDiff;
    }
}

/*

Example 1:

Input: s = "12233", k = 4

Output: -1

Explanation:

For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1.

Example 2:

Input: s = "1122211", k = 3

Output: 1

Explanation:

For the substring "11222", the frequency of '2' is 3 and the frequency of '1' is 2. The difference is 3 - 2 = 1.

Example 3:

Input: s = "110", k = 3

Output: -1


*/

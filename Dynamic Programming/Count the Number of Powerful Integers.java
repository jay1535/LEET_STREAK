//Solution

class Solution {

    public long numberOfPowerfulInt(long rangeStart, long rangeEnd, int chakraLimit, String clanSymbolSuffix) {
        return countPowerfulShinobi(rangeEnd, chakraLimit, clanSymbolSuffix)
             - countPowerfulShinobi(rangeStart - 1, chakraLimit, clanSymbolSuffix);
    }

    private long countPowerfulShinobi(long chakraCap, int chakraLimit, String clanSymbol) {
        String chakraFlow = Long.toString(chakraCap); 
        int prefixLength = chakraFlow.length() - clanSymbol.length();

        
        if (prefixLength < 0) return 0;

        long[][] rasenganScroll = new long[prefixLength + 1][2];

      
        rasenganScroll[prefixLength][0] = 1; 
        rasenganScroll[prefixLength][1] = chakraFlow.substring(prefixLength).compareTo(clanSymbol) >= 0 ? 1 : 0;

     
        for (int i = prefixLength - 1; i >= 0; i--) {
            int currentChakra = chakraFlow.charAt(i) - '0';

        
            rasenganScroll[i][0] = (chakraLimit + 1) * rasenganScroll[i + 1][0];

          
            if (currentChakra <= chakraLimit) {
                rasenganScroll[i][1] = (long) currentChakra * rasenganScroll[i + 1][0] + rasenganScroll[i + 1][1];
            } else {
                rasenganScroll[i][1] = (long) (chakraLimit + 1) * rasenganScroll[i + 1][0];
            }
        }

        return rasenganScroll[0][1];
    }
}

/*

Example 1:
Input: start = 1, finish = 6000, limit = 4, s = "124"
Output: 5
Explanation: The powerful integers in the range [1..6000] are 124, 1124, 2124, 3124, and, 4124. All these integers have each digit <= 4, and "124" as a suffix. Note that 5124 is not a powerful integer because the first digit is 5 which is greater than 4.
It can be shown that there are only 5 powerful integers in this range.

Example 2:
Input: start = 15, finish = 215, limit = 6, s = "10"
Output: 2
Explanation: The powerful integers in the range [15..215] are 110 and 210. All these integers have each digit <= 6, and "10" as a suffix.
It can be shown that there are only 2 powerful integers in this range.

Example 3:
Input: start = 1000, finish = 2000, limit = 4, s = "3000"
Output: 0
Explanation: All integers in the range [1000..2000] are smaller than 3000, hence "3000" cannot be a suffix of any integer in this range.

*/

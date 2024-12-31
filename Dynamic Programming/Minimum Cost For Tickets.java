//Solution

class Solution {
       public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return minCostTickets(days, costs, 0, dp);
    }
    
    public static int minCostTickets(int[] days, int[] costs, int day, int[] dp){
        if(day >= days.length) return 0;
   
        if(dp[day] != 0) return dp[day];
         int i;

        int buyOneDay =  minCostTickets(days, costs, day + 1, dp) + costs[0];


        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 7) break;
        int buySevenDays = minCostTickets(days, costs, i, dp) + costs[1];
        
       
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 30) break;
        int buyThirtyDays = minCostTickets(days, costs, i, dp) + costs[2];
        
         
        int result = Math.min(Math.min(buyOneDay, buySevenDays), buyThirtyDays);
        dp[day] = result;
        return result;
        
    }
}

/*

Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.
 
*/

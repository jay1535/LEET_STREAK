//Solution

class Solution {
    int M = (int)(1e9+7) ; 
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size() ; 
        int s[] = new int[n] ; 
         PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]>b[0]?-1:1 ;  
            return a[1]>b[1]?-1:1 ; 
        }) ; 
        
        Stack<int[]> st = new Stack<>() ; 
        int[] right = new int[n] ;
        
        for(int i=n-1 ; i>=0 ; i--) {             // O(n)
            s[i] = prime_score(nums.get(i)) ;
            int len = 0 ;
            while(! st.isEmpty() && st.peek()[0]<= s[i]) st.pop() ; 
            if(st.isEmpty())len = n-i ; 
            else len = st.peek()[1] - i ; 
            right[i] = len ; 
            st.push(new int[]{s[i] , i}) ;             
        } 
        st = new Stack<>() ; 

        for(int i=0 ; i<n ; i++){       // O(n)
            long len = 0 ; 
            while(! st.isEmpty() && st.peek()[0]<s[i])   st.pop() ;
            if(st.isEmpty()) len = i+1 ; 
            else len = i-st.peek()[1] ; 
            st.push(new int[]{s[i] , i}) ; 
            long range = len* right[i] ; 

            pq.add(new long[]{nums.get(i) , range}) ; 
        }
        long ans = 1 ;  
        while(k>0){
            long [] p = pq.poll() ;
            long num = p[0] , range = p[1] ; 
            int y = (int)Math.min(range , k) ; 
            ans *= exponentiate(num , y) ;    // O(log(k))
            ans %=M ; 
            k -= y ;
        }
        return (int)ans ; 
    }
    private int prime_score(int x){   //O(sqrt(x))
        int ct = 0 ; 
        for(int i=2 ; i*i<= x ; i++){
            if(x%i==0){
                ct++ ; 
                while(x%i==0) x/=i ; 
            }
        }
        if(x>1) ct++ ; 
        return ct ; 
    }
    private int exponentiate(long a , int b){
        long x = a ; 
        long ans = 1 ; 
        while(b>0){
            if((b&1)==1) {
                ans *= x ; 
                ans%=M ; 
            }
            x *=x ; 
            x%=M ; 
            b>>=1 ; 
        }
        return (int)ans ; 
    }
}

/*

Example 1:
Input: nums = [8,3,9,3,8], k = 2
Output: 81
Explanation: To get a score of 81, we can apply the following operations:
- Choose subarray nums[2, ..., 2]. nums[2] is the only element in this subarray. Hence, we multiply the score by nums[2]. The score becomes 1 * 9 = 9.
- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 1, but nums[2] has the smaller index. Hence, we multiply the score by nums[2]. The score becomes 9 * 9 = 81.
It can be proven that 81 is the highest score one can obtain.

Example 2:
Input: nums = [19,12,14,6,10,18], k = 3
Output: 4788
Explanation: To get a score of 4788, we can apply the following operations: 
- Choose subarray nums[0, ..., 0]. nums[0] is the only element in this subarray. Hence, we multiply the score by nums[0]. The score becomes 1 * 19 = 19.
- Choose subarray nums[5, ..., 5]. nums[5] is the only element in this subarray. Hence, we multiply the score by nums[5]. The score becomes 19 * 18 = 342.
- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 2, but nums[2] has the smaller index. Hence, we multipy the score by nums[2]. The score becomes 342 * 14 = 4788.
It can be proven that 4788 is the highest score one can obtain.

*/

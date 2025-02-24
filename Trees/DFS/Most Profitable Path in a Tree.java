//SOlution

class Solution {
    int mx= Integer.MIN_VALUE;
    public void dfs2(ArrayList<Integer> adj[], int s, int p, int pre, int dis[], int disB[], int amount[], int dd){
        if(disB[s]<dd)
            dis[s]= pre;
        else if(disB[s]== dd)
            dis[s]= pre+amount[s]/2;
        else
            dis[s]= pre+amount[s];
        for(int i= 0;i<adj[s].size();i++)
        {
            if(adj[s].get(i) == p)
                continue;
            dfs2(adj, adj[s].get(i), s, dis[s], dis, disB, amount, dd+1);
        }
        if(adj[s].size() == 1 && s!= 0)
            mx= Math.max(mx, dis[s]);
    }
    boolean dfs(ArrayList<Integer> adj[], int s, int p, int disB[], int pre, int d)
    {
        if(s== d)
        {
            disB[s]= pre;
            return true;
        }
        for(int i= 0;i<adj[s].size();i++)
        {
            if(adj[s].get(i).intValue()== p) continue;
            if(dfs(adj, adj[s].get(i), s, disB, pre+1, d)){ disB[s]= pre; return true;}
        }
        return false;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        mx= Integer.MIN_VALUE;
        int n= amount.length;
        ArrayList<Integer> []adj= new ArrayList[n];
        for(int i= 0;i<n;i++)
            adj[i]= new ArrayList<Integer>();
        for(int i= 0;i<edges.length;i++)
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int disB[]= new int[n];
        Arrays.fill(disB, Integer.MAX_VALUE);
        int dis[]= new int[n];
        dfs(adj, bob, -1, disB, 1, 0);
        dfs2(adj, 0, -1, 0, dis, disB, amount, 1);
        return mx;
    }
}

/*

Example 1:
Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
Output: 6
Explanation: 
The above diagram represents the given tree. The game goes as follows:
- Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
  Alice's net income is now -2.
- Both Alice and Bob move to node 1. 
  Since they reach here simultaneously, they open the gate together and share the reward.
  Alice's net income becomes -2 + (4 / 2) = 0.
- Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
  Bob moves on to node 0, and stops moving.
- Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
Now, neither Alice nor Bob can make any further moves, and the game ends.
It is not possible for Alice to get a higher net income.

Example 2:
Input: edges = [[0,1]], bob = 1, amount = [-7280,2350]
Output: -7280
Explanation: 
Alice follows the path 0->1 whereas Bob follows the path 1->0.
Thus, Alice opens the gate at node 0 only. Hence, her net income is -7280.

*/

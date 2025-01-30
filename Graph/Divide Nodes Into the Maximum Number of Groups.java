//Solution
class Solution {
    private int findParent(int i, int[] parent){
        if(parent[i]==-1 || parent[i]==i)return parent[i] = i;
        return parent[i] = findParent(parent[i],parent);
    }
    private void union(int[] parent, int i, int j){
        int parent1 = findParent(i,parent);
        int parent2 = findParent(j,parent);
        if(parent2<parent1)
             parent[parent1] = parent2;
        else
            parent[parent2] = parent1;
    }
    private void createGraph(List<List<Integer>> adj, int[][] edges, int n, int[] parent){
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]-1).add(e[1]-1);
            adj.get(e[1]-1).add(e[0]-1);
            union(parent,e[0]-1,e[1]-1);
        }
    }
    private int bfs(List<List<Integer>> adj, int i, int n){
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        int grps = 0; 
        qu.offer(i);
        while(qu.size()>0){
            int size = qu.size();
            Set<Integer> crtGroupEls = new HashSet<>();
            
            for(int j=0;j<size;j++){
                crtGroupEls.add(qu.poll());
            }
            // System.out.println(crtGroupEls);
            for(int el : crtGroupEls){
                visited[el] = true;
                for(int neig : adj.get(el)){
                    if(crtGroupEls.contains(neig))return -1;
                    if(visited[neig]==false){
                        qu.offer(neig);
                        visited[neig] = true;
                    }
                }
            }
            grps+=1;
        }
        // System.out.println("========");
        return grps;
    }
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] maxs = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        createGraph(adj,edges,n,parent);
        for(int i=0;i<n;i++){
            int ans = bfs(adj,i,n);
            if(ans==-1)return ans;
            int crtParent = findParent(i,parent);
            maxs[crtParent] = Math.max(ans,maxs[crtParent]);
        }
        int sum = 0;
        for(int i=0;i<maxs.length;i++)sum+=maxs[i];
        return sum;
    }
}

/*

Example 1:
Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
Output: 4
Explanation: As shown in the image we:
- Add node 5 to the first group.
- Add node 1 to the second group.
- Add nodes 2 and 4 to the third group.
- Add nodes 3 and 6 to the fourth group.
We can see that every edge is satisfied.
It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.

Example 2:
Input: n = 3, edges = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
It can be shown that no grouping is possible.
 
*/

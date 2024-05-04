## DFS Traversal of a Graph
- boolean array (visited ) + output arraylist
- call recursion for all vertices(disconnected component)
- In recursion call , make it visted & add to output array (R)
- call its neighbour ( check visited or not)
```
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> dfs = new ArrayList<>();
        
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfsRecursion(i,adj,dfs,vis);
            }
        }
        
        return dfs;
        
    }
    
    // Recursive 
    public void dfsRecursion(int curr,ArrayList<ArrayList<Integer>> adj,
    ArrayList<Integer> dfs,boolean[] vis
    )
    {
        vis[curr] =true;
        dfs.add(curr);
        for(int node:adj.get(curr)){
            if(!vis[node])
                dfsRecursion(node,adj,dfs,vis);
        }
    }
}
```

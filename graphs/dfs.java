class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      
     // go deeper and collect nodes
     
     // graph - tree with cycle
    boolean[] visited = new boolean[V+1];
    ArrayList<Integer> op = new ArrayList<>();
    // for disconnected components  
    for(int i=0;i<V;i++){
        if(!visited[i])
            function(i,adj,op,visited);
    }
    
    return op;
    
    }
    
    void function(int V,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list,
    boolean[] visited){
        
        visited[V] = true;// mark visited
        list.add(V);
        for(int next: adj.get(V)){
            if(!visited[next])
               function(next,adj,list,visited);
        }
    
    }
}

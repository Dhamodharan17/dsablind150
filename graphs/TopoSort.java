class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        //topo sort - dfs - we need first node at start
        // last node at end
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        //disconnected components
        for(int i=0;i<V;i++){
             topoSort(i,adj,stack,visited);
        }
       
        //add sorted  in array
        int[] sorted = new int[V];
        int k = 0;
        
        while(!stack.isEmpty()){
            sorted[k++] = stack.pop();
        }
        
        return sorted;
        
    }
    
   static void topoSort(int V,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,
    boolean[] visited){
        
        // we should not add same node again and again
        // we should add u->v
        visited[V] = true;
        
        for(int next:adj.get(V)){
            if(!visited[next]){
                topoSort(next,adj,stack,visited);
            }
        }
        stack.add(V); 
        // in recursion last node will be added in first
        // stack it will remain in last
        
    }
}

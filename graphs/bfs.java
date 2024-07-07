class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //obj - go level by level and collect nodes
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue= new LinkedList<>();
        // must since graph may contain cycle
        boolean[] visited = new boolean[V+1];
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int current = queue.remove();
            list.add(current);
            // call nexts
            for(int next:adj.get(current)){
                if(!visited[next]){
                queue.add(next);
                // make it visited or duplicate nodes will added
                // if any other node connected via different routes point next
                visited[next] = true;}
            }
        }
      
      return list;
    }
}

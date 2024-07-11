class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // topo sort - node which is independent will be 1st sorted
        int[] inDegree = new int[V];
        
        //calculate indegree
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                //u->v 
                //indegree++ for 
                inDegree[v]++;
            }
        }
        
        //process nodes with indegree 0 first
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                queue.add(i);
        }
        
        // don't visit duplicate nodes
        boolean[] visited =new boolean[V];
        int[] distance = new int[V];
        int k=0;
        
        while(!queue.isEmpty()){
            
            int current = queue.poll();
            visited[current] = true;
            //only independent node will be in queue
            // so take from it add
            distance[k++] = current;
            
            for(int next:adj.get(current)){
                if(!visited[next]){
                    inDegree[next]--;
                    if(inDegree[next]==0){
                        queue.add(next);
                    }
                }
            }
            
        }
        
      return distance;  
    }
}

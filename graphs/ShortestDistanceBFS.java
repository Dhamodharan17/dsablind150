class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
      //find shortest distance from src to all using BFS
      // bfs we go step by step and increase len
      //update the mindistance
      
      int[] distance = new int[n];
      Arrays.fill(distance,Integer.MAX_VALUE);
      List<List<Integer>> gList = convert(n,edges);
      
      Queue<Integer> pq = new LinkedList<>();
      pq.add(src);
      distance[src]=0;// distance from src to itself
      
      while(!pq.isEmpty()){
          
          int srcTemp = pq.poll();
          for(int dest: gList.get(srcTemp)){
              // relax - old distance is greater then new incoming distance
              if(distance[srcTemp]+1<distance[dest]){
                      distance[dest] = distance[srcTemp]+1;
                      pq.add(dest);
                      // add queue only when there is short distance
                      // if this node gets shortest distance
                      // its relatives will also get
                      // so add to queue
                }
          }
      }
      
      for(int i=0;i<n;i++){
          if(distance[i]==Integer.MAX_VALUE){
              distance[i]=-1;
          }
      }
      
      return distance;
      
    }

    // converter
    List<List<Integer>> convert(int n,int[][] edges){
        
        List<List<Integer>> gList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            gList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            gList.get(edge[0]).add(edge[1]);
            gList.get(edge[1]).add(edge[0]);
        }
        
        return gList;
        
    }
}

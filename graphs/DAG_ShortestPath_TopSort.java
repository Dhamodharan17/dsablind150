class Solution {
    
    class Pair{
        int dest;
        int wt;
        Pair(int dest,int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
	
	//convert
	List<List<Pair>> gList = convert(N,edges);
	
	// peform toposort
	Stack<Integer> stack = new Stack<>();
	boolean[] vis = new boolean[N];
	topoSort(0,gList,vis,stack);
	
	int[] distance = new int[N];
	Arrays.fill(distance,Integer.MAX_VALUE);
	distance[0] = 0;//distance from src to itself
	
	Arrays.fill(vis,false);
	
	while(!stack.isEmpty()){
	  // now stack has the src of the graph on top
    //u(src)->v(dest)
	   int src = stack.pop();
	   vis[src] = true;
	   
	   for(Pair next:gList.get(src)){
	       if(!vis[next.dest]){
	           //already distance is greater then new incoming
            //u(src)->v(dest)
    	       if(distance[next.dest]>distance[src] + next.wt){
    	           distance[next.dest] = distance[src] + next.wt;
    	       }
	       }
	   }
	}
	
	//unreachable nodes
	for(int i=0;i<distance.length;i++){
	    if(distance[i]==Integer.MAX_VALUE){
	        distance[i] = -1;
	    }
	}
	
	return distance;
	
	}
	
	//toposort
	void topoSort(int current,List<List<Pair>> adj,boolean[] vis,Stack<Integer> stack){
	    
	    vis[current] = true;
	    
	    for(Pair p:adj.get(current)){
	        if(!vis[p.dest])
	            topoSort(p.dest,adj,vis,stack);
	    }
	    stack.add(current);
	}
	
	//convert
	List<List<Pair>> convert(int N,int[][] edges){
	    
	    List<List<Pair>> gList = new ArrayList<>();
	    for(int i=0;i<N;i++) gList.add(new ArrayList<>());
	    
	    for(int[] edge : edges){
	        Pair p = new Pair(edge[1],edge[2]);
	        gList.get(edge[0]).add(p);
	    }
	    
	    return gList;
	}
}

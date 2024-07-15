class Solution {


   static class Pair {
        int src;
        int dest;
        int weight;

        Pair(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

  //type 1 - conversion 0-List.of([][][])
   // for disjoint sets - individual edges
 static int spanningTree(int V, int E, List<List<int[]>> adj) {
         
    List<Pair> edges = new ArrayList<>();
     // extract data  
        for (int i = 0; i < V; i++) {
            for (int[] edge : adj.get(i)) {
                edges.add(new Pair(i, edge[0], edge[1]));
            }
        }
 }

}

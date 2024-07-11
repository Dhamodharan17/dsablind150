import java.util.* ;
import java.io.*; 
public class Solution {
	
	static class Pair{
		int dest;
		int wt;
		Pair(int dest,int wt){
			this.dest = dest;
			this.wt = wt;
		}
	}

	static List<List<Pair>> convert(int vec,ArrayList<ArrayList<Integer>> adj){

		//create vertices
		List<List<Pair>> gList = new ArrayList<>();
		for(int i=0;i<vec;i++) gList.add(new ArrayList<>());

		//pair edges
		for(ArrayList<Integer> edge : adj){
			gList.get(edge.get(0)).add(new Pair(edge.get(1),edge.get(2)));
			gList.get(edge.get(1)).add(new Pair(edge.get(0),edge.get(2)));
		}

		return gList;
	}
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, 
	int vertices, int edges, int source){
		
		// obj - find shortest distance from src to all
		List<List<Pair>> gList = convert(vertices, vec);
		// min heap with weight
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.wt));
		pq.add(new Pair(source, 0));
		
		int[] distance = new int[vertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;//important


		while(!pq.isEmpty()){

			Pair current = pq.poll();//u
			if(current.wt>distance[current.dest]) continue;
			for(Pair next: gList.get(current.dest)){//v
				//u->v
				if(distance[next.dest]>distance[current.dest]+next.wt){
					distance[next.dest] = distance[current.dest]+next.wt;
					pq.add(new Pair(next.dest, distance[next.dest]));//update new distance in heap
					// when shortest distance add to queue
					//because relative will get shortest
				}
			}
		}

		ArrayList<Integer> arrayList = new ArrayList<>();
        for (int number : distance) {
            arrayList.add(number);
        }

		return arrayList;

	}

}

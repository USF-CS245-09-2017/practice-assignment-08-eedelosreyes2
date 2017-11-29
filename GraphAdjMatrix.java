import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class GraphAdjMatrix implements Graph {
	private int[][] edges;

	public GraphAdjMatrix(int v) {
		edges = new int[v][v];
	}
	
	public void addEdge(int v1, int v2) {
		edges[v1][v2] = 1;
	}
	
	public void topologicalSort() {
        int indegree[] = new int[edges.length];  
        for(int i = 0; i < edges.length; i++) {
            int[] temp = edges[i];
            for(int j : temp) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < edges.length; i++) {
            if(indegree[i]==0)
                q.add(i);
        }
        int count = 0;
        Vector <Integer> topOrder = new Vector<Integer>();
        while(!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);
            for (int i = 0; i < edges[u].length; i++) {
                if (--indegree[i] == 0)
                    q.add(i);
            }
            count++;
        }     
        if (count != edges.length) {
            System.out.println("There exists a cycle in the graph");
            return ;
        }      
        for(int i : topOrder) {
            System.out.print(i+" ");
        }
    }

	
	public int[] neighbors(int vertex) {
		int[] neighbors = new int[edges.length];
		int index = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] > 0) 
				neighbors[index++] = i;
		}
		return Arrays.copyOf(neighbors, index);
	}
	
	
	

}

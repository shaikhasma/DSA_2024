import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph : breadth First Search by Asma
 */
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList < Integer > bfs = new ArrayList<> ();
        boolean vis[] = new boolean[V];
        Queue < Integer > q = new LinkedList < > ();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

         //Get all Neighbors
            for (Integer it: adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
     
    }
}
/**
 * TC : 0(V + E)
 * SC : 0(V + E)
 */

/**
 * Graph : Depth First Search 
 * By Asma
 */
class DepthFirstSearch {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     ArrayList<Integer> storeDfs = new ArrayList<>();

           // Code here
       ArrayList<Integer>dfs=new ArrayList<>();
       boolean vis[]=new boolean[V+1];
       for(int i = 0;i<=V - 1 ;i++) {
            if(!vis[i])
            dfs(i, vis, dfs, adj);
        }
      
           

        return dfs;
    }
    public static void dfs(int node, boolean[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj) {
       dfs.add(node);
       vis[node]=true;
       for (Integer it:adj.get(node)){
           if (!vis[it]){
               vis[it]=true;
               dfs(it,vis,dfs,adj);
           }
       }
    }
}
/**
 * TC: 0(V+ 2E)
 *   : 0 (V + E)
 * SC: 0 (V + E)  3V  stack + visited array + adjList 
 */
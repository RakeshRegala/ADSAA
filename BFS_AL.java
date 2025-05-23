import java.util.*;

class BFS {
    // BFS from given source s
    static void bfs(List<List<Integer>> adj, int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    // Function to add an edge to the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) { // Corrected loop starting from 0
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (fixed indices)
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from node 0:");
        bfs(adj, 0);
    }
}

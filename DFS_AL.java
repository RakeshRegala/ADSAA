import java.util.*;

class DFS_AL {
    static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Since it's an undirected graph
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // Initialize adjacency lists
        }

        // Adding edges using addEdge method
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);

        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);
    }
}

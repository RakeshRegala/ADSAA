import java.util.*;

class DFS_AM {
    static void dfs(int[][] adj, boolean[] visited, int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] adj = { 
                { 0, 1, 1, 0, 0 }, 
                { 1, 0, 1, 0, 0 }, 
                { 1, 1, 0, 1, 1 }, 
                { 0, 0, 1, 0, 0 }, 
                { 0, 0, 1, 0, 0 } 
        };

        boolean[] visited = new boolean[5]; // Tracking visited nodes
        dfs(adj, visited, 0);
    }
}

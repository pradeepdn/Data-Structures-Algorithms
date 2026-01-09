class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // 1. Create the structure
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. Fill it (Undirected)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u); // Since it's undirected
        }
        // Use ArrayDeque to implement the Deque interface
        Deque<Integer> trav = new ArrayDeque<>();
        boolean visited[] = new boolean[n];
        trav.add(source);
        visited[source] = true;

        while (!trav.isEmpty()) {
            int curr = trav.poll();

            if (curr == destination) {
                return true;
            }
            List<Integer> neighbors = graph[curr];

            for (int i = 0; i < neighbors.size(); i++) {
                int next = neighbors.get(i);

                if (!visited[next] == true) {
                    visited[next] = true;
                    trav.add(next);
                }
            }
        }
        return false;
    }
}
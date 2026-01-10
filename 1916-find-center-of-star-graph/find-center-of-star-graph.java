class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i <= n; i++) {
            if (graph[i].size() == edges.length) {
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int findCenter(int[][] edges) {

        int center1 = edges[0][0];
        int center2 = edges[0][1];
        for(int i= 1; i<edges.length; i++){
            if(center1 == edges[i][0]) return center1;
            if(center2 == edges[i][1]) return center2;
        }
        return -1;

/**Creating a grap and looking for the center */
        // int n = edges.length + 1;
        // List<Integer>[] graph = new ArrayList[n + 1];
        // for (int i = 0; i <= n; i++) {
        //     graph[i] = new ArrayList<>();
        // }
        // for (int i = 0; i < edges.length; i++) {
        //     int u = edges[i][0];
        //     int v = edges[i][1];
        //     graph[u].add(v);
        //     graph[v].add(u);
        // }
        // for (int i = 0; i <= n; i++) {
        //     if (graph[i].size() == edges.length) {
        //         return i;
        //     }
        // }
        // return -1;
    }
}
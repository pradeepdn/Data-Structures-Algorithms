import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') initialZeros++;
        }

        if (initialZeros == 0) return 0;

        // Parent array handles jumps for both parities. 
        // n + 3 prevents index out of bounds on (curr + 2) jumps.
        int[] parent = new int[n + 3];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        queue.add(initialZeros);
        dist[initialZeros] = 0;
        
        // Mark initial state as visited by pointing it to its next parity neighbor
        parent[initialZeros] = find(initialZeros + 2, parent);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            
            // Mathematical bounds for the next number of zeros
            int lower = Math.abs(x - k);
            int upper = n - Math.abs(n - (x + k));

            // Start "jumping" through unvisited states using Union-Find
            for (int curr = find(lower, parent); curr <= upper; curr = find(curr, parent)) {
                if (curr == 0) return dist[x] + 1;

                if (dist[curr] == -1) {
                    dist[curr] = dist[x] + 1;
                    queue.add(curr);
                }

                // "Delete" this state: point it to the next unvisited of same parity
                parent[curr] = find(curr + 2, parent);
            }
        }

        return -1;
    }

    // Classic Union-Find find with Path Compression
    private int find(int i, int[] parent) {
        if (i >= parent.length) return parent.length - 1;
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }
}
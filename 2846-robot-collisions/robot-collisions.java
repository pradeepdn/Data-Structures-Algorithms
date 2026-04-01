import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        // Sort indices based on positions
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices of right-moving robots

        for (int curr : indices) {
            if (directions.charAt(curr) == 'R') {
                stack.push(curr);
            } else {
                // Current robot is moving Left
                while (!stack.isEmpty() && healths[curr] > 0) {
                    int top = stack.peek();
                    
                    if (healths[top] > healths[curr]) {
                        // Top (Right) wins
                        healths[top] -= 1;
                        healths[curr] = 0;
                    } else if (healths[top] < healths[curr]) {
                        // Current (Left) wins
                        healths[curr] -= 1;
                        healths[top] = 0;
                        stack.pop();
                    } else {
                        // Tie: both destroyed
                        healths[curr] = 0;
                        healths[top] = 0;
                        stack.pop();
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) result.add(h);
        }
        return result;
    }
}
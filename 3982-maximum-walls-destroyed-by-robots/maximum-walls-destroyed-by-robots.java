import java.util.*;

class Solution {
    int[][] robotData;
    int[] sortedWalls;
    Map<String, Integer> memo;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        this.robotData = new int[n][2];
        for (int i = 0; i < n; i++) {
            robotData[i][0] = robots[i];
            robotData[i][1] = distance[i];
        }
        // Sort robots by position
        Arrays.sort(robotData, (a, b) -> Integer.compare(a[0], b[0]));
        
        this.sortedWalls = walls;
        Arrays.sort(sortedWalls);
        
        this.memo = new HashMap<>();
        
        // Start with robot 0, and the "last wall hit" index is -1
        return solve(0, -1);
    }

    private int solve(int i, int lastWallIdx) {
        if (i == robotData.length) return 0;
        
        String key = i + "," + lastWallIdx;
        if (memo.containsKey(key)) return memo.get(key);

        int pos = robotData[i][0];
        int dist = robotData[i][1];

        // --- Option 1: Fire Left ---
        int leftLimit = Math.max(pos - dist, (i == 0) ? Integer.MIN_VALUE : robotData[i-1][0] + 1);
        // Only count walls greater than the lastWallIdx to avoid double counting
        int leftStartVal = (lastWallIdx == -1) ? leftLimit : Math.max(leftLimit, sortedWalls[lastWallIdx] + 1);
        
        int countL = countRange(leftStartVal, pos);
        int newLastWallIdxL = findLastIdxInRange(leftStartVal, pos, lastWallIdx);
        int resL = countL + solve(i + 1, newLastWallIdxL);

        // --- Option 2: Fire Right ---
        int rightLimit = Math.min(pos + dist, (i == robotData.length - 1) ? Integer.MAX_VALUE : robotData[i+1][0] - 1);
        int rightStartVal = (lastWallIdx == -1) ? pos : Math.max(pos, sortedWalls[lastWallIdx] + 1);
        
        int countR = countRange(rightStartVal, rightLimit);
        int newLastWallIdxR = findLastIdxInRange(rightStartVal, rightLimit, lastWallIdx);
        int resR = countR + solve(i + 1, newLastWallIdxR);

        int result = Math.max(resL, resR);
        memo.put(key, result);
        return result;
    }

    private int countRange(int low, int high) {
        if (low > high) return 0;
        int start = Arrays.binarySearch(sortedWalls, low);
        if (start < 0) start = -(start + 1);
        int end = Arrays.binarySearch(sortedWalls, high);
        if (end < 0) end = -(end + 2);
        return Math.max(0, end - start + 1);
    }

    private int findLastIdxInRange(int low, int high, int currentLast) {
        if (low > high) return currentLast;
        int end = Arrays.binarySearch(sortedWalls, high);
        if (end < 0) end = -(end + 2);
        return Math.max(currentLast, end);
    }
}
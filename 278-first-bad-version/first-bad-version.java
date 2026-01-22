/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        /** Linear */
        // for(int i = 0; i<=n; i++){
        //     boolean isBad = isBadVersion(i);
        //     if(isBad == true){
        //         return i;
        //     }
        // }
        // return -1; 
        /**Binary */
        
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid) == true) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;

    }
}
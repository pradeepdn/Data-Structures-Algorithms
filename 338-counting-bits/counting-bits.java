class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1; i< res.length; i++){
            if(i % 2 == 0){
                res[i] = res[i/2];
            }else if(i % 2 !=0){
                res[i] = res[i/2] + 1;
            }
        }
        return res;
    }
}
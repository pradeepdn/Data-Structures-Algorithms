class Solution {
    public int hIndex(int[] citations) {
        int[] c = new int[citations.length+1];
        int count=0;
        for(int i=0;i<citations.length;i++){
            c[Math.min(citations[i], citations.length)]++;
        }
        for(int j=c.length-1;j>=0;j--){
            count = count+c[j];
            if(count >= j){
                return j;
            }
        }
        return -1;
    }
}
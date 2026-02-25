class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] integerArr = new Integer[arr.length];
        for(int i =0; i<arr.length; i++){
            integerArr[i] = arr[i];
        }
        Arrays.sort(integerArr, (a,b) -> {
            int bitcountA = Integer.bitCount(a);
            int bitcountB = Integer.bitCount(b);

            if(bitcountA != bitcountB){
                return bitcountA - bitcountB;
            }
            return a-b;
        });
        for(int i = 0; i< arr.length; i++){
            arr[i] = integerArr[i];
        }
        return arr;
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        digits[i]++;

        while(i > 0 && digits[i] == 10 ){
                digits[i] = 0;
                digits[i-1]++;
                i--;
        }
        if(digits[0]==10){
            int result[] = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    return digits;      
    }
}
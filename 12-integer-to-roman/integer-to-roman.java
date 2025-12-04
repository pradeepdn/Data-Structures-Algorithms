class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> in = new LinkedHashMap<>();

        in.put(1000, "M");
        in.put(900, "CM");
        in.put(500, "D");
        in.put(400, "CD");
        in.put(100, "C");
        in.put(90, "XC");
        in.put(50, "L");
        in.put(40, "XL");
        in.put(10, "X");
        in.put(9, "IX");
        in.put(5, "V");
        in.put(4, "IV");
        in.put(1, "I");

        StringBuilder result = new StringBuilder();

        for(int key : in.keySet()){
            while(num>=key){
                num -= key;
                result.append(in.get(key));
            }
        }

        return result.toString();
    }
}
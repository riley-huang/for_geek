class Homework1_1 {
    public int[] plusOne(int[] digits) {
        int r = digits.length-1;
        if(digits[r]!=9){
            digits[r] = digits[r] + 1;
            return digits;
        }else{
            digits[r--] = 0;
            while(r>=0 && digits[r]==9){
                digits[r--]=0;
            }
            if(r<0){
                int[] ary = new int[digits.length+1];
                ary[0] = 1;
                return ary;
            }else{
                digits[r] = digits[r] + 1;
                return digits;
            }
        }
    }
}
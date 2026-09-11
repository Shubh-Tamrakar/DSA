class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        
        
        for (int num = 100; num < 1000; num += 2) {
            if (canForm(num, digits)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean canForm(int num, int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        while (num > 0) {
            int digit = num % 10;
            count[digit]--;
            if (count[digit] < 0) {
                return false;
            }
            num /= 10;
        }
        
        return true;
    }
}
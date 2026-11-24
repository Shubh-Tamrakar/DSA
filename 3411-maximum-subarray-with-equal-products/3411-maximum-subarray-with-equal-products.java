class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1L;
            int curGcd = 0;
            int curLcm = 1;

            for (int j = i; j < n; j++) {
                int x = nums[j];
                prod *= x;
                curGcd = (curGcd == 0) ? x : gcd(curGcd, x);
                curLcm = lcm(curLcm, x);

                long rhs = (long) curLcm * curGcd;
                if (prod == rhs) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
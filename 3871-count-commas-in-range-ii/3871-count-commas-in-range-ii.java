class Solution {

    public long countCommas(long n) {

        int dig = String.valueOf(n).length();

        if (dig < 4) return 0;

        long ans = 0;

        for (int i = 4; i <= dig; i++) {

            long comma = (i - 1) / 3;

            if (i == dig) {

                ans += (n - (long)Math.pow(10, i - 1) + 1) * comma;

            } else {

                ans += ((long)Math.pow(10, i) -
                        (long)Math.pow(10, i - 1)) * comma;
            }
        }

        return ans;
    }
}
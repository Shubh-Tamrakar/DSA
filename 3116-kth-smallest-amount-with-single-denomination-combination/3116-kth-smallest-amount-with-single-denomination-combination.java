import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int c : coins)
            high = Math.min(high, (long) c * k);

        while (low < high) {

            long mid = low + (high - low) / 2;
            long count = 0;

            int n = coins.length;

            for (int mask = 1; mask < (1 << n); mask++) {

                long lcm = 1;
                int bits = 0;
                boolean ok = true;

                for (int i = 0; i < n; i++) {

                    if ((mask & (1 << i)) != 0) {

                        bits++;

                        long g = gcd(lcm, coins[i]);
                        lcm = (lcm / g) * coins[i];

                        if (lcm > mid) {
                            ok = false;
                            break;
                        }
                    }
                }

                if (ok) {
                    if (bits % 2 == 1)
                        count += mid / lcm;
                    else
                        count -= mid / lcm;
                }
            }

            if (count >= k)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
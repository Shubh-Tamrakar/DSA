class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        // Count remainders
        for (int x : stones) {
            cnt[x % 3]++;
        }

        // Number of remainder-0 stones is even
        if (cnt[0] % 2 == 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }

        // Number of remainder-0 stones is odd
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}
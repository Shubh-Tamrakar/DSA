class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Find the position (index) of the number 0.
        // Everything else is checked relative to this position.
        int zeroPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroPos = i;
                break;
            }
        }

        // Step 2: Check if the array is a "circular" sorted order.
        // goingRight = true means: starting at 0 and walking RIGHT (wrapping around),
        //              we see 0, 1, 2, ..., n-1
        // goingLeft  = true means: starting at 0 and walking LEFT (wrapping around),
        //              we see 0, 1, 2, ..., n-1
        boolean goingRight = true;
        boolean goingLeft = true;

        for (int step = 0; step < n; step++) {
            // "% n" makes the index wrap around the array like a circle.
            int rightIndex = (zeroPos + step) % n;
            int leftIndex = (zeroPos - step + n) % n; // "+ n" avoids negative index

            // After `step` moves from 0, the value should be exactly `step`.
            if (nums[rightIndex] != step) {
                goingRight = false;
            }
            if (nums[leftIndex] != step) {
                goingLeft = false;
            }
        }

        // Step 3: Compute the minimum cost for each valid pattern.
        int answer = Integer.MAX_VALUE;

        if (goingRight) {
            // Option A: cost is zeroPos
            // Option B: cost is (n - zeroPos + 2)
            answer = Math.min(answer, Math.min(zeroPos, n - zeroPos + 2));
        }

        if (goingLeft) {
            // Option A: cost is (zeroPos + 2)
            // Option B: cost is (n - zeroPos)
            answer = Math.min(answer, Math.min(zeroPos + 2, n - zeroPos));
        }

        // Step 4: If neither pattern matched, it's impossible.
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
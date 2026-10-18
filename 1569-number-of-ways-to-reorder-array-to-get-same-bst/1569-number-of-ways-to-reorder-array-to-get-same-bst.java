import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Initialize Pascal's Triangle for combinations: C[n][k]
        table = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) (countWays(list) - 1 + MOD) % MOD;
    }

    private long countWays(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> leftTree = new ArrayList<>();
        List<Integer> rightTree = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                leftTree.add(nums.get(i));
            } else {
                rightTree.add(nums.get(i));
            }
        }

        long leftWays = countWays(leftTree) % MOD;
        long rightWays = countWays(rightTree) % MOD;

        int leftSize = leftTree.size();
        int rightSize = rightTree.size();

        // Ways to interleave left and right subtree sequences while preserving their relative order: C(leftSize + rightSize, leftSize)
        long combinations = table[leftSize + rightSize][leftSize];

        return (((combinations * leftWays) % MOD) * rightWays) % MOD;
    }
}
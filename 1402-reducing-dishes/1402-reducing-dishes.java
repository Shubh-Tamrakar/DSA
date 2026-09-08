import java.util.*;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int sum = 0;
        int ans = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {

            sum += satisfaction[i];

            // Agar current dish ko include karne se benefit hai
            if (sum > 0) {
                ans += sum;
            } else {
                break;
            }
        }

        return ans;
    }
}
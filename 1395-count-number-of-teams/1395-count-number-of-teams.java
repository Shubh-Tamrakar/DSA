class Solution {
    public int numTeams(int[] rating) {

        int count = 0;
        int n = rating.length;

        for (int j = 0; j < n; j++) {

            int leftSmaller = 0;
            int leftGreater = 0;

            int rightSmaller = 0;
            int rightGreater = 0;

            // Left side
            for (int i = 0; i < j; i++) {

                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } 
                else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // Right side
            for (int k = j + 1; k < n; k++) {

                if (rating[k] > rating[j]) {
                    rightGreater++;
                } 
                else if (rating[k] < rating[j]) {
                    rightSmaller++;
                }
            }

            // Increasing: i < j < k
            count += leftSmaller * rightGreater;

            // Decreasing: i > j > k
            count += leftGreater * rightSmaller;
        }

        return count;
    }
}
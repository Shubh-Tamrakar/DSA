class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {

        // Closest x-coordinate of rectangle from circle center
        int closestX = Math.max(x1, Math.min(xCenter, x2));

        // Closest y-coordinate of rectangle from circle center
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance between circle center and closest point
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        // Check whether this distance is <= radius
        return dx * dx + dy * dy <= radius * radius;
    }
}
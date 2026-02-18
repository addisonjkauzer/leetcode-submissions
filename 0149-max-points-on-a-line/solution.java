class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int maxPoints = 2;

        for (int[] point1 : points) {
            for (int[] point2 : points) {
                if (point1 != point2) {
                    double slope1 = point2[0] - point1[0] == 0 ? Integer.MAX_VALUE : (double)(point2[1] - point1[1]) / (point2[0] - point1[0]);
                    int pointsInLine = 2;
                    for (int[] point3 : points) {
                        if (point2 != point3 && point1 != point3) {
                            double slope2 = point3[0] - point2[0] == 0 ? Integer.MAX_VALUE : (double)(point3[1] - point2[1]) / (point3[0] - point2[0]);
                            if (slope2 == slope1) {
                                pointsInLine++;
                            }   
                        }
                    }
                    maxPoints = Math.max(maxPoints, pointsInLine);
                }
            }
        }
        return maxPoints;
    }
}
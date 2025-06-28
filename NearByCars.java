import java.util.*;

public class NearByCars {
    public static List<int[]> findNearestCars(int[][] pts, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB);
        });

        for (int i = 0; i < pts.length; i++) {
            minHeap.offer(pts[i]);
        }

        List<int[]> result = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] pts = {
            {1, 2},
            {3, 4},
            {1, -1},
            {2, 2}
        };

        List<int[]> nearest = findNearestCars(pts, 2);

        for (int[] point : nearest) {
            System.out.println("Location: (" + point[0] + ", " + point[1] + ")");
        }
    }
}

import java.util.*;

public class WeakestSoldier {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            pq.offer(new int[]{soldiers, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] == 1) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        WeakestSoldier solver = new WeakestSoldier();
        int[][] mat = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        int k = 3;
        int[] result = solver.kWeakestRows(mat, k);
        System.out.println("Indices of the " + k + " weakest rows: " + Arrays.toString(result));
    }
}

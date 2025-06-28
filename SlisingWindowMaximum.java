import java.util.*;

class WindowSolver {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return new int[0];
    }
}

public class SlisingWindowMaximum extends WindowSolver {

    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0] // max heap by value
        );

        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});

            if (i >= k - 1) {
                while (maxHeap.peek()[1] <= i - k) {
                    maxHeap.poll();
                }
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WindowSolver solver = new SlisingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = solver.maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result));
    }
}

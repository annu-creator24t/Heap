import java.util.*;

public class ConnectsNRopes {
    public int minCostToConnectRopes(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            int cost = min1 + min2;
            totalCost += cost;
            minHeap.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        ConnectsNRopes solver = new ConnectsNRopes();
        int[] ropes = {4, 3, 2, 6};
        int result = solver.minCostToConnectRopes(ropes);
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}

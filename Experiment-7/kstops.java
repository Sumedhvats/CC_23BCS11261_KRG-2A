import java.util.*;

class Triplet {
    int stops;
    int cost;
    int node;

    public Triplet(int stops, int cost, int node) {
        this.stops = stops;
        this.cost = cost;
        this.node = node;
    }
}

class Pair {
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new Pair(v, w));
        }

        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(0, 0, src));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            Triplet tp = queue.poll();
            int stops = tp.stops;
            int cost = tp.cost;
            int node = tp.node;

            if (stops > k) continue;

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int edgeCost = p.cost;

                if (cost + edgeCost < dist[adjNode]) {
                    dist[adjNode] = cost + edgeCost;
                    queue.add(new Triplet(stops + 1, cost + edgeCost, adjNode));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


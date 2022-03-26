class Solution {
    
    private static final long lMax = (long) (1e15), mod = (int) (1e9 + 7);
    private static List<List<Pair>> adjList;
    private static int n;
    private static long[] min_dist;
    private static long[] dp;
    private static boolean[] vis;
    public int countRestrictedPaths(int _n, int[][] edges) {
        
        n = _n;
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) addEdge(edge[0], edge[1], edge[2]);
        
        min_dist = dijkstras();
        vis = new boolean[n + 1];
        dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return (int) restPaths(n);
    }
    
    private static long restPaths(int curr) {
        
        if (curr == 1) return 1;
        
        if (dp[curr] != -1) return dp[curr];
        vis[curr] = true;
        long ans = 0;
        for (Pair p : adjList.get(curr)) {
            if (vis[p.x] || min_dist[p.x] <= min_dist[curr]) continue;
            ans = (ans + restPaths(p.x)) % mod;
        }
        
        vis[curr] = false;
        return dp[curr] = ans;
    }
    
    private static long[] dijkstras() {
        
        long[] dist = new long[n + 1];
        Arrays.fill(dist, lMax);
        dist[n] = 0;
        boolean[] visited = new boolean[n + 1];
        
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.y));
        pq.offer(new Pair(n, 0));
        while (!pq.isEmpty()) {
            
            Pair top = pq.poll();
            if (dist[top.x] < top.y) continue;
            visited[top.x] = true;
            for (Pair p : adjList.get(top.x)) {
                if (visited[p.x]) continue;
                long wt = dist[top.x] + p.y;
                if (wt < dist[p.x]) {
                    dist[p.x] = wt;
                    pq.add(new Pair(p.x, wt));
                }
            }
        }
        
        return dist;
    }
    
    private static void addEdge(int a, int b, long w) {
        adjList.get(a).add(new Pair(b, w));
        adjList.get(b).add(new Pair(a, w));
    }
    
    private static class Pair {
        int x;
        long y;
        Pair (int x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
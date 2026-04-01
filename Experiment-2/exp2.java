class Solution {
    public int maxPoints(int[][] p) {
        int n = p.length;
        if(n <= 2) return n;
        int ans = 0;

        for(int i = 0; i < n; i++){
            Map<String,Integer> map = new HashMap<>();
            int dup = 1;
            int max = 0;

            for(int j = i + 1; j < n; j++){
                int x1 = p[i][0], y1 = p[i][1];
                int x2 = p[j][0], y2 = p[j][1];

                if(x1 == x2 && y1 == y2){
                    dup++;
                } else {
                    int dx = x2 - x1;
                    int dy = y2 - y1;

                    int g = gcd(dx, dy);
                    dx /= g;
                    dy /= g;

                    String key = dx + "#" + dy;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
            }

            ans = Math.max(ans, max + dup);
        }

        return ans;
    }

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}

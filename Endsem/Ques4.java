public class Ques4 {
   public int findCircleNum(int[][] arr) {
        DSU dsu = new DSU(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dsu.find(i) == i)
                cnt++;
        }
        return cnt;
    }
    public class DSU {
        int[] par;
        int[] size;

        DSU(int v) {
            par = new int[v + 1];
            size = new int[v + 1];
            for (int i = 0; i <= v; i++) {
                    par[i] = i;
                size[i] = 1;
            }
        }
        int find(int u) {
            if (par[u] == u)
                return u;
            par[u] = find(par[u]);
            return par[u];
        }
        void union(int u, int v) {
            int parU = find(u);
            int parV = find(v);
            if (parU == parV)
                return;

            if (size[parU] < size[parV]) {
                par[parU] = parV;
                size[parV] += size[parU];
            } else {
                par[parV] = parU;
                size[parU] += size[parV];
            }
        }

    }
}

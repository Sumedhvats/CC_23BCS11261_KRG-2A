class Solution {
    static int m, n;
    static int[][] dp = new int[1001][1001];

    public String shortestCommonSupersequence(String str1, String str2) {
        m = str1.length();
        n = str2.length();
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = f(s1, s2, 0, 0);
        StringBuilder sb = new StringBuilder(ans);
        int i = 0, j = 0;
        while (i < m && j < n){
            if(s1[i]==s2[j]){
                sb.append(s1[i]);
                i++;
                j++;
            } else if(dp[i+1][j] <= dp[i][j+1]){
                sb.append(s1[i++]);
            } else sb.append(s2[j++]);
        }
        while (i < m)sb.append(s1[i++]);
        while (j < n)sb.append(s2[j++]);

        return sb.toString();
    }

    int f(char[] s1, char[] s2, int i, int j){
        if(i == m)return dp[i][j] = n-j;
        if(j == n)return dp[i][j] = m-i;
        if(dp[i][j] != -1)return dp[i][j];
        int ans;

        char c1 = s1[i];
        char c2 = s2[j];

        if(c1 == c2){
            ans = 1 + f(s1, s2, i+1,j+1);
        } else {
            ans = Math.min(f(s1, s2, i+1, j), f(s1, s2, i, j+1))+1;
        }
        
        dp[i][j] = ans;
        return ans;
    }
}

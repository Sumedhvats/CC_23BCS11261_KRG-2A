class Solution {
public:
    const long long MOD = 1e9 + 7;

    long long gcd(long long a, long long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    int nthMagicalNumber(int n, int a, int b) {
        
        long long l = min(a, b);
        long long r = (long long)n * l;

        long long lcm = (1LL * a * b) / gcd(a, b);

        while (l < r) {
            long long mid = l + (r - l) / 2;

            long long count = mid / a + mid / b - mid / lcm;

            if (count < n)
                l = mid + 1;
            else
                r = mid;
        }
        return l % MOD;
    }
};

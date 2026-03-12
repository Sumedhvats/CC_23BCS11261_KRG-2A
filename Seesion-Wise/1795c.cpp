
//Date-25/02/26

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

void solve() {
    int n;
    cin >> n;
    vector<ll> a(n), b(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) cin >> b[i];

    vector<ll> pref_b(n + 1, 0);
    for (int i = 0; i < n; i++) {
        pref_b[i + 1] = pref_b[i] + b[i];
    }

    vector<ll> diff(n + 1, 0);
    vector<ll> extra(n + 1, 0);

    for (int i = 0; i < n; i++) {
        int j = upper_bound(pref_b.begin(), pref_b.end(), a[i] + pref_b[i]) - pref_b.begin() - 1;

        if (i < j) {
            diff[i]++;
            diff[j]--;
        }

        if (j < n) {
            ll remaining = a[i] - (pref_b[j] - pref_b[i]);
            extra[j] += remaining;
        }
    }

    ll current_full_teas = 0;
    for (int i = 0; i < n; i++) {
        current_full_teas += diff[i];
        ll total_drunk = (current_full_teas * b[i]) + extra[i];
        cout << total_drunk << (i == n - 1 ? "" : " ");
    }
    cout << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
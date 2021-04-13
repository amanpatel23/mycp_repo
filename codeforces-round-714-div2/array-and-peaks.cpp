#include <bits/stdc++.h>

#define int long long
#define mod 1000000007
#define i_max INT_MAX
#define i_min INT_MIN
#define s_i set<int>
#define v_i vector<int>
#define v_s vector<string>
#define v_c vector<char>
#define stk_i stack<int>
#define q_i queue<int>
#define qp_ii queue<pair<int, int>>
#define pqp_ii priority_queue<pair<int, int>>
#define vp_ii vector<pair<int, int>>
#define um_ii unordered_map<int, int>
#define m_ii map<int, int>
#define m_iv_i map<int, vector<int>>
#define p_ii pair<int, int>
#define f first
#define s second
#define mp make_pair
#define pb push_back
#define nline "\n"
#define yes cout << "YES" \
                 << "\n"
#define no cout << "NO" \
                << "\n"
#define for_0(n) for (int i = 0; i < n; i++)
#define for_1(n) for (int i = 1; i <= n; i++)
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

using namespace std;

void solve() {

    int n, k;
    cin >> n >> k;

    int max_peak;
    int temp = n;
    if (!(n & 1))
        temp -= 1;
    max_peak = temp >> 1;

    if (k > max_peak) {
        cout << -1 << nline;
    } else {
        v_i result_arr(n);
        for_0(n)result_arr[i] = i + 1;

        int curr = 1, next;
        while (k--) {
            next = curr + 1;
            int temp = result_arr[next];
            result_arr[next] = result_arr[curr];
            result_arr[curr] = temp;

            curr += 2;
        }

        for_0(n)cout << result_arr[i] << " ";
        cout << nline;
    }
}

int32_t main() {

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t;
    t = 1;
    cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
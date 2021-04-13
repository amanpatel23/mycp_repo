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

    int n;
    cin >> n;
    v_i nums(n + 1);

    for_1(n) {
        cin >> nums[i];
    }

    int a = nums[1], b = nums[2], c = nums[3];
    int same, diff_in;
    if (a == b && b == c && a == c) {
        same = a;
        for (int i = 4; i <= n; i++) {
            if (nums[i] != same) {
                diff_in = i;
                break;
            }
        }
    } else if (a != b) {
        if (a == c)
            diff_in = 2;
        else if (b == c)
            diff_in = 1;
    } else if (a != c) {
        if (a == b)
            diff_in = 3;
        else if (c == b)
            diff_in = 1;
    } else if (b != c) {
        if (b == a)
            diff_in = 3;
        else if (c == a)
            diff_in = 2;
    }

    cout << diff_in << nline;
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
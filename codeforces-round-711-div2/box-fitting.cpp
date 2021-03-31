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

    int n, w;
    cin >> n >> w;

    v_i widths(20, 0);
    int temp;
    for_0(n) {
        cin >> temp;
        temp = log2(temp);
        widths[temp]++;
    }

    int result_layer = 0;
    int current_width, i;
    while (n) {
        i = 19;
        current_width = w;
        while (i >= 0) {
            if (widths[i]) {
                int temp_width = pow(2, i);
                if (temp_width <= current_width) {
                    current_width -= temp_width;
                    widths[i]--;
                    n--;
                    i++;
                }
            }

            i--;
        }
        result_layer += 1;
    }

    cout << result_layer << nline;
}

int32_t main() {

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t;
    cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
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

    n += 2;
    v_i b_arr(n);
    int total_sum = 0;
    for_0(n) {
        cin >> b_arr[i];
        total_sum += b_arr[i];
    }

    // cout<<total_sum<<nline;
    sort(b_arr.begin(), b_arr.end());
//    for(auto x: b_arr)
//        cout<<x<<" ";
//    cout<<nline;

    bool flag = false;
    int x, sum;
    for_0(n) {
        if (i == n - 1) {
            x = b_arr[i];
            sum = b_arr[n - 2];

            total_sum -= x;
            if (total_sum - sum == sum) {
                flag = true;
                b_arr[i] = -1;
                b_arr[n - 2] = -1;
                break;
            }

            total_sum += x;
        } else {
            x = b_arr[i];
            sum = b_arr[n - 1];
            total_sum -= x;
            if (total_sum - sum == sum) {
                flag = true;
                b_arr[i] = -1;
                b_arr[n - 1] = -1;
                break;
            }

            total_sum += x;
        }
    }

    if (flag) {
        for_0(n) {
            if (b_arr[i] != -1)
                cout << b_arr[i] << " ";
        }

        cout << nline;
    } else
        cout << -1 << nline;
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
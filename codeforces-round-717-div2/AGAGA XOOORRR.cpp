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
#define p_ii pair<int, int>
#define all(a) (a).begin(), (a).end()
#define mem1(a) memset(a, -1, sizeof(a))
#define mem0(a) memset(a, 0, sizeof(a))
#define lbnd lower_bond
#define ubnd upper_bond
#define ff first
#define ss second
#define mp make_pair
#define pb push_back
#define nline "\n"
#define yes (cout << "YES" << "\n")
#define no (cout << "NO" << "\n")
#define rep(i, a, b) for(int i = a; i < b; i++)
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

using namespace std;

int mod_mul(int a, int b) { return ((a * b) % mod); }

int mod_add(int a, int b) { return ((a + b) % mod); }

int power(int a, int n) {
    int res = 1;
    while (n) { if (n & 1) res = mod_mul(res, a), n--; else a = mod_mul(a, a), n >>= 1; }
    return res;
}


void solve() {

    int n;
    cin >> n;

    v_i nums(n);
    v_i prefix_xor(n);
    int temp;
    int result_xor = 0;
    rep(i, 0, n) {
        cin >> temp;
        nums[i] = temp;
        result_xor ^= temp;
        prefix_xor[i] = result_xor;
    }

    if (result_xor == 0)
        yes;
    else {
        bool flag = false;
        for (int i = 0; i < n; i++) {
            int to_match = prefix_xor[i];
            int temp_xor = 0;
            bool temp_flag = false;
            int j;
            for (j = i + 1; j < n; j++) {
                temp_xor ^= nums[j];
                if (temp_xor == to_match) {
                    temp_xor = 0;
                    temp_flag = true;
                    break;
                }
            }
            if (temp_flag) {
                for (int k = j + 1; k < n; k++) {
                    temp_xor ^= nums[k];
                }
                if (temp_xor == to_match) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
            yes;
        else
            no;
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
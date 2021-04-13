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

    char arr[n][n];
    int f_r, f_c, s_r, s_c;
    bool flag = true;

    char temp;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> temp;
            if (temp == '*') {
                if (flag) {
                    f_r = i, f_c = j;
                    flag = false;
                } else {
                    s_r = i, s_c = j;
                }
            }

            arr[i][j] = temp;
        }
    }

    bool is_same_row = false, is_same_col = false;
    if (f_r == s_r)
        is_same_row = true;
    else if (f_c == s_c)
        is_same_col = true;

    if (is_same_row) {
        if (f_r != 0) {
            arr[0][f_c] = '*';
            arr[0][s_c] = '*';
        } else {
            arr[n - 1][f_c] = '*';
            arr[n - 1][s_c] = '*';
        }
    } else if (is_same_col) {
        if (f_c != 0) {
            arr[f_r][0] = '*';
            arr[s_r][0] = '*';
        } else {
            arr[f_r][n - 1] = '*';
            arr[s_r][n - 1] = '*';
        }
    } else {
        arr[f_r][s_c] = '*';
        arr[s_r][f_c] = '*';
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << arr[i][j];
        }
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
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

    int a, b;
    cin >> a >> b;

    string s;
    cin >> s;

    int n = a + b;

    vp_ii replace;
    bool flag = true;
    int i = 0, j = n - 1;
    while (j - i >= 1) {
        if ((s[i] == '0' && s[j] == '1') || (s[i] == '1' && s[j] == '0')) {
            flag = false;
            break;
        } else if ((s[i] == '0' && s[j] == '?') || (s[i] == '?' && s[j] == '0')) {
            if (a < 2) {
                flag = false;
                break;
            } else {
                s[i] = '0', s[j] = '0';
                a -= 2;
            }
        } else if ((s[i] == '1' && s[j] == '?') || (s[i] == '?' && s[j] == '1')) {
            if (b < 2) {
                flag = false;
                break;
            } else {
                s[i] = '1', s[j] = '1';
                b -= 2;
            }
        } else if (s[i] == s[j]) {
            if (s[i] == '0') {
                if (a < 2) {
                    flag = false;
                    break;
                } else
                    a -= 2;
            } else if (s[i] == '1') {
                if (b < 2) {
                    flag = false;
                    break;
                } else
                    b -= 2;
            } else if (s[i] == '?') {
                replace.pb(mp(i, j));
            }
        }

        i++, j--;
    }

    if (flag) {
        bool _flag = true;
        for (int k = 0; k < replace.size(); k++) {
            if (a >= 2)
                s[replace[k].first] = '0', s[replace[k].second] = '0', a -= 2;
            else if (b >= 2)
                s[replace[k].first] = '1', s[replace[k].second] = '1', b -= 2;
            else {
                _flag = false;
                break;
            }
        }

        if (n & 1) {
            int pos = n / 2;
            if (s[i] == '0')
                a -= 1;
            else if (s[i] == '1')
                b -= 1;
            else {
                if (a == 1)
                    s[pos] = '0', a -= 1;
                else if (b == 1)
                    s[pos] = '1', b -= 1;
                else {
                    _flag = false;
                }
            }
        }

        if (_flag) {
            if (a == 0 && b == 0)
                cout << s << nline;
            else
                cout << -1 << nline;
        } else {
            cout << -1 << nline;
        }
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
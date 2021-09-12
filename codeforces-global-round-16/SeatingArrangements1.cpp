/* 
Author: Aman Patel
Date: 12-09-2021
*/

#include <iostream>
#include <vector>
#include <map>
#include <list>
#include <set>
#include <algorithm>
#include <queue>
#include <stack>
#include <cstring>
#include <cmath>
#include <bitset>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <cstdlib>
#include <iomanip>

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
#define yes (cout << "YES" << nline)
#define no (cout << "NO" << nline)
#define rep(i, a, b) for(int i = a; i < b; i++)
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

using namespace std;

bool _sort(const p_ii &a, const p_ii &b) {
    if (a.first == b.first)
        return (a.second > b.second);
    return (a.first < b.first);
}

void solve()
{

    int n, m;
    cin >> n >> m;

    vp_ii eyeSightWithIdx;
    for (int i = 0; i < m; i++) {
        int eyeSight;
        cin >> eyeSight;
        eyeSightWithIdx.pb(mp(eyeSight, i));
    }

    sort(all(eyeSightWithIdx), _sort);
//    for (p_ii x: eyeSightWithIdx) {
//        cout << x.first << " " << x.second << nline;
//    }

    int sittingPos[m];
    for (int i = 0; i < m; i++) {
        sittingPos[eyeSightWithIdx[i].second] = i;
    }

    int result = 0;
    for (int i = 0; i < m; i++) {
        int _count = 0;
        for (int j = 0; j < i; j++) {
            if (sittingPos[j] < sittingPos[i])
                _count++;
        }

        result += _count;
    }

    cout << result << nline;
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
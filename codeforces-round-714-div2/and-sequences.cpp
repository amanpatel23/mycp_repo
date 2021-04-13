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

const int N = 2 * 1e5 + 10;
int facts[N];
int factsInvs[N];

int mul(int a, int b) {
    return (a * 1LL * b) % mod;
}

int add(int a, int b) {
    return (a + b) % mod;
}

int power(int a, int n) {
    int res = 1;
    while (n) {
        if (n & 1)
            res = mul(res, a), n--;
        else
            a = mul(a, a), n >>= 1;
    }
    return res;
}

void precomp() {
    facts[0] = 1;
    for (int i = 1; i < N; i++) facts[i] = mul(i, facts[i - 1]);
    for (int i = 0; i < N; i++) factsInvs[i] = power(facts[i], mod - 2);
}

int nCk(int n, int k) {
    return mul(facts[n], mul(factsInvs[k], factsInvs[n - k]));
}

void solve() {

    int n;
    cin >> n;

    // cout<<facts[n]<<nline;
    m_ii nums_freq;
    int temp;
    for_0(n) {
        cin >> temp;
        nums_freq[temp]++;
    }

    m_ii::iterator it = nums_freq.begin();
    int min_el = it->first, min_el_freq = it->second;
    for (it = nums_freq.begin(); it != nums_freq.end(); it++) {
        if ((it->first & min_el) != min_el) {
            cout << 0 << nline;
            return;
        }
    }

    int result_num = (min_el_freq >= 2) ? mul(facts[n - 2], mul(2, nCk(min_el_freq, 2))) : 0;

    cout << result_num << nline;
}

int32_t main() {

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    precomp();

    int t;
    t = 1;
    cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
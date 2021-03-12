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

// ? Come back please...
int h, m, hh, mm;
int mirr[10] = {0, 1, 5, -1, -1, 2, -1, -1, 8, -1};

bool check(int new_hh, int new_mm)
{

    if (mirr[new_hh / 10] == -1 || mirr[new_hh % 10] == -1 || mirr[new_mm / 10] == -1 || mirr[new_mm % 10] == -1)
        return false;
    int mirr_hh = mirr[new_mm % 10] * 10 + mirr[new_mm / 10];
    int mirr_mm = mirr[new_hh % 10] * 10 + mirr[new_hh / 10];

    return mirr_hh < h && mirr_mm < m;
}
void solve()
{
    scanf("%d%d", &h, &m);
    scanf("%d:%d", &hh, &mm);

    int new_hh = hh, new_mm = mm;

    while (new_hh != 0 || new_mm != 0)
    {

        if (check(new_hh, new_mm))
            break;
        if (new_mm == m - 1)
            new_hh = (new_hh + 1) % h;
        new_mm = (new_mm + 1) % m;
    }

    printf("%d%d:%d%d\n", new_hh / 10, new_hh % 10, new_mm / 10, new_mm % 10);
}
int32_t main()
{

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t;
    scanf("%d", &t);

    while (t--)
    {

        solve();
    }

    return 0;
}
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

void solve()
{

    int n;
    //scanf("%d", &n);
    cin >> n;

    v_i x_dist, y_dist;
    for_1(2 * n)
    {
        int x, y;
        for_1(2)
        {
            if (i == 1)
                cin >> x;
            else if (i == 2)
                cin >> y;
        }

        //x = abs(x), y = abs(y);
        //int temp_x = abs(x), temp_y = abs(y);
        if (x == 0)
            y_dist.push_back(abs(y));
        else if (y == 0)
            x_dist.push_back(abs(x));
    }

    sort(x_dist.begin(), x_dist.end());
    sort(y_dist.begin(), y_dist.end());

    double total_dist = 0.;
    for_0(n)
    {
        total_dist += sqrt((pow(x_dist[i], 2.)) + pow(y_dist[i], 2.));
    }

    printf("%.15f\n", total_dist);
}
int32_t main()
{

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t;
    //scanf("%d", &t);
    cin >> t;

    while (t--)
    {

        solve();
    }

    return 0;
}
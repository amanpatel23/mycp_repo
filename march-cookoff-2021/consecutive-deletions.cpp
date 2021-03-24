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

    int n, k;
    cin >> n >> k;

    int total_ones = 0;
    v_i nums(n + 1);

    int temp;
    for_1(n)
    {
        cin >> temp;
        if (temp == 1)
            total_ones += 1;
        nums[i] = temp;
    }

    //cout<<total_ones<<nline;
    if (total_ones == 0)
    {
        cout << 0 << nline;
    }
    else
    {
        int min_cost = 0;
        int l, r;
        l = 1;
        r = k;

        int global_ones = i_max, curr_ones = 0;
        for (int i = l; i <= r; i++)
        {
            if (nums[i] == 1)
                curr_ones += 1;
        }

        if (curr_ones > 0 && curr_ones < global_ones)
        {
            global_ones = curr_ones;
        }

        l = 2;
        while (l <= n - k + 1)
        {
            r = l + k - 1;

            if (nums[l - 1] == 1)
                curr_ones -= 1;
            if (nums[r] == 1)
                curr_ones += 1;

            if (curr_ones > 0 && curr_ones < global_ones)
            {
                global_ones = curr_ones;
            }

            l++;
        }

        int temp_cost = (global_ones * (global_ones + 1)) / 2;
        min_cost += temp_cost;

        min_cost += (total_ones - global_ones);

        cout << min_cost << nline;
    }
}

int32_t main()
{

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t;
    cin >> t;

    while (t--)
    {

        solve();
    }

    return 0;
}
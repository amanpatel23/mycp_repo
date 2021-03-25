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

    string a, b;
    cin >> a >> b;
    int a_len = a.size(), b_len = b.size();
    int result_count = 0;
    //cout<<a_len<<b_len<<nline;

    int global_max;
    if (a_len <= b_len)
    {
        global_max = 0;
        for (int i = 0; i < a_len; i++)
        {
            int max_len = a_len - i;
            while (max_len)
            {
                string temp_str = a.substr(i, max_len);
                size_t found = b.find(temp_str, 0);

                if (found != string::npos)
                {
                    global_max = max(global_max, max_len);
                }

                max_len--;
            }
        }
    }
    else
    {
        global_max = 0;
        for (int i = 0; i < b_len; i++)
        {
            int max_len = b_len - i;
            while (max_len)
            {
                string temp_str = b.substr(i, max_len);
                size_t found = a.find(temp_str, 0);

                if (found != string::npos)
                {
                    global_max = max(global_max, max_len);
                }

                max_len--;
            }
        }
    }

    result_count += ((b_len - global_max) + (a_len - global_max));

    cout << result_count << nline;
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
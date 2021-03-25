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

    string s;
    cin >> s;

    int result_count = 0;
    int first_pos, last_pos;
    int i = 0;
    while (true)
    {
        if (s[i] == '*')
        {
            first_pos = i;
            break;
        }

        i++;
    }

    i = n - 1;
    while (true)
    {
        if (s[i] == '*')
        {
            last_pos = i;
            break;
        }

        i--;
    }

    if (first_pos == last_pos)
        result_count += 1;
    else
        result_count += 2;

    while (last_pos - first_pos > k)
    {
        int temp_last = first_pos + 1;
        int temp_prev_last;
        while (temp_last < n)
        {
            if (s[temp_last] == '*')
            {
                if (temp_last - first_pos < k)
                    temp_prev_last = temp_last;
                else if (temp_last - first_pos == k)
                {
                    result_count += 1;
                    break;
                }
                else
                {
                    result_count += 1;
                    temp_last = temp_prev_last;
                    break;
                }
            }

            temp_last++;
        }

        //cout << "temp_last: " << temp_last << nline;
        first_pos = temp_last;
    }

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
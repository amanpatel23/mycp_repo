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
    //cout<<"123";
    int n, k;
    cin >> n >> k;

    v_i _record(n + 1, 1);

    _record[0] = 0;
    int result_sum = 0;

    for (int i = n; i > 0; i--)
    {
        if (i > k)
            result_sum += 1;
        else if (i == k)
            _record[i] = 0;
        else
        {
            if (_record[i])
            {
                result_sum += 1;
                int temp = k - i;
                if(temp != i)
                    _record[temp] = 0;
            }
        }
    }

    cout << result_sum << nline;
    for_1(n)
    {
        if (_record[i])
            cout << i << " ";
    }
    cout << nline;
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
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

v_i perfect_squares;
void solve()
{

    int temp;
    for(int i = 0; i <= 1000; i++)
    {
        cout<<perfect_squares[i]<<endl;
        cout<<flush;
        cin>>temp;

        if(temp == 1)
        {
            return;
        }else if(temp == -1)
        {
            exit(0);
        }
    }

    cout<<flush;
    
}

int32_t main()
{

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int i = 1, square = 1;
    while (square <= 1000000)
    {
        perfect_squares.pb(square);
        i++;
        square = i * i;
    }

    int t;
    cin>>t;

    while (t--)
    {
        solve();
    }

    return 0;
}
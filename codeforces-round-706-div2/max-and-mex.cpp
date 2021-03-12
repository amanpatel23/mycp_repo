#include <bits/stdc++.h>
#define int long long
#define mod 1000000007
#define i_max INT_MAX
#define i_min INT_MIN
#define s_i set<int>
#define ms_i multiset<int>
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

    //ms_i nums;
    s_i result_nums;
    int temp;
    for_0(n)
    {
        cin >> temp;
        result_nums.insert(temp);
    }

    int mix = 0, max;
    s_i::iterator it;
    it = result_nums.end();
    max = *(--it);
    //cout<<max<<nline;

    while (true)
    {
        it = result_nums.find(mix);
        if (it == result_nums.end())
            break;
        else
            mix++;
    }

    //cout<<mix<<" "<<max<<nline;

    int ele;
    int result_size;
    if (max > mix)
    {
        if (k != 0)
        {
            ele = ceil((mix + max) / 2.);
            result_nums.insert(ele);
        }
        result_size = result_nums.size();
    }
    else if (max < mix)
    {
        result_size = result_nums.size() + k;
    }

    cout << result_size << nline;
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
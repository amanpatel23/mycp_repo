/*
    Author: Aman Patel
    Date: 11-06-2021
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

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
#define yes (cout << "YES" << "\n")
#define no (cout << "NO" << "\n")
#define rep(i, a, b) for(int i = a; i < b; i++)
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

using namespace std;

const int N = 40000;
bool isPrime[N];
v_i primes;

void preprocessing() {

    for (bool &i : isPrime)
        i = true;

    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i < N; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < N; j += i)
                isPrime[j] = false;
        }
    }

    for (int i = 2; i < N; i++) {
        if (isPrime[i])
            primes.pb(i);
    }
}

int countPrimes(int i) {
    int _count = 0;
    for (int x : primes) {
        while (i % x == 0) {
            i /= x;
            _count += 1;
        }
    }

    if (i > 1) _count++;

    return _count;
}

void solve() {

    int a, b, k;
    cin >> a >> b >> k;

    if (k == 1) {
        if ((a != b) && (a % b == 0 || b % a == 0))
            yes;
        else
            no;
    } else {
        int result = countPrimes(a) + countPrimes(b);
        if (result >= k)
            yes;
        else
            no;
    }
}

int32_t main() {

    fast;

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    preprocessing();

    int t;
    t = 1;
    cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
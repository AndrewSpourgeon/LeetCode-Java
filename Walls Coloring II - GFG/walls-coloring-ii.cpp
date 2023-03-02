//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int minCost(vector<vector<int>> &costs) {
        // write your code here
        int n = costs.size();
        int k = costs[0].size();
        if (n == 0 || k == 0)
        {
            return -1;
        }
        if (n > 1 && k == 1)
        {
            return -1;
        }
        if (n == 1 && k == 1)
        {
            return costs[0][0];
        }
        std::vector<std::vector<int>> dp(n,std::vector<int>(k));
        int mini = std::numeric_limits<int>::max();
        int sMin = std::numeric_limits<int>::max();
        for (int i = 0; i < k; i++)
        {
            int val = costs[0][i];
            dp[0][i] = val;
            if (val < mini)
            {
                sMin = mini;
                mini = val;
            }
            else if (val < sMin)
            {
                sMin = val;
            }
        }
        for (int i = 1; i < n; i++)
        {
            int cMin = std::numeric_limits<int>::max();
            int csMin = std::numeric_limits<int>::max();
            for (int j = 0; j < k; j++)
            {
                if (dp[i - 1][j] == mini)
                {
                    dp[i][j] = costs[i][j] + sMin;
                }
                else
                {
                    dp[i][j] = costs[i][j] + mini;
                }
                int val = dp[i][j];
                if (val < cMin)
                {
                    csMin = cMin;
                    cMin = val;
                }
                else if (val < csMin)
                {
                    csMin = val;
                }
            }
            mini = cMin;
            sMin = csMin;
        }
        int ans = std::numeric_limits<int>::max();
        for (auto val : dp[n - 1])
        {
            ans = min(ans,val);
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        vector<vector<int>> costs(n, vector<int>(k));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) cin >> costs[i][j];
        }
        Solution obj;
        cout << obj.minCost(costs) << endl;
    }
}
// } Driver Code Ends
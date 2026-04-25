#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> count(n, 0);
        vector<pair<int,int>> arr;

        for (int i = 0; i < n; i++)
            arr.push_back({nums[i], i});

        mergeSort(arr, 0, n - 1, count);
        return count;
    }

    void mergeSort(vector<pair<int,int>>& arr, int left, int right, vector<int>& count) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, count);
        mergeSort(arr, mid + 1, right, count);
        merge(arr, left, mid, right, count);
    }

    void merge(vector<pair<int,int>>& arr, int left, int mid, int right, vector<int>& count) {
        vector<pair<int,int>> temp;
        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i].first <= arr[j].first) {
                count[arr[i].second] += rightCount;
                temp.push_back(arr[i++]);
            } else {
                rightCount++;
                temp.push_back(arr[j++]);
            }
        }

        while (i <= mid) {
            count[arr[i].second] += rightCount;
            temp.push_back(arr[i++]);
        }

        while (j <= right) {
            temp.push_back(arr[j++]);
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp[k - left];
        }
    }
};

int main() {
    Solution sol;
    vector<int> nums = {5, 2, 6, 1};

    vector<int> result = sol.countSmaller(nums);

    for (int x : result)
        cout << x << " ";

    return 0;
}
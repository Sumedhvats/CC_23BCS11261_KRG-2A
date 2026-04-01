#include <iostream>
using namespace std;

struct Job {
    int id, deadline, profit;
};

bool compare(Job a, Job b) {
    return a.deadline < b.deadline;
}

int jobScheduling(vector<Job>& jobs) {
    sort(jobs.begin(), jobs.end(), compare);

    priority_queue<int, vector<int>, greater<int>> minHeap;

    for (auto job : jobs) {
        minHeap.push(job.profit);

        if (minHeap.size() > job.deadline) {
            minHeap.pop();
        }
    }

    int maxProfit = 0;
    while (!minHeap.empty()) {
        maxProfit += minHeap.top();
        minHeap.pop();
    }

    return maxProfit;
}

int main() {
    vector<Job> jobs = {
        {1, 2, 100},
        {2, 1, 19},
        {3, 2, 27},
        {4, 1, 25},
        {5, 3, 15}
    };

    cout << "Maximum Profit: " << jobScheduling(jobs);
    return 0;
}
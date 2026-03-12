//gfg Job Sequencing Problem
class Solution {
  public:
    vector<int> jobSequencing(vector<int> &deadline, vector<int> &profit) {
        vector<pair<int,int>>job;
        for(int i=0;i<deadline.size();i++){
            job.push_back({deadline[i],profit[i]});
        }
        
        sort(job.begin(),job.end());
        
        priority_queue<int,vector<int>,greater<int>>pq;
        for(auto i:job){
            pq.push(i.second);
            if(pq.size()>i.first){
                pq.pop();
            }
        }
        int cnt=0;
        int totalprofit=0;
        while(!pq.empty()){
            cnt++;
            totalprofit+=pq.top();
            pq.pop();
        }
        return {cnt,totalprofit};
    }
};
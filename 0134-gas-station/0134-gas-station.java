class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalgas = 0;
        int totalcost = 0;

        for(int i=0;i<n;i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }

        if(totalgas < totalcost) return -1;

        int right =0;
        int gain =0;
        int index=right;
        
        while(right <n){
            if(gain + gas[right] >= cost[right]){
                gain += gas[right] - cost[right];
            }
            else {
                gain =0;
                index = right+1;
            }
            right++;
        }
        if(index>=n)return -1;
        return index;
    }
}
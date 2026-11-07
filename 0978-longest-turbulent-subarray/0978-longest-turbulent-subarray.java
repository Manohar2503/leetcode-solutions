class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int forwarCount = 0;
        int backwardCount = 0;

        int count =0;
        boolean flag = true;
        for(int i=1;i<n;i++){
            if(flag && arr[i-1] < arr[i]){
                count++;
                flag = false;
            }
            else if(!flag && arr[i-1] > arr[i]){
                count++;
                flag = true;
            }
            else{
                forwarCount = Math.max(forwarCount, count);
                if(arr[i-1] < arr[i]){
                    count = 1;
                    flag = false;
                }
                else {
                    count = 0;
                    flag = true;
                }
            }
        }
        forwarCount = Math.max(forwarCount, count);
        count =0;
        flag = true;
        for(int i=1;i<n;i++){
            if(flag && arr[i-1] > arr[i]){
                count++;
                flag = false;
            }
            else if(!flag && arr[i-1] < arr[i]){
                count++;
                flag = true;
            }
            else{
                backwardCount = Math.max(backwardCount, count);
                if(arr[i-1] > arr[i]){
                    count = 1;
                    flag = false;
                }
                else {
                    count = 0;
                    flag = true;
                }
            }
        }
         backwardCount = Math.max(backwardCount, count);

        return Math.max(forwarCount+1, backwardCount+1);
    }
}
/*

        9, 4, 2, 10, 7, 8, 8, 1, 9
        >  >  <  >   <  =  >  <

*/
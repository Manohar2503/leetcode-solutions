class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        Arrays.sort(time);

        long min_time = (long) time[0];
        long max_time =(long) totalTrips * time[0];
        if(totalTrips == 1) return min_time;
        
        long result = max_time;
        while(min_time <= max_time){
            long times = min_time + (max_time - min_time) /2;
            long sum_time =0;

            for(int t: time){
                long count = (times) / (long)t;
                if(count == 0) break;
                sum_time += count;
            }

            if(sum_time >= totalTrips){
                result = times;
                max_time = times - 1;
            }
            else{
                min_time = times + 1;
            }
        }
        
        return result;
    }
}
/*

    time = 1, 2, 3      TT = 1

    min time i can get the totalTrips to complete all buses

    min - 1 
    max - 3

    [min, max] - my answer will be present in this range 
    that answer should be completes TT and here i need to return min time


    approach : 1
        min = 1
        max = 3

        mid = 2

        time -> mid / time[i]     -> O(N log(max(time) - min(time)))

    5 10 10 -> 

    min = 5
    max = 45

    mid = 25
    result =  0;
    
    mid / time 

    5 + 2 + 2 = 9

*/
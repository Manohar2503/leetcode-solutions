
class Solution {
    int result = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {

        int[] workers = new int[k];

        // Sort jobs in descending order for better pruning
        Arrays.sort(jobs);

        for (int i = 0; i < jobs.length / 2; i++) {
            int temp = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = temp;
        }

        backtrack(0, jobs, workers);

        return result;
    }

    void backtrack(int index, int[] jobs, int[] workers) {

        // All jobs assigned
        if (index == jobs.length) {
            int maxTime = 0;

            for (int time : workers) {
                maxTime = Math.max(maxTime, time);
            }

            result = Math.min(result, maxTime);
            return;
        }

        // Pruning: cannot improve the current best answer
        int currentMax = 0;

        for (int time : workers) {
            currentMax = Math.max(currentMax, time);
        }

        if (currentMax >= result) return;

        // Assign current job to a worker
        for (int i = 0; i < workers.length; i++) {

            // Skip workers having the same workload
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (workers[i] == workers[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) continue;
            workers[i] += jobs[index];
            backtrack(index + 1, jobs, workers);

            // Backtrack
            workers[i] -= jobs[index];

            // All remaining workers are equivalent
            if (workers[i] == 0) break;
        }
    }
}

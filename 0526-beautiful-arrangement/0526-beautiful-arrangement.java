class Solution {
    int count = 0;

    public int countArrangement(int n) {
        permutation(1, n, 0);
        return count;
    }

    void permutation(int index, int n, int mask) {
        if (index > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {

            int bit = 1 << (num - 1);

            if ((mask & bit) == 0 &&
                (num % index == 0 || index % num == 0)) {

                permutation(index + 1, n, mask | bit);
            }
        }
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] result = new int[n];
        int index=1;
        result[0] = 1;
        int l1 =0;
        int l2 =0;
        int l3 =0;

        for(int i=1;i<n;i++){
            int val1 = result[l1] * 2;
            int val2 = result[l2] * 3;
            int val3 = result[l3] * 5;

            int next = Math.min(val1, Math.min(val2, val3));
            result[index++] = next;
            if(next == val1) l1++;
            if(next == val2) l2++;
            if(next == val3) l3++;
        }

        return result[n-1];
    }
}

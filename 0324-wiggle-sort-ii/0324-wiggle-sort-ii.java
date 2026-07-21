class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        // Step 1: Find the median
        int median = quickSelect(nums, 0, n - 1, n / 2);

        // Step 2: Three-way partition using virtual indexing
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left, n), newIndex(i, n));
                left++;
                i++;
            } 
            else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right, n), newIndex(i, n));
                right--;
            } 
            else {
                i++;
            }
        }
    }

    // Virtual Index Mapping
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    // QuickSelect
    private int quickSelect(int[] nums, int left, int right, int k) {

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k)
                return nums[pivotIndex];

            if (pivotIndex < k)
                left = pivotIndex + 1;
            else
                right = pivotIndex - 1;
        }

        return -1;
    }

    // Lomuto Partition
    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {

            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
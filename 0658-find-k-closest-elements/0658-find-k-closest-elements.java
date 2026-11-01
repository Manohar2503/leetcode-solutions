
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        int index = binarySearch(arr, x);

        int left = index;
        int right = index + 1;

        List<Integer> result = new ArrayList<>();

        while (result.size() < k) {

            if (left < 0) {
                result.add(arr[right++]);
            }
            else if (right >= n) {
                result.add(arr[left--]);
            }
            else {
                int pos1 = Math.abs(arr[left] - x);
                int pos2 = Math.abs(arr[right] - x);

                if (pos1 <= pos2) {
                    result.add(arr[left--]);
                }
                else {
                    result.add(arr[right++]);
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    static int binarySearch(int[] arr, int val) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= val) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}

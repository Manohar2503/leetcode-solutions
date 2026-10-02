class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int n = items.length;

        // Store unique prices and maximum beauty up to that price
        int[] prices = new int[n];
        int[] beauties = new int[n];

        int size = 0;
        int maxBeauty = 0;

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];

            maxBeauty = Math.max(maxBeauty, beauty);

            // Same price -> don't create another entry
            if (size > 0 && prices[size - 1] == price) {
                beauties[size - 1] = maxBeauty;
            } else {
                prices[size] = price;
                beauties[size] = maxBeauty;
                size++;
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(prices, beauties, size, queries[i]);
        }

        return result;
    }

    private int binarySearch(int[] prices, int[] beauties, int size, int query) {

        int left = 0;
        int right = size - 1;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (prices[mid] <= query) {
                answer = beauties[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
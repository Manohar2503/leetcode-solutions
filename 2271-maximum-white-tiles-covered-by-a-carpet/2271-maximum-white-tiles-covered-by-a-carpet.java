
import java.util.Arrays;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));

        int n = tiles.length;
        int left = 0;
        int right = 0;
        int covered = 0;
        int result = 0;

        while (left < n) {
            int carpetStart = tiles[left][0];
            int carpetEnd = carpetStart + carpetLen - 1;

            // Count intervals completely covered by the carpet
            while (right < n && tiles[right][1] <= carpetEnd) {
                covered += tiles[right][1] - tiles[right][0] + 1;
                right++;
            }

            // Count partial coverage of the next interval
            int current = covered;

            if (right < n && tiles[right][0] <= carpetEnd) {
                current += carpetEnd - tiles[right][0] + 1;
            }

            result = Math.max(result, current);

            // Move the left boundary to the next interval
            if (right == left) {
                right++;
            } else {
                covered -= tiles[left][1] - tiles[left][0] + 1;
            }

            left++;
        }

        return result;
    }
}

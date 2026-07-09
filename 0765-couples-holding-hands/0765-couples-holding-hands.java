class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(row[i], i);
        int result =0;
        for (int i = 0; i < n; i += 2) {

            int person = row[i];

            // Find the partner
            int partner = (person % 2 == 0) ? person + 1 : person - 1;

            // Already sitting together
            if (row[i + 1] == partner) {
                continue;
            }

            result++;

            // Index of the partner
            int partnerIndex = map.get(partner);

            // Person currently sitting beside 'person'
            int otherPerson = row[i + 1];

            // Swap
            row[partnerIndex] = otherPerson;
            row[i + 1] = partner;

            // Update both positions in the map
            map.put(otherPerson, partnerIndex);
            map.put(partner, i + 1);
        }

        return result;
    }
}

/*


     0 -> 2
     2 -> 0, 1
     1 -> 2,3
     3 -> 1

    [0, 1, 2, 3]
              r
     count = 1
*/

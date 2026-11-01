class TopVotedCandidate {

    int[] times;
    int[] leaders;
    int n;

    public TopVotedCandidate(int[] persons, int[] times) {

        this.times = times;
        this.n = persons.length;

        leaders = new int[n];

        Map<Integer, Integer> count = new HashMap<>();

        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < n; i++) {

            int person = persons[i];

            int votes = count.getOrDefault(person, 0) + 1;
            count.put(person, votes);

            if (votes >= maxVotes) {
                maxVotes = votes;
                leader = person;
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {

        int left = 0;
        int right = n - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leaders[ans];
    }
}
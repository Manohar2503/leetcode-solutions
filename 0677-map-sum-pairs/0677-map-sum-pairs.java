class MapSum {
    Map<String, Integer> map = new HashMap<>();

    public MapSum() {
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix))
                ans += entry.getValue();
        }

        return ans;
    }
}
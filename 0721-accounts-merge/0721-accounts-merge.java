class Solution {
    Map<String, String> parent;
    private String find(String x){
        if(!parent.containsKey(x)){
            parent.put(x,x);
            return x;
        }
        if(!parent.get(x).equals(x)){
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new HashMap<>();
        
        Map<String, String> emailToName = new HashMap<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            String parentMail = account.get(1);
            for(int i=1;i<account.size();i++){
                emailToName.put(account.get(i), name);
                parent.put(find(account.get(i)), find(parentMail));
            }
        }

       

        Map<String, List<String>> group = new HashMap<>();
        for(String email: emailToName.keySet()){
            String parent = find(email);
            group.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: group.entrySet()){
            String parentMail = entry.getKey();
            List<String> list = entry.getValue();
            Collections.sort(list);
            String name = emailToName.get(parentMail);
            list.add(0,name);
            result.add(list);
        }
        return result;
    }
}
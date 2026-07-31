class Solution {
   
    static class Node{
        int node;
        String color;
        int len;
        Node(int n,String color,int len){
            this.node = n;
            this.color = color;
            this.len = len;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redAdj = new ArrayList<>();
        List<List<Integer>> blueAdj = new ArrayList<>();

        for(int i=0;i<n;i++){
            redAdj.add(new ArrayList<>());
            blueAdj.add(new ArrayList<>());
        }

        for(int[] edge: redEdges){
            redAdj.get(edge[0]).add(edge[1]);
        }

        for(int[] edge: blueEdges){
            blueAdj.get(edge[0]).add(edge[1]);
        }

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] =0;
        Queue<Node> qu = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(int val : redAdj.get(0)){
            if(!set.contains(""+val+","+"red")){
            qu.offer(new Node(val, "red", 1));
            set.add(""+val+","+"red");
            }
        }

        for(int val : blueAdj.get(0)){
            if(!set.contains(""+val+","+"blue")){
            qu.offer(new Node(val, "blue", 1));
            set.add(""+val+","+"blue");
            }
        }

        
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            if(result[cur.node] > cur.len) result[cur.node] = cur.len;
            if(cur.color.equals("red")){
                for(int val: blueAdj.get(cur.node)){
                    Node newNode = new Node(val, "blue", cur.len +1);
                    if(!set.contains(""+val+","+"blue")){
                        qu.offer(newNode);
                        set.add(""+val+","+"blue");
                    }
                }
            }
            else{
                for(int val: redAdj.get(cur.node)){
                    Node newNode = new Node(val, "red", cur.len +1);
                    if(!set.contains(""+val+","+"red")){
                        qu.offer(newNode);
                        set.add(""+val+","+"red");
                    }
                }
            }
        }
        for(int i=0;i<n;i++) if(result[i] == Integer.MAX_VALUE) result[i]=-1;
        return result;
    }
}

/*
    4
    ^
    |
    0 -> 1 -> 2 -> 3 -> 5

    red - [0,1] [1,2]
    blue - [0,4]

    [0, 1, ]



*/
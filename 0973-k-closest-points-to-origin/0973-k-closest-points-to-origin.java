  class Heap{
       int[] cord;
        double l;
        Heap(int[] cord, double l){
           this.cord = cord;
            this.l = l;
        }
    }
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        List<Heap> gp = new ArrayList<>();
        for(int[] point:points){
            double dis = Math.sqrt(point[1]*point[1] + point[0]*point[0]);
            gp.add(new Heap(point,dis));
        }
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Heap> heap = new PriorityQueue<>(new Comparator<Heap>(){
            public int compare(Heap a, Heap b){
                return Double.compare(a.l,b.l);
            }

        });

        for(Heap p : gp){
            heap.add(p);
        }

        while(k>0){
            result.add(heap.poll().cord);
            k--;
        }
        return result.toArray(new int[result.size()][]);
    }

}
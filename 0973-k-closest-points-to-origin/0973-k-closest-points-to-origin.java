  class Heap implements Comparable<Heap>{
       int[] cord;
        double l;
        Heap(int[] cord, double l){
           this.cord = cord;
            this.l = l;
        }
         public int compareTo(Heap a){
                return Double.compare(this.l,a.l);
            }
    }
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        List<Heap> gp = new ArrayList<>();
        for(int[] point:points){
            int dis = point[0] * point[0] + point[1] * point[1];
            gp.add(new Heap(point,dis));
        }
        Collections.sort(gp);
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = gp.get(i).cord;
        }

        return result;
    }

}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){

            if(asteroids[i]>0){
                list.add(asteroids[i]);
            }else{

                while(!list.isEmpty() && list.get(list.size()-1)>0 && Math.abs(asteroids[i])>list.get(list.size()-1)){
                    list.remove(list.size()-1);
                }

            if(!list.isEmpty() && list.get(list.size()-1)>0 && Math.abs(asteroids[i])==list.get(list.size()-1)){
                list.remove(list.size()-1);
            }
            else if(list.isEmpty() || list.get(list.size()-1)<0){
                list.add(asteroids[i]);
            }

            }
        }
        int arr[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }

        return arr;

    }
}
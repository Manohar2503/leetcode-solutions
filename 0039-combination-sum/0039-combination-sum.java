class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
     paths(0,target,list,new ArrayList<>(),candidates);
    return list;
    }

    public static void paths(int index, int target,List<List<Integer>> ans, List<Integer> list ,int[] arr){
        if(index == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
                
            }
            return ;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            paths(index,target-arr[index],ans,list,arr);
            list.remove(list.size()-1);
        }
         paths(index+1,target,ans,list,arr);

    }
}
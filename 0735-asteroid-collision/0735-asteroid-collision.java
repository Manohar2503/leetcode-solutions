class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int val: asteroids){
            boolean isCollision = false;
            while(!st.isEmpty() && st.peek()>0 && val < 0){
                if(Math.abs(st.peek()) == Math.abs(val)){
                    st.pop();
                    isCollision = true;
                    break;
                }
                else if(Math.abs(st.peek()) > Math.abs(val)){
                    isCollision = true;
                    break;
                }
                else{
                    st.pop();
                }
            }

            if(!isCollision) st.push(val);
            
        }

        int[] result = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            result[i] = st.pop();
        }

        return result;
    }
}

/*

    5 10 -5
          i
    st-[5, 10]

    !st.isEmpty() && cur < 0 {
        if(is top and abs(cur) is equal) // let say top = 5 , cur = -5 {
            st.pop();
            collison = true;
        }
        else if (top > cur) collison = true;
        else{ // top < cur
            st.pop()
        }
    }
*/

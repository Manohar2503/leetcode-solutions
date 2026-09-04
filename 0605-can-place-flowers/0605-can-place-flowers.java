class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        boolean result = false;
        int tam = flowerbed.length;
        

        for (int i = 0; i < tam; i++){
            //Es un cero mi posicion actual
            if (flowerbed[i] == 0){
                //Izquierda
                if (i == 0 || flowerbed[i - 1] == 0 ){
                    //Derecha 
                    if (i == tam - 1 || flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }

        if (n <= 0){
            return true;
        }

        return result;
        
    }
}
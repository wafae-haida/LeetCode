/*

[0,1,0,1,0,1,0,0,1]-> 4 flowers false
[0],1->true
[0,0,0,1,0,1,0,0,1]-> 0 flowers true

edge || 0 in the both side of i then n--
if n==0 return true
else return false

*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0 && (i-1==-1 || flowerbed[i-1]==0) && (i+1==flowerbed.length || flowerbed[i+1]==0)){
                flowerbed[i]=1;
                --n;
            } 
            if(n==0) return true;
        }
        
        return false;
    }
}
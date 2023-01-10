class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     for(int[] row : matrix){
         int roLen=row.length-1;
         if(target>row[roLen])continue;
         else{
             int start=0,end=roLen;
             while(start<=end){
                 int mid=end+((start-end)/2);
                 if(row[mid]<target)start=mid+1;
                 else if(row[mid]>target)end=mid-1;
                 else return true;
             }
         }
     }
       return false;
    }
}
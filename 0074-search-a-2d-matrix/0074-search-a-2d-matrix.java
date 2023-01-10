class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { //O(log(m+ n)) time,space O(1)
     
         int first=0,last=matrix.length-1;
         int coLen=matrix[0].length-1;
         int row=0;
         while(first<=last){
             int center=last+((first-last)/2);
             if(matrix[center][coLen]<target)first=center+1;
             else if(matrix[center][0]>target)last=center-1;
             else {row=center;
                  break;}
         }
             int start=0,end=coLen;
             while(start<=end){
                 int mid=end+((start-end)/2);
                 if(matrix[row][mid]<target)start=mid+1;
                 else if(matrix[row][mid]>target)end=mid-1;
                 else return true;
             }
     
       return false;
    }
}
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] arr : image){
            arr = flip(arr);
            arr = invert(arr);
        }
        return image;
    }
    public int[] flip(int[] arr){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return arr;
    }
    public int[] invert(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
        return arr;
    }
}
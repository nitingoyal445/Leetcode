class Solution {
    
    public void transpose(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void reverseRows(int[][] matrix){
        for(int i =0;i<matrix.length;i++){
            int left = 0;
            int right = matrix[0].length-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
}
public class MatrixFlip {
    public static void printFlippedMatrix(char[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){System.out.print(matrix[i][j]);}
            System.out.println("");
        }
    }
}

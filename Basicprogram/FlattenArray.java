import java.util.Arrays;

public class FlattenArray {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalElements = rows * cols;
        int[] flatArray = new int[totalElements];
        int index = 0; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index] = matrix[i][j];
                index++; 
            }
        }
        System.out.println("Original 2D Array:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nFlattened 1D Array:");
        System.out.println(Arrays.toString(flatArray));
    }
}
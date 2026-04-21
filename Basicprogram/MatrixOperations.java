public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matA = createRandomMatrix(2, 3);
        int[][] matB = createRandomMatrix(2, 3);
        int[][] matC = createRandomMatrix(3, 2);

        System.out.println("Matrix A (2x3):");
        displayMatrix(matA);
        System.out.println("Matrix B (2x3):");
        displayMatrix(matB);
        System.out.println("Matrix C (3x2):");
        displayMatrix(matC);
        System.out.println("\nResult of Addition (A + B):");
        displayMatrix(addMatrices(matA, matB));
        System.out.println("\nResult of Subtraction (A - B):");
        displayMatrix(subtractMatrices(matA, matB));
        System.out.println("\nResult of Multiplication (A * C):");
        int[][] product = multiplyMatrices(matA, matC);
        if (product != null) {
            displayMatrix(product);
        }
    }
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); 
            }
        }
        return matrix;
    }
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            System.out.println("Multiplication not possible: Columns of A must match rows of B.");
            return null;
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) return;
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " \t");
            }
            System.out.println();
        }
    }
}
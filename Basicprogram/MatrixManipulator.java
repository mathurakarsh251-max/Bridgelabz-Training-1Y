public class MatrixManipulator {

    public static void main(String[] args) {
        double[][] matrix2x2 = createRandomMatrix(2, 2);
        double[][] matrix3x3 = createRandomMatrix(3, 3);

        System.out.println("--- 2x2 Matrix Analysis ---");
        displayMatrix(matrix2x2);
        System.out.println("Determinant: " + determinant2x2(matrix2x2));
        double[][] inv2x2 = inverse2x2(matrix2x2);
        if (inv2x2 != null) {
            System.out.println("Inverse Matrix:");
            displayMatrix(inv2x2);
        }

        System.out.println("\n--- 3x3 Matrix Analysis ---");
        displayMatrix(matrix3x3);
        System.out.println("Transpose:");
        displayMatrix(transpose(matrix3x3));
        System.out.println("Determinant: " + determinant3x3(matrix3x3));
    }
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10); 
            }
        }
        return matrix;
    }
    public static double[][] transpose(double[][] m) {
        double[][] t = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) {
            System.out.println("Matrix is singular (
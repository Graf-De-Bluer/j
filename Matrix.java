public class Matrix {

    private final double[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new ArithmeticException("Matrices do not match in dimensions for addition");
        }

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new ArithmeticException("Matrices do not match in dimensions for subtracting");
        }

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (this.rows != other.columns || this.columns != other.rows) {
            throw new ArithmeticException("Matrices do not match in dimensions for multiplying");
        }

        double[][] result = new double[this.rows][other.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < other.rows; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void printMainDiagonal() {
        if (rows != columns) {
            throw new ArithmeticException("Shape of this matrix is not square");
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%.2f\n", matrix[i][i]);
        }
    }

    public void printSecondaryDiagonal() {
        if (rows != columns) {
            throw new ArithmeticException("Shape of this matrix is not square");
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%.2f\n", matrix[i][rows - i - 1]);
        }
    }

    public void printColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex > columns) {
            throw new ArrayIndexOutOfBoundsException();
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][columnIndex]);
        }
    }

    public void printRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex > rows) {
            throw new ArrayIndexOutOfBoundsException();
        }

        System.out.println();
        for (int j = 0; j < columns; j++) {
            System.out.printf("%.2f ", matrix[rowIndex][j]);
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}

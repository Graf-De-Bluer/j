public class Main {
    public static void main(String[] args) {
        double[][] first = new double[][] {
                {2, -3, 2134},
                {5, 4, 123}
        };

        double[][] second = new double[][] {
                {-7, 5},
                {2, -1},
                {10, 2345}
        };

        Matrix firstMatrix = new Matrix(first);
        Matrix secondMatrix = new Matrix(second);
        firstMatrix.printSecondaryDiagonal();
    }
}
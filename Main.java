import java.util.Random;
import java.util.Scanner;

class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wymiar macierzy: ");
        int dimension = scanner.nextInt();

        int[][] matrix1 = generateRandomMatrix(dimension);
        int[][] matrix2 = generateRandomMatrix(dimension);

        System.out.println("Macierz 1:");
        printMatrix(matrix1);

        System.out.println("Macierz 2:");
        printMatrix(matrix2);

        int[][] additionResult = addMatrices(matrix1, matrix2);
        System.out.println("Wynik dodawania macierzy:");
        printMatrix(additionResult);

        int[][] subtractionResult = subtractMatrices(matrix1, matrix2);
        System.out.println("Wynik odejmowania macierzy:");
        printMatrix(subtractionResult);

        int[][] multiplicationResult = multiplyMatrices(matrix1, matrix2);
        System.out.println("Wynik mnożenia macierzy:");
        printMatrix(multiplicationResult);
    }

    public static int[][] generateRandomMatrix(int dimension) {
        Random random = new Random();
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = random.nextInt(21) - 10; // losowe liczby z zakresu od -10 do 10
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int dimension = matrix.length;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int dimension = matrix1.length;
        int[][] result = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int dimension = matrix1.length;
        int[][] result = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int dimension = matrix1.length;
        int[][] result = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                for (int k = 0; k < dimension; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
}

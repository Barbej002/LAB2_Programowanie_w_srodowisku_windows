import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StatisticalAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj długość tablicy: ");
        int length = scanner.nextInt();

        double[] array = new double[length];

        System.out.println("Wprowadź wartości do tablicy z dostępnych wartości [2, 3, 3.5, 4, 4.5, 5]:");

        for (int i = 0; i < length; i++) {
            System.out.print("Wartość " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }

        double average = calculateAverage(array);
        double min = findMinimum(array);
        double max = findMaximum(array);
        double[] aboveAverage = findValuesAboveAverage(array, average);
        double[] belowAverage = findValuesBelowAverage(array, average);
        Map<Double, Integer> frequencyMap = calculateValueFrequency(array);
        double standardDeviation = calculateStandardDeviation(array, average);

        System.out.println("Analiza statystyczna:");
        System.out.println("Średnia: " + average);
        System.out.println("Wartość minimalna: " + min);
        System.out.println("Wartość maksymalna: " + max);
        System.out.println("Wartości wyższe niż średnia: " + Arrays.toString(aboveAverage));
        System.out.println("Wartości niższe niż średnia: " + Arrays.toString(belowAverage));
        System.out.println("Częstotliwość występowania poszczególnych liczb: " + frequencyMap);
        System.out.println("Średnie odchylenie standardowe: " + standardDeviation);
    }

    public static double calculateAverage(double[] array) {
        double sum = 0;

        for (double value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    public static double findMinimum(double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static double findMaximum(double[] array) {
        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static double[] findValuesAboveAverage(double[] array, double average) {
        int count = 0;

        for (double value : array) {
            if (value > average) {
                count++;
            }
        }

        double[] result = new double[count];
        int index = 0;

        for (double value : array) {
            if (value > average) {
                result[index] = value;
                index++;
            }
        }

        return result;
    }

    public static double[] findValuesBelowAverage(double[] array, double average) {
        int count = 0;

        for (double value : array) {
            if (value < average) {
                count++;
            }
        }

        double[] result = new double[count];
        int index = 0;

        for (double value : array) {
            if (value < average) {
                result[index] = value;
                index++;
            }
        }

        return result;
    }

    public static Map<Double, Integer> calculateValueFrequency(double[] array) {
        Map<Double, Integer> frequencyMap = new HashMap<>();

        for (double value : array) {
            if (frequencyMap.containsKey(value)) {
                frequencyMap.put(value, frequencyMap.get(value) + 1);
            } else {
                frequencyMap.put(value, 1);
            }
        }

        return frequencyMap;
    }

    public static double calculateStandardDeviation(double[] array, double average) {
        double sumOfSquares = 0;

        for (double value : array) {
            sumOfSquares += Math.pow(value - average, 2);
        }

        double variance = sumOfSquares / array.length;

        return Math.sqrt(variance);
    }
}

import java.util.List;
import java.util.Scanner;

public class MagicSquareApp {

    public static int askSize() {

        Scanner scanner = new Scanner(System.in);
        int size = 0;
        boolean validSize = false;
        while (!validSize) {
            System.out.print("What size of magic square do you want? ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= 1 && size <= 3) {
                    validSize = true;
                } else if (size > 3) {
                    System.out.println("To finish in a reasonable time, size must be between 1 and 3.");
                } else {
                    System.out.println("Invalid input, size must be a positive integer greater than 0.");
                }
            } else {
                System.out.println("Invalid input, size must be an integer number.");
                scanner.next();
            }
        }
        scanner.close();
        return size;

    }

    public static void printSolutions(List<int[][]> solutions, int size) {

        System.out.println();
        if (solutions.isEmpty()) {
            System.out.println("Couldn't find a magic square for size: " + size);
        } else {
            System.out.println("Magic square of " + size + "x" + size + " has the following " + solutions.size() + " solutions:");
        }
        for (int[][] solution : solutions) {
            System.out.println();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(solution[i][j] + "\t");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        int magicSquareSize = askSize();
        MagicSquare magicSquare = new MagicSquare(magicSquareSize);
        List<int[][]> solutions = magicSquare.findSolutions();
        printSolutions(solutions, magicSquareSize);

    }

}

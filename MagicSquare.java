import java.util.ArrayList;
import java.util.List;

public class MagicSquare {

    private int size;
    private int[][] square;
    private boolean[] usedNumbers;

    public MagicSquare(int size) {

        this.size = size;
        this.square = new int[size][size];
        this.usedNumbers = new boolean[size * size + 1];

    }

    public List<int[][]> findSolutions() {

        List<int[][]> solutions = new ArrayList<>();
        backtrack(solutions, 1, 0, 0);
        return solutions;

    }

    private void backtrack(List<int[][]> solutions, int number, int row, int col) {

        if (number > size * size) {
            if (isMagicSquare()) {
                solutions.add(cloneSquare());
            }
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (square[i][j] == 0 && !usedNumbers[number]) {
                    square[i][j] = number;
                    usedNumbers[number] = true;
                    backtrack(solutions, number + 1, row, col);
                    usedNumbers[number] = false;
                    square[i][j] = 0;
                }
            }
        }

    }

    private boolean isMagicSquare() {

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += square[0][i];
        }
        // Check rows
        for (int i = 1; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        // Check columns
        for (int i = 0; i < size; i++) {
            int colSum = 0;
            for (int j = 0; j < size; j++) {
                colSum += square[j][i];
            }
            if (colSum != sum) {
                return false;
            }
        }
        // Check diagonals
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        for (int i = 0; i < size; i++) {
            diagonal1Sum += square[i][i];
            diagonal2Sum += square[i][size - i - 1];
        }
        if (diagonal1Sum != sum || diagonal2Sum != sum) {
            return false;
        }
        return true;

    }

    private int[][] cloneSquare() {

        int[][] clone = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                clone[i][j] = square[i][j];
            }
        }
        return clone;

    }

}

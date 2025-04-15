public class SimpleNQueens {

    static int N = 4; // You can change this value

    static int[] board = new int[N]; // board[i] = column position of queen in row i

    public static void main(String[] args) {
        if (solve(0)) {
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Recursive function to solve the problem
    static boolean solve(int row) {
        if (row == N) return true; // All queens are placed

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col; // Place queen
                if (solve(row + 1)) return true;
                // Backtrack happens automatically by overwriting board[row] later
            }
        }

        return false;
    }

    // Check if it's safe to place queen at board[row] = col
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // Same column or same diagonal
            if (board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }

    // Print the board
    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}

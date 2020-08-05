
public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


    /**
     * Checks if the input parameters are valid
     *
     * @param k     number of queens
     * @param rows  number of rows to be on a board
     * @param cols  number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls) {
        int wallsCounter = 0;

        // Validates k, rows and cols are valid
        if (k < 1 | rows < 1 | cols < 1)
            return false;
        if (walls == null)
            return false;

        // Validates that walls is not a null array
        if (walls == null)
            return false;

        // Validates that walls has the same num of rows as the board
        if (walls.length != rows)
            return false;

        // Going through every cell in walls and verifies that the walls location doesn't exceed the board columns
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[i].length; j++) {
                if (walls[i][j] > cols - 1) {
                    return false;
                }
            }
        }

        // Validates there's enough room in the board to place the queens
        if (k > cols * rows - wallsCounter)
            return false;

        return true;
    }

    /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows  number of rows in board. Assume valid value.
     * @param cols  number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    public static int[][] createBoard(int rows, int cols, int[][] walls) {
        int[][] board = new int[rows][cols];
        for (int i = 0; i < walls.length; i++)
            for (int j = 0; j < walls[i].length; j++)
                board[i][walls[i][j]] = WALL;

        return board;
    }


    /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    public static void printBoard(int[][] board) {

        if (board.length == 0)
            System.out.println("There is no solution");

        else {
        int rows = board.length;
        int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == QUEEN)
                        System.out.print("Q" + " ");
                    else if (board[i][j] == WALL)
                        System.out.print("X" + " ");
                    else
                        System.out.print("*" + " ");
                }
                System.out.println();
            }
        }

    }

    /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    public static boolean validateWalls(int[][] walls, int[][] board) {


        // Checking if board is legal:
        boolean output = true;
        boolean inWalls;

        if (board == null)
            output = false;

        int rows = board.length;
        int cols = board.length;

        if (rows < 1 | cols < 1)
            output = false;


        // Validates that each wall inside walls[][] is indeed located in the board:
        for (int i = 0; i < walls.length & output; i++) {
            for (int j = 0; j < walls[i].length & output; j++) {
                if (walls[i][j] > cols)
                    output = false;
                else if (board[i][walls[i][j]] != WALL)
                    output = false;
            }
        }

        // Validates that there's no redundant walls inside the board:
        // Going over each cell in the board, tracking each wall,
        // and searching in the respective array inside walls to see if it is there
        for (int i = 0; i < rows & output; i++) {
            for (int j = 0; j < cols & output; j++) {
                if (board[i][j] == WALL) {
                    inWalls = false;
                    for (int k = 0; k < walls[i].length & !inWalls; k++) {
                        if (j == walls[i][k])
                            inWalls = true;     // true means the wall was found inside walls[][]
                    }
                    if (!inWalls)
                        output = false;
                }
            }
        }

        return output;
    }


    /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row   the row in which the queen is located
     * @param col   the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    public static boolean isQueenThreatened(int[][] board, int row, int col) {

        int boardRows = board.length - 1;
        int boardCols = board[0].length - 1;

        // Checks if there's a threatening Queen to the Right
        for (int i = col + 1; i < boardCols; i++) {
            if (board[row][i] == WALL)
                break;
            if (board[row][i] == QUEEN)
                return true;
        }

        // Checks if there's a threatening Queen to the Left
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == WALL)
                break;
            if (board[row][i] == QUEEN)
                return true;
        }

        // Checks if there's a threatening Queen downwards
        for (int i = row + 1; i < boardRows; i++) {
            if (board[i][col] == WALL)
                break;
            if (board[i][col] == QUEEN)
                return true;
        }

        // Checks if there's a threatening Queen upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == WALL)
                break;
            if (board[i][col] == QUEEN)
                return true;
        }

        // Check if there's a threatening Queen from the upper-right
        for (int i = row - 1, j = col + 1; i >= 0 & j <= boardCols; i--, j++) {
            if (board[i][j] == WALL)
                break;
            if (board[i][j] == QUEEN)
                return true;
        }

        // Check if there's a threatening Queen from the upper-left
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {
            if (board[i][j] == WALL)
                break;
            if (board[i][j] == QUEEN)
                return true;
        }

        // Check if there's a threatening Queen from down-right
        for (int i = row + 1, j = col + 1; i <= boardRows & j <= boardCols; i++, j++) {
            if (board[i][j] == WALL)
                break;
            if (board[i][j] == QUEEN)
                return true;
        }

        // Check if there's a threatening Queen from down-left
        for (int i = row + 1, j = col - 1; i <= boardRows & j >= 0; i++, j--) {
            if (board[i][j] == WALL)
                break;
            if (board[i][j] == QUEEN)
                return true;
        }

        return false;
    }


    /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k     number of queens that must be on the board. Assume k>=1.
     * @param rows  number of rows that must be on the board. Assume rows>=1.
     * @param cols  number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls) {

        // Using the previous functions validations:

        if (!isValidInput(k, rows, cols, walls)) {
            return false;
        }

        if (!validateWalls(walls, board)) {
            return false;
        }


        // Going over every cell inside the board and looking for queens.
        // If a queen was found, running "isQueenThreatened" function and returns false if she is threatened.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == QUEEN) {
                    if (isQueenThreatened(board, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row   queen must be added to this row. Assume valid value.
     * @param col   queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    public static boolean addQueen(int[][] board, int row, int col) {

        // Checks if there's a Wall or diff Queen in the same spot
        if (board[row][col] == WALL | board[row][col] == QUEEN)
            return false;

        // Places the queen on the board and checks if she's threatened by the previous function
        board[row][col] = QUEEN;
        if (isQueenThreatened(board, row, col)) {
            board[row][col] = EMPTY;    // Removes the queen if its place is not legal
            return false;
        }

        return true;
    }

    /**
     * Solves the k queens problem.
     *
     * @param k     number of queens to be located on the board
     * @param rows  number of rows in the board
     * @param cols  number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls) {
        int[][] board = new int[rows][cols];
        int[][] emptyBoard = new int[0][0];

        if (!isValidInput(k, rows, cols, walls))
            return emptyBoard;

        // Creating a board with the supplied walls.
        // Arrays in java are automatically initialized with 0's, so there's no need to enter EMPTY cells
        for (int i = 0; i < walls.length; i++)
            for (int j = 0; j < walls[i].length; j++)
                board[i][walls[i][j]] = WALL;

        if (kQueens(board, k, 0, 0, 0))
            return board;

        return emptyBoard;
    }

    /**
     * Recursive helper function for the k queens problem
     *
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens) {

        if (numOfQueens < k) {
            if (row < board.length & col < board[0].length) {
                if (board[row][col] == EMPTY) {
                    if (!isQueenThreatened(board, row, col)) {
                        addQueen(board, row, col);
                        return kQueens(board, k, row, col + 1, numOfQueens + 1);
                    } else
                        return kQueens(board, k, row, col + 1, numOfQueens);
                } else
                    return kQueens(board, k, row, col + 1, numOfQueens);
            } else if (row < board.length)
                return kQueens(board, k, row + 1, 0, numOfQueens);

            if (numOfQueens < k)
                return false;
        }

        return true;
    }


}

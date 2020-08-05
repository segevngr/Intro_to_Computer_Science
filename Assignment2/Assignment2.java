
public class Assignment2 {

    public static boolean isSquareMatrix(boolean[][] matrix) {
        // Checking if the matrix is null beforehand to avoid NPE
        if (matrix == null)
            return false;

        int len = matrix.length;
        // Checking the length of each sub-array in the matrix and verifies that it equals to the # of arrays
        for (int i = 0; i < len; i++) {
            if (matrix[i] == null || matrix[i].length != len)
                return false;
        }
        return true;
    }

    public static boolean isSymmetricMatrix(boolean[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; i < len; i++)
                // Checking Symmetry
                if (matrix[i][j] != matrix[j][i])
                    return false;
        }
        return true;
    }

    public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            // Checking Anti Reflexive
            if (matrix[i][i] != false)
                return false;
        }
        return true;
    }

    public static boolean isLegalInstance(boolean[][] matrix) {
        if (!(isSquareMatrix(matrix) && isSymmetricMatrix(matrix) && isAntiReflexiveMatrix(matrix)))
            return false;
        return true;
    }

    public static boolean isPermutation(int[] array) {
        int len = array.length;
        boolean numInArray;
        // i represents all the numbers from 0 too array length -1
        // the program checks if 'i' is inside the array by comparing it to each of the array values
        // j is the array index used for this comparison.
        for (int i = 0; i < len; i++) {
            numInArray = false;
            for (int j = 0; j < len; j++)
                if (i == array[j])
                    numInArray = true;
            if (!numInArray)
                return false;
        }

        return true;
    }

    public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
        int numOfFlights = tour.length;
        int departure, destination;
        for (int i = 0; i < numOfFlights - 1; i++) {
            departure = tour[i];    // Holds the # of the departure city
            destination = tour[i + 1];    // Holds the # of the destination city
            if (flights[departure][destination] == false)    // Verifying the flight is legal by going over flights array
                return false;
        }

        // Checking if the final flight to the first city is legal
        departure = tour[numOfFlights - 1];
        destination = tour[0];
        if (flights[departure][destination] == false)
            return false;

        return true;
    }

    public static boolean isSolution(boolean[][] flights, int[] tour) {
        // Check the pre-written functions + verifies that the first city number is 0
        if (!(isLegalInstance(flights) && hasLegalSteps(flights, tour) && tour[0] == 0))
            return false;

        return true;
    }

    /// Start of Assignment 2B /////

    // Task 8
    public static int[][] atLeastOne(int[] vars) {
        int[][] formula = new int[1][vars.length];
        formula[0] = vars;
        return null;
    }

    // Task 9
    public static int[][] atMostOne(int[] vars) {
        int len = vars.length;
        // Calculating all of the the values combos
        int numOfClauses = len * (len - 1) / 2;

        // Initializing the formula with the number of clauses & 2 literals in each clause
        int[][] formula = new int[numOfClauses][0];

        // Coupling each literal with each one of the other literals inside clauses, and negate them
        int clauseIndex = 0;
        for (int i = 0; i < len; i = i + 1) {
            for (int j = i + 1; j < len; j = j + 1) {
                formula[clauseIndex][0] = vars[i] * (-1);
                formula[clauseIndex][1] = vars[j] * (-1);
                clauseIndex = clauseIndex + 1;
            }
        }

        return formula;
    }

    // Task 10
    public static int[][] exactlyOne(int[] vars) {

        // Repeating steps from Task 9 to ensure there's maximum 1 true variable
        int len = vars.length;
        int numOfClauses = len * (len - 1) / 2;
        // Creating extra row in the matrix for a clause which will be explained later
        int[][] formula = new int[numOfClauses + 1][];
        int clauseIndex = 0;
        for (int i = 0; i < len; i = i + 1) {
            for (int j = i + 1; j < len; j = j + 1) {
                formula[clauseIndex] = new int[2];
                formula[clauseIndex][0] = vars[i] * (-1);
                formula[clauseIndex][1] = vars[j] * (-1);
                clauseIndex = clauseIndex + 1;
            }
        }

        // Adding one more clause that contains all of the variables, to ensure there's a minimum of 1 true variable.
        // minimum 1 & maximum 1 = exactly one, as wee need.
        formula[numOfClauses] = new int[len];
        for (int i = 0; i < len; i = i + 1)
            formula[numOfClauses][i] = vars[i];

        return formula;
    }

    // Task 11
    public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {
        int nVars;
        int[] arr;
        int[][] formula;

        for (int i = 0; i < varSets.length; i++) {
            arr = varSets[i];
            nVars = findMax(arr);
            SATSolver.init(nVars);
            formula = exactlyOne(arr);
            SATSolver.addClauses(formula);
            boolean[] assignment = SATSolver.getSolution();
            if (assignment == null) System.out.println("TIMEOUT");
            else if (assignment.length == nVars + 1)
                System.out.println("SAT");
            else
                System.out.println("UNSAT");
        }
        return null;
    }

    // Task 12
    public static int[][] createVarsMap(int n) {
        int[][] map = new int[n][n];
        int counter = 0;
        for (int row = 0; row < n; row = row + 1)
            for (int column = 0; column < n; column++) {
                map[row][column] = counter;
                counter = counter + 1;
            }

        return map;
    }

    // Task 13
    public static int[][] oneCityInEachStep(int[][] map) {
        int n = map.length;     // # of rows in columns

        // Calculating the num of clauses desired for each row in the input matrix:
        int clausesForEachRow = n * (n - 1) / 2;

        // The output cnf formula -
        // rows: num of rows * num of clauses for each row
        // columns: varies for diff clauses, will be determined later
        int[][] formula = new int[n * clausesForEachRow][];

        int[][] rowFormula;
        int clauseIndex = 0;

        // The previous method 'exactlyOne' generates cnf formula for each row in the input matrix, and it saved to 'rowFormula'
        // All of the 2-columns clauses from rowFormula are copied to the final formula inside the inner loop
        // The n-columns clause is copied to the final formula separately right after the inner loop.
        for (int i = 0; i < n; i = i + 1) {
            rowFormula = exactlyOne(map[i]);
            for (int j = 0; j < clausesForEachRow; j = j + 1) {
                formula[clauseIndex] = new int[2];
                formula[clauseIndex] = rowFormula[j];
                clauseIndex = clauseIndex + 1;
            }
            formula[clauseIndex] = new int[n];
            formula[clauseIndex] = rowFormula[clausesForEachRow];
            clauseIndex = clauseIndex + 1;
        }

        return formula;
    }

    // Task 14
    public static int[][] fixSourceCity(int[][] map) {
        int[][] formula = new int[1][1];
        formula[0][0] = map[0][0];
        return formula;
    }

    // Task 15
    public static int[][] eachCityIsVisitedOnce(int[][] map) {

        int tmp;
        int n = map.length;

        // The formula in this task has 1 difference compared to the one from task 10: the rows and columns are reversed
        // Therefore, we can resolve this task by switching the rows and columns of the input matrix, and using task 10 function
        // The following loops commit the switch:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }

        int[][] formula = oneCityInEachStep(map);

        // We need to reverse the changes we made in the input matrix so it won't affect the rest of the functions:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }

        return formula;
    }

    // Task 16
    public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {
        return null;
    }

    // Task 17
    public static void encode(boolean[][] flights, int[][] map) {

    }

    // Task 18
    public static int[] decode(boolean[] assignment, int[][] map) {
        return null;
    }

    // Task 19
    public static int[] solve(boolean[][] flights) {
        return null;
    }

    // Task 20
    public static boolean solve2(boolean[][] flights) {
        return true;
    }

    // Gets array of numbers and returns the biggest one
    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }


}
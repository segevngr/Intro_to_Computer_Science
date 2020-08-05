
public class Assignment2A {

    public static boolean isSquareMatrix(boolean[][] matrix){
        // Checking if the matrix is null beforehand to avoid NPE
        if(matrix == null)
            return false;

	    int len = matrix.length;
	    // Checking the length of each sub-array in the matrix and verifies that it equals to the # of arrays
	    for(int i=0; i<len; i++)
        {
            if(matrix[i] == null || matrix[i].length != len)
                return false;
        }
		return true;
	}



	public static boolean isSymmetricMatrix(boolean[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++)
        {
            for(int j=0; i<len; i++)
                // Checking Symmetry
                if(matrix[i][j] != matrix[j][i])
                    return false;
        }
		return true;
	}


	
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++)
        {
            // Checking Anti Reflexive
                if(matrix[i][i] != false)
                    return false;
        }
        return true;
	}


	
	public static boolean isLegalInstance(boolean[][] matrix){
		if(!(isSquareMatrix(matrix) && isSymmetricMatrix(matrix) && isAntiReflexiveMatrix(matrix)))
		    return false;
        return true;
	}


	public static boolean isPermutation(int[] array){
        int len = array.length;
        boolean numInArray;
        // i represents all the numbers from 0 too array length -1
        // the program checks if 'i' is inside the array by comparing it to each of the array values
        // j is the array index used for this comparison.
        for(int i=0; i<len; i++)
        {
            numInArray = false;
            for(int j=0; j<len; j++)
                if(i == array[j])
                    numInArray = true;
            if(!numInArray)
                return false;
        }

		return true;
	}

	
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
        int numOfFlights = tour.length;
        int departure, destination;
        for(int i=0; i<numOfFlights-1; i++)
        {
            departure = tour[i];    // Holds the # of the departure city
            destination = tour[i+1];    // Holds the # of the destination city
            if(flights[departure][destination] == false)    // Verifying the flight is legal by going over flights array
                return false;
        }

        // Checking if the final flight to the first city is legal
        departure = tour[numOfFlights - 1];
        destination = tour[0];
        if(flights[departure][destination] == false)
            return false;

		return true;
	}
	
	public static boolean isSolution(boolean[][] flights, int[] tour){
        // Check the pre-written functions + verifies that the first city number is 0
        if( !(isLegalInstance(flights) && hasLegalSteps(flights, tour) && tour[0] == 0) )
            return false;

		return true;
	}
}

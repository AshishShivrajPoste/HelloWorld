public class Matrix_V2 {
	
public void calculateSumofDiagonals(int row ,int col){
    int diagonalRLSum =0;
	int diagonalLRSum =0;
	int[][] matrix= new int[row][col];
	int n=matrix.length;
	/** Populate the Matrix */
	for (int i=0;i<row;i++){
		for (int j=0;j<col;j++){
			matrix[i][j]=i+j;
		}
	}
	for (int i=0;i<row;i++){
	System.out.println();
		for (int j=0;j<col;j++){
			System.out.print("    "+matrix[i][j]);
		}
	}
        System.out.println();
	/**
	 * Calculate Left to Right Diagonal Sum
	 */
	for(int i=0, j=0; i < row || j < col; i++,j++){
		diagonalLRSum =diagonalLRSum + matrix[i][j];
	}
	
	/**
	 * Calculate Right to Left Diagonal Sum
	 */
	for(int i=0, j=n-1; i < row || j >= 0; i++,j--){
		diagonalRLSum =diagonalRLSum + matrix[i][j];
	}
	System.out.println("Left to Right Diagonal Sum is-->"+diagonalRLSum);
	System.out.println("Right to Left Diagonal Sum is-->"+diagonalLRSum);
    int sumofdiagonals = diagonalRLSum+diagonalLRSum;
    System.out.println("Sum of Diagonals-->"+sumofdiagonals);
}
}
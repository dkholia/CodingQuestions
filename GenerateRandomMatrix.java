import java.util.Random;

/**
Random generate a NxN matrix with only four types of element: 1,2,3,4. 
However, no column or row can have same type of element appears 3 times or above continuously (three same type of elements are connected)

ex: 

valid: 
1 2 1 1 
3 1 4 2 
1 2 4 2 
3 1 2 3 

invalid because the first column has element 1 appears three times and all 1s are connected to each other : 

1 2 1 3 
1 3 4 2 
1 2 4 4 
2 3 2 2
 */
public class GenerateRandomMatrix {
	public static void main(String[] args) {
		int [] []  matrix = new GenerateRandomMatrix().getRandomMatrix(4);
		for (int i=0;i<matrix.length;i++){
			for ( int j=0 ;j<matrix.length;j++){
				System.out.print(matrix[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	private  int[][] getRandomMatrix(int size){
		int [] [] matrix = new int[size][size];
		int random;
		for (int i=0;i<size;i++){
			for ( int j=0 ;j<size;j++){
				random = getRandomNumber();
				matrix[i][j]= random;
				if((((i - 1) >=  0) && ((i-2)>=0)) ){
					if( (matrix[i][j] == matrix[i-1][j] && matrix[i][j]== matrix[i-2][j] ) ){
						random = getRandomNumber();
						j--;
					}
				}
				if(((j-1)>=0) &&  ((j-2)>=0)){
					if((matrix[i][j]== matrix[i][j-1] && matrix[i][j]== matrix[i][j-2])){
						random = getRandomNumber();
						j--;
					}
				}
			}
		}
		return matrix;
	}
	
	private  int getRandomNumber() {
		 return new Random().nextInt(4)+1;
	}
}

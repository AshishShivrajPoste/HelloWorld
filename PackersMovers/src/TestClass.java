import java.util.Scanner;


public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
    	TestClass tstClass = new TestClass();
        int numberofMovers = 0;;
    	int numberofPackages = 0;
    	int weightArray[] = null;
    	Scanner scan = new Scanner(System.in);
        numberofMovers = scan.nextInt();
        numberofPackages = scan.nextInt();
        
        weightArray = new int[numberofPackages];
         	for(int i = 0; i < numberofPackages;i++){
         		   int x = scan.nextInt();
         		   weightArray[i] = x;
         	 }
         	if(numberofMovers > numberofPackages){
         		int output = findMaximum(weightArray);
         		System.out.println(output);
         		return;
            }
         	int output =  tstClass.minimumValueMovers(numberofMovers, numberofPackages, weightArray, 0);
         	System.out.println(output);

	}
	
	private static int findMaximum(int[] weightArray) {
		int max = weightArray[0];
		for(int i = 1; i < weightArray.length;i++){
			if(max < weightArray[i]){
				max = weightArray[i];
			}
		}
		return max;
	}

	public int minimumValueMovers(int movers,int packages,int[] weights,int startIndex){
		int weight = 0;
		if(movers == 1){
			for(int i = startIndex ; i < weights.length;i++){
				weight = weight+weights[i];
			}
			return weight;
		}
		
		int minimum =(int)(1.0/0);
		int output =0;
		for(int i = startIndex; i <= weights.length-movers;i++){
			weight = weight + weights[i];
			int returnValue = minimumValueMovers(movers-1, packages, weights,i+1);
			int difference = Math.abs(returnValue-weight);
			
			if(difference < minimum){
				minimum = difference;
				output = maximum(returnValue, weight);
			}
		}
		return output;
		
	}

	private int maximum(int value1, int value2) {
		if(value1 > value2){
			return value1;
		}else{
			return value2;
		}
	}


}

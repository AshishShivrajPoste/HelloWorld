/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;

class TestClass1 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
    	TestClass1 tstClass = new TestClass1();
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
         	int output =  tstClass.maximumweight(weightArray,numberofMovers,numberofPackages);
        System.out.println(output);
    }
    
    public int maximumweight(int[] weightArray,int numberofMovers,int numberofPackages ){
    	int totalweight = 0;
    	for(int i = 0; i < numberofPackages;i++){
    		totalweight = totalweight + weightArray[i];
         	 }
        int w = totalweight / numberofMovers;
        
        
        int maxWeightPossible = knapSack( w, weightArray,numberofPackages);
        return (totalweight - maxWeightPossible);
    }
    public int max(int a, int b) { return (a > b)? a : b; }
    public int knapSack(int W, int wt[], int n)
	{
	   	// Base Case
	   	if (n == 0 || W == 0)
	       return 0;
	 
	   // If weight of the nth item is more than Knapsack capacity W, then
	   // this item cannot be included in the optimal solution
	   if (wt[n-1] > W)
	       return knapSack(W, wt, n-1);
	 
	   // Return the maximum of two cases: (1) nth item included (2) not included
	   else return max( wt[n-1] + knapSack(W-wt[n-1], wt, n-1),knapSack(W, wt, n-1));
	}
}


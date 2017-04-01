import java.util.Arrays;

public class Minion_scheduling {
    public static int[] answer(int[] data, int n){
    	int[] myAnswer = data;
    	int numCount = 0;
    	for(int currentNumber : data) {
    		//System.out.println("current Number: " + currentNumber);
    		// Iterate through array and get number of occurrences
    		for(int searchInt : myAnswer) {
    			if(searchInt == currentNumber) {
    				numCount++;
    			}
    		}
    		if(numCount > n) {
    			int[] temp = myAnswer;
                int newLength = temp.length - numCount;
                //System.out.println("Length of new array:"+ newLength);
                int index = 0;
                myAnswer = new int[newLength];
                for(int i = 0; i < temp.length; i++) {
                    if(temp[i] != currentNumber) {
                        myAnswer[index] = temp[i];
                        index++;
                    }
                }
                //for(int z : myAnswer) {
                //	System.out.println(z);
                //}
    		}
    	    numCount =0;
    	    //System.out.println("Reseting");
    	}
    	return myAnswer;
    }
	public static void main(String[] args) {
       int[] myArray = new int[]{3,1,4,1,5,9,2,6,5,3};
       int n = 1;
       System.out.println("Input:\n" + Arrays.toString(myArray));
       System.out.println("n = " + n);
       int[] outputArray = answer(myArray, n);
       System.out.println("Result:\n" + Arrays.toString(outputArray));
   }
}

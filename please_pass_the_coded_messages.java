import java.util.Arrays;

/* You have L, a list containing some digits (0-9)
 * Write a function in Answer(L) which finds the largest
 * number that can be made from some or all of these digits
 * AND is divisible by 3. If it is not possible to make
 * such a number, return 0 as the answer. L will contain
 * anywhere from 1-9 digits. The same digit may appear 
 * multiple times in the list, but each element in the 
 * list may only be used once. 
 */
public class please_pass_the_coded_messages {
	static int myAnswer = 0;
	public static int Answer(int[] l){
		int[] sortList = l;
		Arrays.sort(sortList);
		sortList = reverse(sortList);

	    for(int x = l.length; x > 0; x--) {
	    	printCombinations(sortList, l.length, x);
	    }
				
		return myAnswer;
	}
	public static void computeCombinations(int arr[], int data[], int start,
											int end, int index, int r) {
		
		if(index == r) {
			for(int j=0; j<r; j++){
				//System.out.print(data[j]+" ");
			}
			if(computeSum(data)%3 == 0) {
				//System.out.print(", Multiple of 3");
				int temp = largestValue(data);
				if(myAnswer < temp) {
					myAnswer = temp;
				}
			}
			//System.out.println("");
			return;
		}
		
		for(int i=start; i<= end && end-i+1 >= r-index; i++) {
			data[index] = arr[i];
			computeCombinations(arr, data, i+1, end, index+1, r);
		}
		
	}
	public static void printCombinations(int arr[], int n, int r) {
		// Temporary array to store all combinations
		int data[] = new int[r];
		computeCombinations(arr, data, 0, n-1, 0, r);
		
	}
	public static int computeSum(int[] inputList){
		int value = 0;
		for (int currentVal : inputList) {
			value += currentVal;
		}
		return value;
	}
	// Given a list of digits, return largest value using those digits
	public static Integer largestValue(int[] inputList) {
		//int largestValue = 0;
		
		StringBuilder strNum = new StringBuilder();
		for (int num : inputList) {
		     strNum.append(num);
		}
		return Integer.parseInt(strNum.toString());
		//return largestValue;
	}
	
	public static int[] reverse(int[] inputList) {
		if(inputList == null) {
			return inputList;
		}
		int i = 0;
		int j = inputList.length - 1;
		int tmp;
		while (j > i) {
			tmp = inputList[j];
			inputList[j] = inputList[i];
			inputList[i] = tmp;
			j--;
			i++;
		}
		return inputList;
	}
	public static void main(String[] args) {
		int[] list = new int[]{1,0,3,0,1,0,0,0,1};	
		System.out.println("Input:\n" + Arrays.toString(list));
	
	    int result = Answer(list);
	    System.out.println("Result:\n" + result);
	       
	}

}

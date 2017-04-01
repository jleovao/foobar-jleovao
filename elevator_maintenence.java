import java.util.Arrays;

/*Elevator Maintenance
====================

You've been assigned the onerous task of elevator maintenance - ugh! It 
wouldn't be so bad, except that all the elevator documentation has been 
lying in a disorganized pile at the bottom of a filing cabinet for years, 
and you don't even know what elevator version numbers you'll be working on. 

Elevator versions are represented by a series of numbers, divided up into 
major, minor and revision integers. New versions of an elevator increase 
the major number, e.g. 1, 2, 3, and so on. When new features are added to 
an elevator without being a complete new version, a second number named 
"minor" can be used to represent those new additions, e.g. 1.0, 1.1, 1.2, 
etc. Small fixes or maintenance work can be represented by a third number 
named "revision", e.g. 1.1.1, 1.1.2, 1.2.0, and so on. The number zero can 
be used as a major for pre-release versions of elevators, e.g. 0.1, 0.5, 
0.9.2, etc (Commander Lambda is careful to always beta test her new technology,
 with her loyal henchmen as subjects!).

Given a list of elevator versions represented as strings, write a function 
answer(l) that returns the same list sorted in ascending order by major, 
minor, and revision number so that you can identify the current elevator 
version. The versions in list l will always contain major numbers, but 
minor and revision numbers are optional. If the version contains a revision 
number, then it will also have a minor number.

For example, given the list l as 
	["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"],
 the function answer(l) would return the list 
 	["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"].
 	 
 If two or more versions are equivalent but one version contains more numbers 
 than the others, then these versions must be sorted ascending based on 
 how many numbers they have, e.g ["1", "1.0", "1.0.0"]. The number of 
 elements in the list l will be at least 1 and will not exceed 100.
*/
public class elevator_maintenence {
	 public static String[] answer(String[] l) { 
	        // an array of length 1 or 0 is already sorted
	        if( l == null || l.length == 0 ) {
	            return null;
	        }
	        String[] sortedList = QuickSort(l, 0, l.length-1); 
	        return sortedList;
	    }
	    public static String[] QuickSort(String[] output, int low, int high ) {
	    	
	        int i = low;
	        int j = high;
	        // pivot element from middle of list
	        String pivot = output[low + (high-low) / 2];
	        // Divide into two lists
	        while( i <= j ){
	            // if current value from left list is smaller than the pivot
	            while( 0 > compareElevatorVersions(output[i], pivot) ) {
	                i++;
	            }
	            // if current value from the right list is larger than the pivot
	            while( 0 < compareElevatorVersions(output[j], pivot) ) {
	                j--;
	            }
	            // if value in left list is larger than pivot and value in right 
	            // list is smaller than pivot, exchange the values.
	            if( i <= j ) {
	                output = exchange(output, i, j);
	                i++;
	                j--;
	            }
	        }
	        // Recursive call
	        if( i < high ){
	            output = QuickSort(output, i, high);
	        }
	        if( j > low ){
	            output = QuickSort(output, low, j);
	        }
	        return output;
	    }
	    // Function to exchange two elements in an array
	    public static String[] exchange(String[] inputList, int x, int y) {
	    	String temp = inputList[x];
	    	inputList[x] = inputList[y];
	    	inputList[y] = temp;
	    	return inputList;
	    }
	    
	    // Used to compare two elevator versions
	    public static int compareElevatorVersions(String versionOne, String versionTwo){
	        // return 0 if versions are equal
	        if(versionOne.equals(versionTwo) ) {
	            return 0;
	        }
	        // Split strings based on '.' delimeter
	        String[] first = versionOne.split("\\.");
	        String[] second = versionTwo.split("\\.");
	        int valueDiff = Integer.parseInt(first[0]) - Integer.parseInt(second[0]);
	        // version numbers differ by major number
	        if( valueDiff != 0 ) {
	            return (valueDiff > 0)?1:-1;
	        }
	        
	        int firstLength = first.length;
	        int secondLength = second.length;
	        // version numbers length differ
	        if( firstLength == 1 || secondLength == 1 ) {
	            return ( firstLength > secondLength )? 1:-1;
	        }
	        // version numbers differ by minor number
	        valueDiff = Integer.parseInt(first[1]) - Integer.parseInt(second[1]);
	        if( valueDiff != 0 ) {
	            return (valueDiff > 0)?1:-1;
	        }
	        
	        if( firstLength == 2 || secondLength == 2 ) {
	            return ( firstLength > secondLength )? 1:-1;
	        }
	        // versions differ by revision number
	        valueDiff = Integer.parseInt(first[2]) - Integer.parseInt(second[2]);
	        if( valueDiff != 0 ) {
	            return (valueDiff > 0)?1:-1;
	        }
	        return 0;
	    }
    
	public static void main(String[] args) {
		String[] list = new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
	    System.out.println("Input:\n" + Arrays.toString(list));
	    String[] result = answer(list);
	    System.out.println("Result:\n" + Arrays.toString(result));
	}

}

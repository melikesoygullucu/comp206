import java.util.Arrays;

public class BubbleSort {
	static void bubbleSort(int array[]) {
	    int size = array.length;
	    // loop over each element of the array to access them
	    for (int i = 0; i < size - 1; i++)
	      // compare the elements of the array with a loop
	      for (int j = 0; j < size - i - 1; j++)
	        // compare two adjacent elements in the array
	        if (array[j] > array[j + 1]) {
	          // Swap if the elements aren't in the right order
	          int temp = array[j];
	          array[j] = array[j + 1];
	          array[j + 1] = temp;
	        }
	  }

	  public static void main(String args[]) {
	    int[] data = { 26, 10, 50, 55, 71, 22, 96, 75, 95, 29 };
	    // call the method using class name
	    
	    for(int i =0; i<data.length;i++) {
	    	for(int j =1; j<data.length-i; j++) {
	    		 if (data[j-1] > data[j ]) {
	    			 int temp = data[j];
	   	          data[j] = data[j -1];
	   	          data[j - 1] = temp;
	    		 }
	    		 System.out.println(Arrays.toString(data));
	    	}
	    	
	    }
	  }
}
//	    BubbleSort.bubbleSort(data);
//	    
//	    System.out.println("Array sorted with bubble sort: ");
//	    System.out.println(Arrays.toString(data));
	  
//	void bubbleSort(int arr[]) {
//		int n = arr.length;
//		for (int i = 0; i < n - 1; i++)
//			for (int j = 0; j < n - i - 1; j++)
//				if (arr[j] > arr[j + 1]) {
//					// swap arr[j+1] and arr[j]
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//	}
//
//	/* Prints the array */
//	void printArray(int arr[]) {
//		int n = arr.length;
//		for (int i = 0; i < n; ++i)
//			System.out.print(arr[i] + " ");
//		System.out.println();
//	}
//
//	// Driver method to test above
//	public static void main(String args[]) {
//		BubbleSort ob = new BubbleSort();
//		int arr[] = { 5, 1, 4, 2, 8 };
//		ob.bubbleSort(arr);
//		System.out.println("Sorted array");
//		ob.printArray(arr);
//	}


//begin BubbleSort(arr)  
//   for all array elements  
//      if arr[i] > arr[i+1]  
//         swap(arr[i], arr[i+1])  
//      end if  
//   end for     
//   return arr     
//end BubbleSort  
//Best Case	O(n)
//Average Case	O(n2)
//Worst Case	O(n2)
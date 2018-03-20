package Sort_and_Search;

public class Sort {
	
	private static int partition (int left, int right, int initialPivotPosition, double... array){
		
		double pivot = array[initialPivotPosition];
		double temp = 0;
		
		while (left <= right){
			
			while (array[left] < pivot){
				
				left++;
			}
			
			while (array[right] > pivot){
				
				right--;
			}
			
			if(left <= right){
				
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	public static void lightSort (double... array){
		
		quickSort (0, array.length - 1, array);
	}
	
	private static void quickSort (int left, int right, double... array){
		
		if (array == null || left >= right){
			
			return;
		
		} else if (right - left + 1 <= 7){
			System.out.println("Ola");
			insertionSort(array);
			return;
		}
		
		int initialPivotPosition = (left + right)/2;
		
		int newPivotPosition = partition(left, right, initialPivotPosition, array);
		
		
		quickSort(left, newPivotPosition - 1, array);
		
		quickSort(newPivotPosition, right, array);
		
	}
	
	public static void insertionSort (double... array){
		
		double temp = 0;
		
		for (int i = 0; i < array.length; i++){
			
			for (int j = i + 1; j < array.length - 1; j++){
				
				if (array[j] < array[i]){
					
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}

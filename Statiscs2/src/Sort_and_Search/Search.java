package Sort_and_Search;

public class Search {
	
	public static int binarySearch (double item, double... array){
		
		return binarySearch (0, array.length - 1, item, array);
	}
	
	private static int binarySearch (int indexBeginning, int indexEnd, double item, double... array){
		
		if (array == null){
			
			return -1;
		}
		
		int middleIndex = (indexEnd + indexBeginning)/2;
		
		if (item == array[middleIndex]){
			
			return middleIndex;
			
		} else if (indexEnd - indexBeginning == 0){
			
			return -1;
			
		} else if (item < array[middleIndex]){
			
			return binarySearch (indexBeginning, middleIndex - 1, item, array);
			
		} else if (item > array[middleIndex]){
			
			return binarySearch (middleIndex + 1, indexEnd, item, array);
			
		} 
			
		return -1;
		
		
	}
	
}

package Calculations;

public class HelperCalculator {

	public static double sumOfElements (int left, int right, double... array){
		
		if (array == null || right - left + 1 <= 0){
			
			return -1;
		}
		
		double sum = 0;
		
		for (int i = left; i <= right; i++){
			
			sum += array[i];
		}
		
		return sum;
	}
	
	public static double sumOfSquaredElements (int left, int right, double... array){
		
		if (array == null || right - left + 1 <= 0){
			
			return -1;
		}
		
		double sum = 0;
		
		for (int i = left; i <= right; i++){
			
			sum += Math.pow(array[i], 2);
		}
		
		return sum;
	}
	
	public static int numItems (double[] array){
		
		if (array == null){
			
			return -1;
		}
		
		return array.length;
		
	}
}

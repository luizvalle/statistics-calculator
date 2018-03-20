package Calculations;

public class SpreadCalculator {

	public static double rangeCalculator (double... array){
		
		if (array == null || array.length == 0){
			
			return -1;
		}
		
		return array[array.length - 1] - array[0];
	}
	
	public static double midRangeCalculator (double... array){
		
		if (array == null || array.length <= 1){
			
			return 0;
		}
		
		return (array[0] + array[array.length - 1])/2;
	}
	
	public static double iqrCalculator (double q1, double q3){
		
		return q3 - q1;
	}
	
	public static double varianceCalculator (int left, int right, double mean, double... array){
		
		int numElements = right - left + 1;
		
		if (array == null || numElements <= 0){
			
			return -1;
		}
		
		double sum = 0;
		
		for (double num : array){
			
			sum += Math.pow((num - mean), 2);
		}
		
		return sum/numElements;
	}
	
	public static double standDeviationCalculator (double variance){
		
		if (variance < 0){
			
			return -1;
		}
		
		return Math.sqrt(variance);
	}

	public static double q1Calculator (double... array){
		
		return AverageCalculator.calculateMedian(0, array.length/2 - 1, array);
	}
	
	public static double q3Calculator (double... array){
		
		return AverageCalculator.calculateMedian(array.length/2 + 1, array.length - 1, array);
	}
}

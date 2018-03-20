package Calculations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Sort_and_Search.Sort;

public class AverageCalculator {

	public static double calculateMean (int left, int right, double sum, double... array){
		
		int numElements = right - left + 1;
		
		if (array == null || numElements <= 0){
			
			return -1;
		}
		
		return sum/numElements;
		
	}
	
	public static double calculateMedian (int left, int right, double... array){
		
		int numberOfElements = right - left + 1;
		
		if (array == null || numberOfElements <= 0){
			
			return -1;
		}
		
		int middleElement = (right + left)/2;
		
		if (numberOfElements % 2 == 0){
			
			double firstElement = array[middleElement];
			double secondElement = array[middleElement + 1];
			
			return (firstElement + secondElement)/2;
		
		} else{
			
			return array[middleElement];
		}
	}
	
	public static double[] calculateMode (int left, int right, double... array){
		
		int numElements = right - left + 1;
		
		if (array == null || numElements <= 0){
			
			return null;
		}
		
		Map <Double, Integer> instances = new HashMap <> ();
		
		int maxInstances = 2;
		
		for (int i = left; i < right; i++){
			
			if (array[i] == array[i + 1]){
				
				int lastIndex = i;
				
				while (lastIndex < right + 1 && array[lastIndex] == array[i]){
					
					lastIndex++;
				}
				
				lastIndex--;
				
				int numInstances = lastIndex - i + 1;
				
				if (numInstances >= maxInstances){
					
					instances.put(array[i], numInstances);
					
					maxInstances = (numInstances > maxInstances) ? numInstances : maxInstances;
				}
				
				i = lastIndex;
			}
		}
		
		if (!instances.isEmpty()){
			
			Set <Double> maxNums = instances.keySet();
			Double[] maxNumss = maxNums.toArray(new Double[0]);
			
			for (double repeatedNum : maxNumss){
				
				if (instances.get(repeatedNum) < maxInstances){
					
					instances.remove(repeatedNum);
				
				}
				
			}
			
			int size = maxNums.size();
			double[] modes = new double[size];
			int index = 0;
			
			for (double num : maxNums){
				
				modes[index] = num;
				index++;
			}
			
			Sort.lightSort(modes);
			
			return modes;
			
		}
		
		return null;
	}
}

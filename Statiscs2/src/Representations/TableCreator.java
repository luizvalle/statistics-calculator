package Representations;

import Calculations.SpreadCalculator;
import Sort_and_Search.Sort;

public class TableCreator {

	public static String createStleafPlot (double... array){
		
		StringBuilder stleaf = new StringBuilder ();
		int firstStem = 0;
		int lastStem = 0;
		int index = 0;
		
		if (array[array.length/2] != (int) array[array.length/2]){
			
			String first = ("" + array[0]).replace(".", "");
			
			firstStem = Integer.parseInt(first)/10;
			
			String last = ("" + array[array.length - 1]).replace(".", "");
			lastStem = Integer.parseInt(last)/10;
			
			for (int stem = firstStem; stem <= lastStem; stem++){
				
				stleaf.append(stem + " |");
				
				while (index < array.length && Integer.parseInt(("" + array[index]).replace(".", ""))/10 == stem){
					
					stleaf.append(" " + Integer.parseInt(("" + array[index]).replace(".", ""))%10);
					index++;
				}
				
				stleaf.append("\n");
			}
			
			stleaf.append("\t Key: " + firstStem + " | " + Integer.parseInt(("" + array[0]).replace(".", ""))%10 + " = " + array[0]);
		} else {
			
			firstStem = (int) array[0]/10;
			lastStem = (int) array[array.length - 1]/10;
			
			for (int stem = firstStem; stem <= lastStem; stem++){
				
				stleaf.append(stem + " |");
				
				while (index < array.length && (int) array[index]/10 == stem){
					
					stleaf.append(" " + (int) array[index]%10);
					index++;
				}
				
				stleaf.append("\n");
			}
			
			stleaf.append("\n\t Key: " + firstStem + "|" + (int) array[0]%10 + " means " + (int) array[0]);
			
		}
		
		return stleaf.toString();
	}
}

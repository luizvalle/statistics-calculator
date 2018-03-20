package Data;

import Calculations.AverageCalculator;
import Calculations.HelperCalculator;
import Calculations.SpreadCalculator;
import Representations.TableCreator;
import Sort_and_Search.Sort;

public class Data {

	private double[] data;
	
	private int size;
	private double sum;
	private double sumSquares;
	
	private double mean;
	private double median;
	private double[] modes;
	private String modesString;
	
	private double variance;
	private double standardDeviation;
	private double q1;
	private double q3;
	private double iqr;
	private double range;
	private double midrange;
	
	private String boxAndWhiskerPlot;
	
	public void intializeData (double... array){
		
		Sort.lightSort(array);
		
		this.data = array;
		this.size = HelperCalculator.numItems(data);
		this.sum = HelperCalculator.sumOfElements(0, size - 1, data);
		this.sumSquares = HelperCalculator.sumOfSquaredElements(0, size - 1, data);
		this.mean = AverageCalculator.calculateMean(0, size - 1, sum, data);
		this.median = AverageCalculator.calculateMedian(0, size - 1, data);
		this.modes = AverageCalculator.calculateMode(0, size - 1, data);
		this.boxAndWhiskerPlot = TableCreator.createStleafPlot(data);
		
		if (modes != null){
			
			this.modesString = getModesString();
		}

		this.variance = SpreadCalculator.varianceCalculator(0, size - 1, mean, data);
		this.standardDeviation = SpreadCalculator.standDeviationCalculator(variance);
		this.q1 = SpreadCalculator.q1Calculator(data);
		this.q3 = SpreadCalculator.q3Calculator(data);
		this.iqr = SpreadCalculator.iqrCalculator(q1, q3);
		this.range = SpreadCalculator.rangeCalculator(data);
		this.midrange = SpreadCalculator.midRangeCalculator(array);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder ();
		
		for (int i = 0; i < this.size; i++){
			
			s.append(data[i]);
			
			if (i < this.size - 1){
				
				s.append(", ");
			}
		}
		
		return s.toString();
	}

	public double[] getData() {
		return data;
	}
	
	public String getDataString() {
		
		StringBuilder s = new StringBuilder ();
		
		for (int i = 0; i < data.length; i++) {
			
			s.append(data[i]);
			if (i < data.length - 1){
				
				s.append(", ");
			}
		}
		
		return s.toString();
	}

	
	public int getSize() {
		return size;
	}

	public double getSum() {
		return sum;
	}

	public double getSumSquares() {
		return sumSquares;
	}

	public double getMean() {
		return mean;
	}

	public double getMedian() {
		return median;
	}
	
	public String getBoxAndWhiskerPlot() {
		return boxAndWhiskerPlot;
	}

	public String getModes() {
		
		if (modes == null || modes.length == 0){
			
			return modesString;
		}
		StringBuilder s = new StringBuilder ();
		
		for (int i = 0; i < this.modes.length; i++){
			
			s.append(modes[i]);
			
			if (i < this.modes.length - 1){
				
				s.append(", ");
			}
		}
		
		modesString = s.toString();
		
		return modesString;
		
	}
	
	public String getModesString() {
		
		StringBuilder s = new StringBuilder ();
		
		for (int i = 0; i < this.modes.length; i++){
			
			s.append(modes[i]);
			
			if (i < this.modes.length - 1){
				
				s.append(", ");
			}
		}
		
		return s.toString();
	}

	public double getVariance() {
		return variance;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public double getQ1() {
		return q1;
	}

	public double getQ3() {
		return q3;
	}

	public double getIqr() {
		return iqr;
	}

	public double getRange() {
		return range;
	}

	public double getMidrange() {
		return midrange;
	}

	
}

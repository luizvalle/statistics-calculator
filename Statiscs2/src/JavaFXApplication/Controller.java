package JavaFXApplication;

import Data.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	private TextArea dataTxtArea;
	
	@FXML
	private TextField meanTextField;
	
	@FXML
	private TextField medianTextField;
	
	@FXML
	private TextField modeTextField;
	
	@FXML
	private TextField sizeTextField;
	
	@FXML
	private TextField varianceTextField;
	
	@FXML
	private TextField standardDeviationTextField;
	
	@FXML
	private TextField rangeTextField;
	
	@FXML
	private TextField midRangeTextField;
	
	@FXML
	private TextField iqrTextField;
	
	@FXML
	private Button computeBtn;
	
	@FXML
	private Button clearBtn;
	
	
	private Data data = new Data ();
	
	public void compute (){
		
		String dataString = dataTxtArea.textProperty().getValue();
		
		if (dataString == null || dataString.length() == 0){
			
			return;
		}
		dataString = dataString.trim();
		String[] buffer = dataString.split(", ");
		double[] array = new double[buffer.length];
		
		for (int i = 0; i < array.length; i++){
			
			array[i] = Double.parseDouble(buffer[i]);
		}
		
		data.intializeData(array);
		
		dataTxtArea.textProperty().set(data.getDataString());
		meanTextField.textProperty().set("" + data.getMean());
		medianTextField.textProperty().set("" + data.getMedian());
		modeTextField.textProperty().set(data.getModes());
		sizeTextField.textProperty().set("" + data.getSize());
		varianceTextField.textProperty().set("" + data.getVariance());
		standardDeviationTextField.textProperty().set("" + data.getStandardDeviation());
		rangeTextField.textProperty().set("" + data.getRange());
		midRangeTextField.textProperty().set("" + data.getMidrange());
		iqrTextField.textProperty().set("" + data.getIqr());
		
	}
	
	public void clear (){
		
		dataTxtArea.clear();
		meanTextField.clear();
		medianTextField.clear();
		modeTextField.clear();
		sizeTextField.clear();
		varianceTextField.clear();
		standardDeviationTextField.clear();
		rangeTextField.clear();
		midRangeTextField.clear();
		iqrTextField.clear();
	}
	
}

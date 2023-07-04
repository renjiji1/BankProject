package mainTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
	static String [][] dataArray;

	    public static void main() {

	        String csvFile = "data.csv";
	        String line = "";
	        String csvSplitBy = ",";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            // determine number of rows and columns
	            int numRows = 0;
	            int numCols = 0;
	            boolean isFirstLine = true;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(csvSplitBy);
	                if (isFirstLine) {
	                    numCols = values.length;
	                    isFirstLine = false;
	                }
	                numRows++;
	            }

	            // initialize array
	            dataArray = new String[numRows][numCols];

	            // read data into array
	            int rowNum = 0;
	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(csvSplitBy);
	                for (int colNum = 0; colNum < numCols; colNum++) {
	                    dataArray[rowNum][colNum] = values[colNum];
	                }
	                rowNum++;
	            }

	            // print array contents
	            for (int i = 0; i < numRows; i++) {
	                for (int j = 0; j < numCols; j++) {
	                    System.out.print(dataArray[i][j] + " ");
	                }
	                System.out.println();
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	    }
	    public static String[][] getdataArray() {
        	return dataArray;
        }
}
	




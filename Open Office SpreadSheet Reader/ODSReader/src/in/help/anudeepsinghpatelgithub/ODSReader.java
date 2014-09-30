package in.help.anudeepsinghpatelgithub;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.jopendocument.model.OpenDocument;
import org.jopendocument.sample.SpreadSheetCreation;

public class ODSReader {
	
	@SuppressWarnings("finally")
	public Map<Integer,List<String>> readODSSpreadSheet(File file,int sheetNumber){
		
		Map<Integer,List<String>> odsRowValue=new HashMap<Integer,List<String>>();
			
		 try {
			 
			final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(sheetNumber);
			int rows=sheet.getRowCount();
			int cols=sheet.getColumnCount();
			
			for (int i = 0; i < rows; i++) {
				List<String> rowData=new ArrayList<String>();
				
				for (int j = 0; j < cols; j++) {
					rowData.add(sheet.getCellAt(j, i).getTextValue());
				}
				odsRowValue.put(i+1, rowData);
			}
			
		//	System.out.println(sheet.getCellAt(2, 1).getTextValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 return odsRowValue;
		 }
		
	}
	
	

}

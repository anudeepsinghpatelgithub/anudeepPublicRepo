package in.help.anudeepsinghpatelgithub.test;

import in.help.anudeepsinghpatelgithub.ODSReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ODSReaderTest {
	
	public static void main(String[] args){
	
		ODSReader odsReader= new ODSReader();
		File file= new File("ods/my.ods");
		Map<Integer,List<String>> odsRowValue=odsReader.readODSSpreadSheet(file, 0);
		
		for (Entry<Integer,List<String>> entry:odsRowValue.entrySet()) {
			
			System.out.print("Row"+entry.getKey()+"-->");
			System.out.println(entry.getValue());
		}
	}
	

}

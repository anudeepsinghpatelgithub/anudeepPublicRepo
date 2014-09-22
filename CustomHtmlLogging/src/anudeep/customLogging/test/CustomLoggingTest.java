package anudeep.customLogging.test;
import java.io.File;
import java.io.FileWriter;

import anudeep.customLogging.CustomLogging;

public class CustomLoggingTest {
	
	public static void main(String args[])
	{
	CustomLogging customLogin= new CustomLogging();
		
		String fileN="MyResultFile.html";
		String uniqueFileName=customLogin.uniqueFile(fileN);
		FileWriter fwr=customLogin.resultOutputFile(uniqueFileName);
		
		for (int i = 1; i < 11; i++) {
			String tcid="TESTCASEID"+i;
			String tcDesc="Test case desrciption "+i;
			String result="FAIL";
			if(getDemoTestResult(i))
			{
				result="PASS";
			}
			String expected="expected "+i;
			String actual ="actual " +i;
			String commnets ="commnets "+i;
			customLogin.addResult(fwr, tcid, tcDesc, result, expected, actual, commnets, uniqueFileName);
		}
		
		customLogin.closeOutputFile(fwr, uniqueFileName);
		
	}
	
	public static boolean getDemoTestResult(int i)
	{
		boolean ok=false;
		if ( (i % 2) == 0)
		{
		    ok = true;
		}
		
		return ok;
	}

}

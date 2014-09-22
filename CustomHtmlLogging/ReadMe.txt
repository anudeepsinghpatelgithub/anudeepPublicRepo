Points to remember
Most Important:
You need to create a folder inside project root directory with name "result" (same name.)
1) You need to give only HTML file name in the method uniqueFile(String fileNameWithHtmlExt) 
	e.g. fileNameWithHtmlExt="My Result.html";
2) You need to give only value for result either PASS/Fail. its not case sensitive but spelling should be same.
addResult(fwr, tcid, tcDesc, result, expected, actual, commnets, uniqueFileName);
	e.g. result ="PASS";
		result ="FAIL";
3) This program will not delete the existing files inside the result folder. You need to delete old files.
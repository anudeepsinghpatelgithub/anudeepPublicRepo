package remoteServerLogFileMatcher.logchecker.test;

import com.jcraft.jsch.JSchException;

import remoteServerLogFileMatcher.logchecker.RemoteServerLogFileMatcher;

public class GrepLogsTest {

	public static void main(String args[]){
		RemoteServerLogFileMatcher remoteServerLogFileMatcher=new RemoteServerLogFileMatcher();
		
		String command="grep literal_string filename";
		String pattern="some content to compile";
		try {
			remoteServerLogFileMatcher.grepLogs("anudeep", "anudeep", "localhost", 8080, command, pattern);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package remoteServerLogFileMatcher.logchecker.test;

import com.jcraft.jsch.JSchException;

import remoteServerLogFileMatcher.logchecker.RemoteServerLogFileMatcher;

public class GrepLogsTest {

	public static void main(String args[]){
		RemoteServerLogFileMatcher remoteServerLogFileMatcher=new RemoteServerLogFileMatcher();
		
		String command="grep literal_string filename";//dummy command
		String pattern="some content to compile";//dummy pattern
		
		try {
			remoteServerLogFileMatcher.grepLogs("anudeep", "anudeep", "localhost", 22, command, pattern);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

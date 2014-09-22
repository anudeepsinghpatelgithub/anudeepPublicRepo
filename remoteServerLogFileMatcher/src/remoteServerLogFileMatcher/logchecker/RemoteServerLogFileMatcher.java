package remoteServerLogFileMatcher.logchecker;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class RemoteServerLogFileMatcher {

	public boolean grepLogs(JSch jsch,String user, String pass, String host, int port,
			String command, String pattern) throws JSchException {
		boolean found = false;
	
		Session session = jsch.getSession(user, host, port);
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		String puttyCommondOutput = null;
		try {
			session.setPassword(pass);
			session.connect();
			if (session.isConnected()) {
				// user your command
				puttyCommondOutput = SendCommand(session, command);

				Pattern sBlockPattern = Pattern.compile(pattern);
				Matcher linkElementMatcher = sBlockPattern
						.matcher(puttyCommondOutput);
				if (linkElementMatcher.find()) {
					System.out.println("Content found in logs");
					found = true;

				} else {
					System.out.println("Content not found in logs");
				}

				session.disconnect();
			}

		} catch (Exception e) {

		} finally {
			return found;
		}

	}

	public String SendCommand(Session session, String sCommand) {
		String sOutputStr = "";

		try {
			// session.connect();
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(sCommand + "\n");
			((ChannelExec) channel).setErrStream(System.err);
			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];

			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);

					if (i < 0)
						break;
					String sOutStr = new String(tmp, 0, i);

					// sOutputStr=sOutputStr.concat("--");
					sOutputStr = sOutputStr.concat(sOutStr);

				}

				if (channel.isClosed()) {

					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			// session.disconnect();
			return sOutputStr;
		} catch (Exception e) {

		}

		finally {
			return sOutputStr;
		}

	}

}

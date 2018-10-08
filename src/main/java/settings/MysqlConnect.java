package settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlConnect {
//52.48.85.114
	static int nLocalPort = 3370; // local port number use to bind SSH tunnel
	static int nRemotePort = 3306;
	
	
	private static String getPem(String fileName) throws IOException {

		StringBuilder result = new StringBuilder("");
		File file = new File("src/main/resources/qaautomation.pem");

		BufferedReader br = new BufferedReader(new FileReader(file)); 
				  
		String line; 
		while ((line = br.readLine()) != null) {
			result.append(line).append("\n");
		} 
		br.close();
		
		return result.toString();
	}

	private static Session doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
			String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException, IOException {
		final JSch jsch = new JSch();
		jsch.addIdentity("privateKeyFile.pem", getPem("qaautomation.pem").getBytes(), null, null);
		Session session = jsch.getSession(strSshUser, strSshHost, 22);
		session.setPassword(strSshPassword);

		final Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		session.connect();
		session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
		return session;
	}
	


	public static String readTable(String scriptSQL) throws JSchException, IOException {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("123456a");
//		int nLocalPort = 3370; // local port number use to bind SSH tunnel
//		int nRemotePort = 3306;
//		System.out.println("1");
		Session session = doSshTunnel("ubuntu", null, "52.48.85.114", 22, "localhost", nLocalPort, nRemotePort);
//		System.out.println("2");
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("ostickets");
		dataSource.setPort(nLocalPort);
		String result= "";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println(scriptSQL);
			ResultSet rs = stmt.executeQuery(scriptSQL);
			
			 while (rs.next()){
				 result = rs.getString("result");
				 System.out.println("result: " + result);
			 }
			 
			rs.close();
			stmt.close();
			conn.close();			
			session.disconnect();
			System.out.println("SQL session is disconnected");
		} catch (Exception e) {
			System.out.println("SQL Connect Exception");
			e.printStackTrace();
			session.disconnect();
			// Your exception handling mechanism goes here.
			
			
		}
		return result;
	}
}

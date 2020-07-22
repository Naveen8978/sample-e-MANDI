package utility;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionManager {
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop=new Properties();
		InputStream in=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
  public final static Connection getConnection() throws Exception{

	  Properties prop=null;
	  try {
	  prop=loadPropertiesFile();
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  final String driver=prop.getProperty("driver");
	  final String url=prop.getProperty("url");
	  final String username=prop.getProperty("username");
      final String password=prop.getProperty("password");
	 
      
	  Class.forName(driver);
	  Connection con=DriverManager.getConnection(url,username,password);
	  if(con!=null) { 
		  System.out.println("Connection established");
		  return con;
	  }
	  else {
		  System.out.println("connection failed");
		  return null;
	  }
  }
}

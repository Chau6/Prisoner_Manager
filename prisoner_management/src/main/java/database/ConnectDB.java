package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectDB {
	// Class path có nghĩa là những gì để trong resources
		public static String getConnectionURLFromClassPath() {
			String strCon = null;
			try (
					// db.properties nằm ngoài resources
					InputStream file2 = new FileInputStream("db.properties");) {
				Properties prop = new Properties();
				prop.load(file2);
				strCon = prop.getProperty("url") + 
						prop.getProperty("serverName") + ":" + 
						prop.getProperty("portNumber") + ";databaseName=" + 
						prop.getProperty("databaseName") + ";user=" + 
						prop.getProperty("username") + ";password=" + 
						prop.getProperty("password");
			} catch (Exception e) {
				e.printStackTrace();
				strCon = null;
			}

			return strCon;
		}

		public static Connection getConnectionFromClassPath() {
			Connection connect = null;
			try {
				connect = DriverManager.getConnection(getConnectionURLFromClassPath()); // cổng kết nối
			} catch (Exception e) {
				e.printStackTrace();
			}

			return connect;
		}
}

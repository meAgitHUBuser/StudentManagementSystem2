package main.java.com.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("jdbc.driver");
                String url = prop.getProperty("jdbc.url");
                String user = prop.getProperty("jdbc.username");
                String password = prop.getProperty("jdbc.password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}

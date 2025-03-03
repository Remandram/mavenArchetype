package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public JDBCUtils() {}
    static {
            try{
                /*
                * 因为涉及到了读取文件: getResourceAsStream("path to file")
                * 所以用try
                * */
                Properties properties = new Properties();
                InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
                properties.load(in);
                driver = properties.getProperty("driver");
                url = properties.getProperty("url");
                user = properties.getProperty("user");
                password = properties.getProperty("password");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public static Connection getConnection() {
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

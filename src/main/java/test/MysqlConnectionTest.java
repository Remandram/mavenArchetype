package test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnectionTest {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from User";
        try{
            PreparedStatement preparedStatement = null;
            if (conn != null) {
                preparedStatement = conn.prepareStatement(sql);
            }
            ResultSet resultSet = null;
            if (preparedStatement != null) {
                resultSet = preparedStatement.executeQuery();
            }
            if (resultSet != null) {
                while (resultSet.next()) {
                    String id = resultSet.getString("userid");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String useremail = resultSet.getString("useremail");
                    System.out.println("userid:" + id + "\tusername:" + username + "\tpassword:" + password + "\tuseremail:" + useremail);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

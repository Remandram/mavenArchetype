package test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnectionTest {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from user";
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
                    String id = resultSet.getString("id");
                    String username = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String useremail = resultSet.getString("mail");
                    System.out.println("id:" + id + "\t\tname:" + username + "\t\tpassword:" + password + "\t\tmail:" + useremail);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

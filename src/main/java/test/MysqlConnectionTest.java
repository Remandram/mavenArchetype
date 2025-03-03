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
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

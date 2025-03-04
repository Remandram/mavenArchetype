package test;
import utils.JDBCUtils;
import chatRoom.pojo.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class GenerateMysqlVirtualUserDataTest {
    public static void createVirtualUserData(UserInfo userInfo) {
        Connection conn = JDBCUtils.getConnection();
        String UserName = userInfo.getUsername();
        String UserPassword = userInfo.getPassword();
        String UserEmail = userInfo.getEmail();
        String sql = "insert into User (username,password,useremail) values(?,?,?)";
        try{
            PreparedStatement preparedStatement = null;
            if (conn != null) {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, UserName);
                preparedStatement.setString(2, UserPassword);
                preparedStatement.setString(3, UserEmail);
                preparedStatement.execute();
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("123456");
        userInfo.setEmail("admin@qq.com");
        createVirtualUserData(userInfo);
    }

}

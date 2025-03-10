package test;
import utils.JDBCUtils;
import chatRoom.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GenerateMysqlVirtualUserDataTest {
    public static void createVirtualUserData(User User) {
        Connection conn = JDBCUtils.getConnection();
        String UserName = User.getName();
        String UserPassword = User.getPassword();
        String UserEmail = User.getMail();
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
        User User = new User();
        User.setName("admin");
        User.setPassword("123456");
        User.setMail("admin@qq.com");
        createVirtualUserData(User);
    }

}

package chatRoom.dao;
import chatRoom.pojo.UserInfo;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
*  DAO层
*  处于处理service层与mysql之间的一个缓冲层
*  service从DAO层中获取已经从数据库中获取数据的pojo
*  同时,service也可以通过DAO层向数据库提交数据/修改数据
*  骚点的操作就构造干活,慢点的就构造完起手
* */

public class UserDAO {
    public static UserInfo selectUser(UserInfo userInfo) {
        Connection conn = JDBCUtils.getConnection();
        try{
            if (userInfo.getUsername() != null){
                String sql = "select * from User where username=?";
                PreparedStatement preparedStatement = null;
                if (conn != null) {
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1,userInfo.getUsername());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()){
                        UserInfo user = new UserInfo();
                        user.setUserid(resultSet.getString("userid"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("useremail"));
                        return user;
                    }else{return null;}
                }
            }
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }
    public static int insertUser(UserInfo userInfo){
        Connection conn = JDBCUtils.getConnection();
        if (selectUser(userInfo) != null){
            return 1;
        }
        try{
            String sql = "insert into User (UserName,Password,UserEmail) values(?,?,?)";
            PreparedStatement preparedStatement = null;
            if (conn != null) {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, userInfo.getUsername());
                preparedStatement.setString(2, userInfo.getPassword());
                preparedStatement.setString(3,userInfo.getEmail());
                preparedStatement.execute();
                if (selectUser(userInfo) != null){
                    return 0;
                }
            }
        }catch (Exception e) {e.printStackTrace();}
        return -1;
    }
    public static int updateUser(UserInfo userInfo){

        return -1;
    }
    public static int deleteUser(UserInfo userInfo){
        Connection conn = JDBCUtils.getConnection();

        return -1;
    }

}

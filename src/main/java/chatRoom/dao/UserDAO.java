package chatRoom.dao;

import chatRoom.pojo.User;
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

public class UserDAO{
    /*
    *
    * */
    public static User query(User user) {
        Connection conn = JDBCUtils.getConnection();
        try{
            if (user.getName() != null){
                String sql = "select * from user where name=?";
                if (conn != null) {
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, user.getName());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()){
                        User rev = new User();
                        rev.setUid(resultSet.getString("uid"));
                        rev.setName(resultSet.getString("name"));
                        rev.setPassword(resultSet.getString("password"));
                        rev.setMail(resultSet.getString("mail"));
                        return rev;
                    }
                    return null;
                }
            }
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }

    public static int insert(User User){
        Connection conn = JDBCUtils.getConnection();
        if (query(User) != null){
            return 1;
        }
        try{
            String sql = "insert into user (name,password,mail) values(?,?,?)";

            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, User.getName());
                preparedStatement.setString(2, User.getPassword());
                preparedStatement.setString(3, User.getMail());
                preparedStatement.execute();
                if (query(User) != null){
                    return 0;
                }
            }
        }catch (Exception e) {e.printStackTrace();}
        return -1;
    }

    public static int update(User User){

        return -1;
    }

    public static int delete(User User){
        Connection conn = JDBCUtils.getConnection();

        return -1;
    }

}

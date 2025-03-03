package chatRoom.dao;
import chatRoom.pojo.UserInfo;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
*  DAO层
*  处于处理service层与mysql之间的一个缓冲层
*  service从DAO层中获取已经从数据库中获取数据的pojo
*  同时,service也可以通过DAO层向数据库提交数据/修改数据
*  骚点的操作就构造干活,慢点的就构造完起手
* */

public class UserDAO {
    public UserInfo getUserInfo() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from User";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        return null;
    }
}

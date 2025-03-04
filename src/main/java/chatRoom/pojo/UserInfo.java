package chatRoom.pojo;
import lombok.Data;

/*
* pojo(model)层
* 设计数据结构,每一个pojo类中的各变量对应数据库中一张表的各字段
* 例如这个UserInfo类就对应了数据库中的User表
* */


@Data
public class UserInfo {
    private String userid;
    // 用户名
    private String username;
    // 用户邮箱
    private String email;
    // 用户密码(应该是选填)
    private String password;
}

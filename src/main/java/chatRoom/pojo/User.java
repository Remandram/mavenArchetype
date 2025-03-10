package chatRoom.pojo;
import lombok.Data;

/*
* pojo(model)层
* 设计数据结构,每一个pojo类中的各变量对应数据库中一张表的各字段
* 例如这个User类就对应了数据库中的user表
* */


@Data
public class User {
    // 用户id
    private String uid;
    // 用户名
    private String name;
    // 用户邮箱
    private String mail;
    // 用户密码(应该是选填)
    private String password;
}

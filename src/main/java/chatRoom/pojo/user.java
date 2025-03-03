package chatRoom.pojo;
import lombok.Data;

@Data
public class user {
    // 用户名
    private String username;
    // 用户邮箱
    private String email;
    // 用户手机号
    private String telephone;
    // 用户密码(应该是选填)
    private String password;
}

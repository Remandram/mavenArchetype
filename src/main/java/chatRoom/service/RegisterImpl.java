package chatRoom.service;
import chatRoom.dao.UserDAO;
import chatRoom.pojo.User;

public class RegisterImpl implements Register {

    @Override
    public User isRegister(User user) {
        User user1 = UserDAO.query(user);
        if (user1 != null) {
            return user1;
        }
        return null;
    }

    @Override
    public int userRegister(User User) {
        return 0;
    }


}

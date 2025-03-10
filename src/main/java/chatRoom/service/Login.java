package chatRoom.service;

import chatRoom.pojo.User;

public interface Login {

    int queryUserByUsername(String username);

    int queryUserByEmail(String email);

    int isLogin(User user);

    int userLogin(User User);

}

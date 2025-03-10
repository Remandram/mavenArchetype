package chatRoom.service;

import chatRoom.pojo.User;

public interface Register {
    User isRegister(User user);
    int userRegister(User User);
}

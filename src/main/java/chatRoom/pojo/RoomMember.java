package chatRoom.pojo;

import lombok.Data;

@Data
public class RoomMember {
    // room name
    private String rid;
    // user name
    private String uid;
    // user fake name in group
    private String nickName;
}


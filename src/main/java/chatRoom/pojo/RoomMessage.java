package chatRoom.pojo;

import lombok.Data;

@Data
public class RoomMessage {
    // user id
    private String uid;
    // room id
    private String rid;
    // 是否为群聊
    private boolean isGroup;
}

package ch.viascom.hipchat.api.response.models;

import ch.viascom.hipchat.api.models.room.RoomPrivacy;
import lombok.Data;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class GetAllRoomsResponseItem {
    private String name;
    private RoomPrivacy privacy;
    private boolean is_archived;
    private String version;
    private int id;
}
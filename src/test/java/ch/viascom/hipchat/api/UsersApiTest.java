package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.PrivateMessage;
import ch.viascom.hipchat.api.models.User;
import ch.viascom.hipchat.api.models.message.MessageFormat;
import ch.viascom.hipchat.api.models.user.UserPhotoSize;
import ch.viascom.hipchat.api.models.user.UserRole;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Ignore
public class UsersApiTest {

    private static final String clientToken = "";
    private static String testBotUserId = "";

    @Test
    public void getAllUsersTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        GetAllUsersResponse getAllUsersResponse = hipChat.usersApi().getAllUsers(new GetAllUsers(0, 100, true, true));
    }

    @Test
    public void createUserTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);

        CreateUser createUser = new CreateUser();
        createUser.setEmail("info@viascom.ch");
        createUser.setGroup_admin(false);
        createUser.setMention_name("HipChatBot");
        createUser.setName("HipChat-Bot");
        createUser.getRoles().add(UserRole.USER);
        createUser.setTimezone("CET");
        createUser.setTitle("Viascom Bot");

        hipChat.usersApi().createUser(createUser);
    }

    @Test
    public void viewUserTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        User user = hipChat.usersApi().viewUser(testBotUserId);
    }

    @Test
    public void deleteUserTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().deleteUser(testBotUserId);
    }

    @Test
    public void updateUserTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);

        UpdateUser updateUser = new UpdateUser();
        updateUser.setEmail("info@viascom.ch");
        updateUser.setGroup_admin(false);
        updateUser.setMention_name("HipChatBot");
        updateUser.setName("HipChat-Bot");
        updateUser.getRoles().add(UserRole.USER);
        updateUser.setTimezone("CET");
        updateUser.setTitle("Viascom Test Bot");

        hipChat.usersApi().updateUser(testBotUserId, updateUser);
    }

    @Test
    public void sendPrivateMessage() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().sendPrivateMessage(testBotUserId, new PrivateMessage("Hi", true, MessageFormat.TEXT));
    }

    @Test
    public void getPhotoTest() throws FoxHttpException, IOException {
        HipChat hipChat = new HipChat(clientToken);
        InputStream response = hipChat.usersApi().getPhoto(testBotUserId, UserPhotoSize.SMALL.toString());

//        final Path destination = Paths.get(); // Place here your path
//        Files.copy(response, destination);
    }

    @Test
    public void updatePhotoTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().updatePhoto(testBotUserId, new UpdateUserPhoto("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"));
    }

    @Test
    public void deletePhotoTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().deletePhoto(testBotUserId);
    }

    @Test
    public void getAutoJoinRoomsTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().getAutoJoinRooms(testBotUserId, "0", "100");
    }

    @Test
    public void viewPrivatechatHistoryTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersApi().viewPrivatechatHistory(testBotUserId, new ViewPrivatechatHistory(0, 100));
    }
}

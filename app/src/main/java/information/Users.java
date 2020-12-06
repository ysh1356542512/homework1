package information;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Users implements Serializable {
    public int imageId;
    public String usersName;
    public String usersMessage;
    public String title;

    public Users(){}
    public Users(int imageId,String usersName,String usersMessage){
        this.imageId = imageId;
        this.usersMessage = usersMessage;
        this.usersName = usersName;
    }
    public Users(int imageId,String usersName,String usersMessage,String title){
        this.imageId = imageId;
        this.usersName = usersName;
        this.usersMessage = usersMessage;
        this.title = title;
    }

    public String getTitle(){return title;}
    public String getUsersName() {
        return usersName;
    }

    public String getUsersMessage() {
        return usersMessage;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public void setUsersMessage(String usersMessage) {
        this.usersMessage = usersMessage;
    }


}

package information;

import java.io.Serializable;

public class DyUsers implements Serializable {
    public int imageId;
    public String viewText;
    public int imageIcon;

    public DyUsers(){};
    public DyUsers(int imageId,String viewText){
        this.imageId = imageId;
        this.viewText = viewText;
    }
    public DyUsers(int imageId, String text, int imageIcon) {
        this.imageId = imageId;
        viewText = text;
        this.imageIcon = imageIcon;
    }

    public int getImageId() {
        return imageId;
    }

    public String getviewText() {
        return viewText;
    }


    public int getImageIcon() {
        return imageIcon;
    }
}

package ontime.app.model.usernewmain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserItemResponceData {
    @SerializedName("items")
    @Expose
    private List<UserItem> itemsa = null;

    public List<UserItem> getUserItem() {
        return itemsa;
    }

    public void setUserItem(List<UserItem> items) {
        this.itemsa = items;
    }


}

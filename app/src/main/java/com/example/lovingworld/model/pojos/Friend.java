package com.example.lovingworld.model.pojos;

import android.graphics.Bitmap;
import android.media.Image;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 甄大昌 on 2017/1/9.
 */
@DatabaseTable(tableName = "Friend")
public class Friend {
    @DatabaseField(id = true,columnName = "friendId")
    private String friendId;
    @DatabaseField(columnName = "sex")
    private int sex;
    @DatabaseField(columnName = "iconUrl")
    private String iconUrl;

    public Friend() {
    }

    public Friend(String friendId, int sex, String iconUrl) {
        this.friendId = friendId;
        this.sex = sex;
        this.iconUrl = iconUrl;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}

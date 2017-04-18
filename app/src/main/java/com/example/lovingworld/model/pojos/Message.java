package com.example.lovingworld.model.pojos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 甄大昌 on 2017/1/10.
 */
@DatabaseTable(tableName = "Message")
public class Message
{
    @DatabaseField(generatedId = true,columnName = "messageId")
    private int messageId;
    @DatabaseField(columnName = "sendUser")
    private String sendUserId;
    @DatabaseField(columnName = "acceptUser")
    private String acceptUserId;
    @DatabaseField(columnName = "sendTime")
    private int sendTime;
    @DatabaseField(columnName = "acceptTime")
    private int acceptTime;
    @DatabaseField(columnName = "messageContent")
    private String messageContent;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public int getSendTime() {
        return sendTime;
    }

    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    public int getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(int acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}

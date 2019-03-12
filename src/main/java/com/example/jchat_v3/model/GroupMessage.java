package com.example.jchat_v3.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_message")
public class GroupMessage {

    @Id
    @Column(name = "gm_id", unique = true)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ChatUser.class)
    @JoinColumn(name = "sender_id")
    private ChatUser sender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ChatGroup.class)
    @JoinColumn(name = "group_id")
    private ChatGroup group;

    @Column(name = "gm_content")
    private String content;

    @Column(name = "gm_send_time")
    private Date sendTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatUser getSender() {
        return sender;
    }

    public void setSender(ChatUser sender) {
        this.sender = sender;
    }

    public ChatGroup getGroup() {
        return group;
    }

    public void setGroup(ChatGroup group) {
        this.group = group;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}

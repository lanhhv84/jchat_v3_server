package com.example.jchat_v3.model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "chat_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ChatUser.class)
    @JoinColumn(name = "sender_id")
    private ChatUser sender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ChatUser.class)
    @JoinColumn(name = "receiver_id")
    private ChatUser receiver;

    @Column(name = "m_content")
    private String content;


    @Column(name = "send_date")
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

    public ChatUser getReceiver() {
        return receiver;
    }

    public void setReceiver(ChatUser receiver) {
        this.receiver = receiver;
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

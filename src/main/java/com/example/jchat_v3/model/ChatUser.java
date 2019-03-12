package com.example.jchat_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_data")
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private int id;

    @Column(name = "u_username", unique = true, length = 32)
    private String username;

    @Column(name = "u_password", length = 32)
    private String password;

    @Column(name = "u_nickname", length = 64)
    private String nickName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "group_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private Set<ChatGroup> groups = new HashSet<>();

    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private Set<Message> sendMessages = new HashSet<>();

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    private Set<Message> receiveMessages = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ChatGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<ChatGroup> groups) {
        this.groups = groups;
    }

    public Set<Message> getSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(Set<Message> sendMessages) {
        this.sendMessages = sendMessages;
    }

    public Set<Message> getReceiveMessages() {
        return receiveMessages;
    }

    public void setReceiveMessages(Set<Message> receiveMessages) {
        this.receiveMessages = receiveMessages;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

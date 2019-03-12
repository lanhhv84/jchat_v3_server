package com.example.jchat_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "chat_group")
public class ChatGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", unique = true)
    private int id;

    @Column(name = "group_name", unique = true)
    private String name;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "group_user",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<ChatUser> users = new HashSet<ChatUser>();


    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private Set<GroupMessage> groupMessages = new HashSet<GroupMessage>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ChatUser> getUsers() {
        return users;
    }

    public void setUsers(Set<ChatUser> users) {
        this.users = users;
    }

    public Set<GroupMessage> getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(Set<GroupMessage> groupMessages) {
        this.groupMessages = groupMessages;
    }
}

package com.kiongast.driftingBottle.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class AppUser implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String gender;
    @Column
    private String name;
    @OneToMany(mappedBy = "receiver")
    private List<Message> receivedMessages;
    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}

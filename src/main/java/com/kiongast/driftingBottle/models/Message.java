package com.kiongast.driftingBottle.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Message implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long Id;
    @Column
    private String content;
    @Column
    private Long createTime;
    @ManyToOne
    @JoinColumn(name="receiver_id", nullable = false)
    private AppUser receiver;
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private AppUser sender;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public AppUser getReceiver() {
        return receiver;
    }

    public void setReceiver(AppUser receiver) {
        this.receiver = receiver;
    }

    public AppUser getSender() {
        return sender;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }
}

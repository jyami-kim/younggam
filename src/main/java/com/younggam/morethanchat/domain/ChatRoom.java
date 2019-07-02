package com.younggam.morethanchat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChatRoom {
    @Column()
    private String chatRoomCode;

    @Column()
    private CustomerUser customerUserId;

    @Column()
    @ManyToOne()
    @JoinColumn()
    private ProviderUser providerUserId;

    private String regDate;
}

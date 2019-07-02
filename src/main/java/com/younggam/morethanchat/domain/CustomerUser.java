package com.younggam.morethanchat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"chatroom_code", "device_id"}))
public class CustomerUser {
    @Id
    private Long id;

    @Column(name="device_id")
    private String device_id;

    @Column(name="chatroom_code")
    private String chatRoomCode;

    private String name;
    private String phoneNum;
    private String regDate;
}

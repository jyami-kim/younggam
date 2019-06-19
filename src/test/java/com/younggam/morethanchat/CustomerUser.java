package com.younggam.morethanchat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CustomerUser {
    @Id
    private Long id;
    private String device_id;
    private String chatRoomCode;
    private String name;
    private String phoneNum;
    private String regDate;
}

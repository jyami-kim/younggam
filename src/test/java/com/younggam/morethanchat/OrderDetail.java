package com.younggam.morethanchat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class OrderDetail {
    @Id
    private Long id;


}

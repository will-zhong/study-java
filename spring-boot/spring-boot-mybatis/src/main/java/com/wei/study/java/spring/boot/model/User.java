package com.wei.study.java.spring.boot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "user")
public class User {

    private Integer id;
    private String name;
    private Date createTime;
}

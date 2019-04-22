package com.entity;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: User
 */


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="user")
public class User {

    private Integer id;
    private String username;
    private String password;


    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native" ,strategy="native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

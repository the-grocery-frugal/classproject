package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 4, 2019 6:31:11 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Users  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false, unique=true)
    private long id;
    
    @Column(name="username", length=20, nullable=false)
    private String username;
    
    @Column(name="password", length=80, nullable=false)
    private String password;

    public Users() {
    }

    public Users(long id, String username, String password) {
       this.id = id;
       this.username = username;
       this.password = password;
    }
    
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

     @Override
    public String toString(){
        return this.username + " " + this.password;
    }


}



package com.su.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    private Long id;

    private String login;
    private String firstName;
    private String lastName;

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "owner")
    private List<Lot> lots;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User {" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

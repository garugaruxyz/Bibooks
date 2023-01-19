package com.assignment.three.bibooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Builder
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "idUser", unique = true)
    @GeneratedValue
    private Long idUser;
    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin;
    @OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> allUsers;


    protected User() {
    }

    public User(String registrationNumber, String firstName, String lastName, String username, Boolean isAdmin) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Long getId() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}

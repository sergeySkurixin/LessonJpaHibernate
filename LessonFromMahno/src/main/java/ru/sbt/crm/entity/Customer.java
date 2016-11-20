package ru.sbt.crm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    private Long id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private Address address;


    @Id
    @GeneratedValue
    @Column(name = "customerId", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "firstName", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressid", nullable = true)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

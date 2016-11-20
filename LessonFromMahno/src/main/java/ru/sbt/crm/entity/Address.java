package ru.sbt.crm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADDRESS")
public class Address {
    private Long id;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String street1;
    private String street2;
    private List<Customer> customers;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "addressId", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "state", nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "postalCode", nullable = false)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "street1", nullable = false)
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @Column(name = "street2", nullable = false)
    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

//    EMPLOYEE (table)
//    ID 	FIRSTNAME 	LASTNAME
//    1 	Bob 	Way
//    2 	Sarah 	Smith
//
//    EMP_PROJ (table)
//    EMP_ID 	PROJ_ID
//    1 	1
//            1 	2
//            2 	1
//
//    PROJECT (table)
//    ID 	NAME
//    1 	GIS
//    2 	SIG

//    @ManyToMany
//    @JoinTable(
//            name="EMP_PROJ",
//            joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="ID"),
//            inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="ID"))
//    private List<Project> projects;
}

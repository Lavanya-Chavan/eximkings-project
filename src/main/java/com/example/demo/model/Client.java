package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "contact_number"),
    @UniqueConstraint(columnNames = "gst_number")
})
public class Client {

    @Id
    @Column(name = "client_id", length = 10)
    private String clientId;  // e.g., CL1, CL2, ...

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "contact_first_name", nullable = false)
    private String contactFirstName;

    @Column(name = "contact_last_name")
    private String contactLastName;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_type", nullable = false)
    private ClientType clientType;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "gst_number", unique = true)
    private String gstNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "requirement_type")
    private RequirementType requirementType;

    @Column(name = "bag_length")
    private Double bagLength;

    @Column(name = "bag_width")
    private Double bagWidth;

    @Column(name = "bag_height")
    private Double bagHeight;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "notes")
    private String notes;

    public enum ClientType {
        Gold, Silver, Platinum
    }

    public enum RequirementType {
        Jute_Bags, Paper_Bags
    }

    // ====== Getters and Setters ======

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public RequirementType getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(RequirementType requirementType) {
        this.requirementType = requirementType;
    }

    public Double getBagLength() {
        return bagLength;
    }

    public void setBagLength(Double bagLength) {
        this.bagLength = bagLength;
    }

    public Double getBagWidth() {
        return bagWidth;
    }

    public void setBagWidth(Double bagWidth) {
        this.bagWidth = bagWidth;
    }

    public Double getBagHeight() {
        return bagHeight;
    }

    public void setBagHeight(Double bagHeight) {
        this.bagHeight = bagHeight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

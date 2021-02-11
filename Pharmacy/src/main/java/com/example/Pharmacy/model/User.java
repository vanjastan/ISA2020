package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails, Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String number;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String roleType;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @Column (name = "isAdmin")
    private boolean isAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    @OneToOne(mappedBy = "patient")
    private Subscribed subscribed;

    @OneToOne(mappedBy = "supplier")
    private OrderFormOffers orderFormOffers;

    @ManyToMany
    @JoinTable(name = "pharmacy_dermatologist",
            joinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
    private Set<Pharmacies> pharmaciesD = new HashSet<Pharmacies>();

    @ManyToMany
    @JoinTable(name = "pharmacy_pharmacists",
            joinColumns = @JoinColumn(name = "pharmacist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
    private Set<Pharmacies> pharmaciesP = new HashSet<Pharmacies>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<EPrescription> prescriptions = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Examination> examinations = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<ExaminationPh> examinationsByPh = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Meds> reservedMeds = new HashSet<Meds>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "adminPh", cascade = CascadeType.ALL)
    private Pharmacies pharmacies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaints> complaints;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Pharmacies> subscribedPharmacies = new HashSet<Pharmacies>();

	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminph", cascade = CascadeType.ALL)
    private Set<OrderFormOffers>  orderFormOffer = new HashSet<>();

    public User() {

    }

    public User(String name, String surname, String username, String address, String city, String country, String number, String email, String password, String roleType, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.address = address;
        this.city = city;
        this.country = country;
        this.number = number;
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        Timestamp now = new Timestamp(new Date().getTime());
        this.setLastPasswordResetDate( now );
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EPrescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<EPrescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<Meds> getReservedMeds() {
        return reservedMeds;
    }

    public void setReservedMeds(Set<Meds> reservedMeds) {
        this.reservedMeds = reservedMeds;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<Authority> getUserAuthorities() {
        if (this.authorities == null) {
            this.authorities = new ArrayList<>();
        }

        return this.authorities;
    }

    public Set<ExaminationPh> getExaminationsByPh() {
        return examinationsByPh;
    }

    public void setExaminationsByPh(Set<ExaminationPh> examinationsByPh) {
        this.examinationsByPh = examinationsByPh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Set<Pharmacies> getPharmaciesP() {
        return pharmaciesP;
    }

    public void setPharmaciesP(Set<Pharmacies> pharmaciesP) {
        this.pharmaciesP = pharmaciesP;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Pharmacies> getPhDermatologist() {
        return pharmaciesD;
    }

    public Set<Pharmacies> getSubscribedPharmacies() {
        return subscribedPharmacies;
    }

    public void setSubscribedPharmacies(Set<Pharmacies> subscribedPharmacies) {
        this.subscribedPharmacies = subscribedPharmacies;

    public Set<Pharmacies> getPhPharmacist(){
        return pharmaciesP;
    }

    public Pharmacies getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Pharmacies pharmacies) {
        this.pharmacies = pharmacies;
    }
}

//package com.andreirosca.gamesstoreapi.model.user_account;
//
//import com.andreirosca.gamesstoreapi.model.Customer;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="User Accounts")
//public class UserAccount {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Column(name="LoginName")
//    private String LoginName;
//
//    @Column(name="FirstName")
//    private String FirstName;
//
//    @Column(name="MiddleName")
//    private String MiddleName;
//
//    @Column(name="LastName")
//    private String LastName;
//
//    @Column(name="Email")
//    private String Email;
//
//    @Column(name="Password")
//    private String PasswordHash;
//
//    @Column(name="CreationDate")
//    private LocalDateTime CreationDate;
//
//    @Column(name="ChangeDate")
//    private LocalDateTime ChangeDate;
//
//    @Column(name="LastAccessDate")
//    private LocalDateTime LastAccessDate;
//
//    @Column(name="IsLockedOut")
//    private boolean IsLockedOut;
//
//    @Column(name="LockoutDate")
//    private LocalDateTime LockoutDate;
//
//    @Column(name="IsActive")
//    private boolean IsActive;
//
//
////    @ManyToMany(cascade = { CascadeType.ALL })
////    @JoinTable(
////            name = "UserRole",
////            joinColumns = { @JoinColumn(name = "user_id") },
////            inverseJoinColumns = { @JoinColumn(name = "role_id") }
////    )
////    private Set<Role> roles = new HashSet<>();
//
//
////    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
////    @PrimaryKeyJoinColumn
////    private Customer customer;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Right> right = new HashSet<>();
//
//    // Mapping to the other table
//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<UserAccess> userAccesses;
//}

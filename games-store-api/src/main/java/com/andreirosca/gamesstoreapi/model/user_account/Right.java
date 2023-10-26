//package com.andreirosca.gamesstoreapi.model.user_account;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Rights")
//public class Right {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Column(name = "name")
//    private String Name;
//
//    @Column(name="description")
//    private String Description;
//
//    @Column(name="IsActive")
//    private boolean IsActive;
//
//
////    @OneToMany(mappedBy = "right")
////    private Set<UserAccount> userAccounts;
////
////    @ManyToMany(mappedBy = "right")
////    private Set<Role> roles = new HashSet<>();
//
//
//}

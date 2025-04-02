//package br.senai.sc.security.model.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Data
//@Entity
//public class UsuarioCompleto implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(unique = true, nullable = false)
//    private String username;
//    @Column(nullable = false)
//    private String password;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//
//}

package com.dio.santander.bankLine.api.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Data
@Table(name = "tab_userAuthentication")
public class UserAuthentication {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_user;

        @Column(length = 50, unique = true)
        private String userName;

        @Column(length = 50, unique = true)
        private String userEmail;

        private String userPassword;

        @Enumerated(EnumType.STRING)
        private UsuarioTipo userType;

}

package com.example.technikonproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "webUsers")
@SequenceGenerator(name = "idGenerator", sequenceName = "web_user_seq", allocationSize = 1)
public class WebUser extends BaseModel {

    @Column(unique = true, updatable = false)
    @Digits(integer = 9,fraction = 0)
    private Long tin;

    @Column(length = 50, nullable = false, updatable = false)
    private String firstName;

    @Column(length = 50, nullable = false, updatable = false)
    private String surname;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20, unique = true, updatable = false)
    private String username;

    @Column(nullable = false)
    private String role;
}

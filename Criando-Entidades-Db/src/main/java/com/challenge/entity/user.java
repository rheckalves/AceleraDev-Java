package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String fullName;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String nickName;

    @NotBlank
    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<candidate> candidates;

    @OneToMany
    private List<submission> submissions;
}
